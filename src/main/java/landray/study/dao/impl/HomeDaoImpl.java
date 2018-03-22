package landray.study.dao.impl;

import landray.study.dao.HomeDao;
import landray.study.model.Home;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HomeDaoImpl extends HibernateDaoSupport implements HomeDao {

	@Autowired
	public HomeDaoImpl(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}

	@Override
	public List<Home> showLibrary() {
		
		return (List<Home>) this.getHibernateTemplate().find("from Home");
	}

	@Override
	public void addLibrary(Home home) {
		this.getHibernateTemplate().save(home);
	}

	@Override
	public void updateLibrary(Home home) {
		this.getHibernateTemplate().update(home);
	}

	@Override
	public void delLibrary(int id) {
		Home home = (Home) this.getHibernateTemplate().get(Home.class, id);
		home.getBooks().clear();
		this.getHibernateTemplate().delete(home);
	}

	@Override
	public Home getHomeById(int id) {
		List<Home> list = (List<Home>) this.getHibernateTemplate().findByNamedParam("from Home where id =:id", "id", id);
		return list.get(0);
	}

}
