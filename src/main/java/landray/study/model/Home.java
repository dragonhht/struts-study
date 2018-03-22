package landray.study.model;

import lombok.Data;

import java.util.List;

@Data
public class Home {

	private int id;
	private List<Book> books;
	//图书馆名称
	private String homeName;
	//图书馆简介
	private String homeMarks;
	
}
