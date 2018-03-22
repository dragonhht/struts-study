package landray.study.dao.impl;

import landray.study.dao.StudentDao;
import landray.study.model.Student;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * Description.
 *
 * @author: huang
 * Date: 18-3-22
 */
@Repository
public class StudentDaoImpl extends HibernateDaoSupport implements StudentDao {

    @Autowired
    public StudentDaoImpl(SessionFactory sessionFactory) {
        this.setSessionFactory(sessionFactory);
    }

    public void save(Student student) {
        this.getHibernateTemplate().save(student);
    }
}
