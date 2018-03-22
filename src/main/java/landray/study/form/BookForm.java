package landray.study.form;

import java.util.Arrays;

import lombok.Data;
import org.apache.struts.action.ActionForm;

/**
 * 图书表单类
 * @author CXW
 *
 */
@Data
public class BookForm  extends ActionForm{
	
	private int id;
	private String bookName;      //图书名称
	private Double bookPrice;     //图书价格
	private String browseFlag;    //图书是否被借阅
	private String bookHome;      //图书所在图书馆
    private String[] bookType;	  //图书类别
	private String bookMarks;     //图书简介
	private String test;
	private int homeId;
}
