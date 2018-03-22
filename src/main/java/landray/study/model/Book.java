package landray.study.model;

import lombok.Data;

import java.util.Arrays;

/**
 * 图书类
 * @author CXW
 *
 */
@Data
public class Book {
	
	private int id;             //图书id

	private String bookName;      //图书名称
	 
	private Double bookPrice;     //图书价格
	
	private String browseFlag;    //图书是否被借阅
	
	private String bookHome;      //图书所在图书馆
	
    private String[] bookType;	  //图书类别
	
	private String bookMarks;     //图书简介

	private Home home;
}
