package landray.study.form;

import lombok.Data;
import org.apache.struts.action.ActionForm;

@Data
public class HomeForm  extends ActionForm {

	private int id;
	private String homeName;
	private String homeMarks;
}
