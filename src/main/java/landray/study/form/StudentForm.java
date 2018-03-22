package landray.study.form;

import lombok.Data;
import org.apache.struts.action.ActionForm;

/**
 * Description.
 *
 * @author: huang
 * Date: 18-3-22
 */
@Data
public class StudentForm extends ActionForm {

    private int id;
    private String name;

}
