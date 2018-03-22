package landray.study.service.impl;

import landray.study.dao.StudentDao;
import landray.study.form.StudentForm;
import landray.study.model.Student;
import landray.study.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description.
 *
 * @author: huang
 * Date: 18-3-22
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    public void save(StudentForm form) {
        Student student = new Student();
        student.setId(form.getId());
        student.setName(form.getName());
        studentDao.save(student);
    }
}
