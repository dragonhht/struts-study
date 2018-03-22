package landray.study.dao.impl;

import landray.study.dao.StudentDao;
import landray.study.model.Student;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

/**
 * Description.
 *
 * @author: huang
 * Date: 18-3-22
 */
public class StudentDaoImpl extends HibernateDaoSupport implements StudentDao {

    public void save(Student student) {
        this.getHibernateTemplate().save(student);
    }
}
