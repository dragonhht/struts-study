package landray.study.service.impl;

import landray.study.dao.StudentDao;
import landray.study.form.StudentForm;
import landray.study.model.Student;
import landray.study.service.StudentService;
import org.springframework.transaction.annotation.Transactional;

/**
 * Description.
 *
 * @author: huang
 * Date: 18-3-22
 */
public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Transactional
    public void save(StudentForm form) {
        Student student = new Student();
        student.setId(form.getId());
        student.setName(form.getName());
        studentDao.save(student);
    }
}
