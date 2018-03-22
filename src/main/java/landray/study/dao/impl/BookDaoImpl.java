package landray.study.dao.impl;

import landray.study.dao.BookDao;
import landray.study.model.Book;
import landray.study.model.Home;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl extends HibernateDaoSupport implements BookDao {

	@Autowired
	public BookDaoImpl(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}

	@Override
	public void saveBook(Book book) {
		this.getHibernateTemplate().save(book);
	}

	@Override
	public List<Book> listBook() {
		
		return (List<Book>) this.getHibernateTemplate().find("from Book");
	}

	@Override
	public void updateBook(Book book) {
		this.getHibernateTemplate().update(book);
	}

	@Override
	public void deleteBookInfo(int id) {
		Book book = (Book) this.getHibernateTemplate().get(Book.class, id);
		this.getHibernateTemplate().clear();
		this.getHibernateTemplate().delete(book);
	}

	@Override
	public Book getBookById(int id) {
		return (Book) this.getHibernateTemplate().get(Book.class, id);
	}

	@Override
	public List<Home> getAllHome() {
		return (List<Home>) this.getHibernateTemplate().find("from Home");
	}
	

}
