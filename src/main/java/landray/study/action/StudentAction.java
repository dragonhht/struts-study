package landray.study.action;

import landray.study.form.StudentForm;
import landray.study.service.StudentService;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description.
 *
 * @author: huang
 * Date: 18-3-22
 */
@Controller("/login")
public class StudentAction extends DispatchAction {

    @Autowired
    private StudentService studentService;

    public ActionForward login(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                               HttpServletResponse response) throws Exception {
        StudentForm form1 = (StudentForm) form;
        System.out.println("数据：" + form1);
        studentService.save(form1);
        return mapping.findForward("index");
    }
}
