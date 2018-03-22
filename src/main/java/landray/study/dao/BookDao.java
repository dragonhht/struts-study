package landray.study.dao;

import landray.study.model.Book;
import landray.study.model.Home;

import java.util.List;

public interface BookDao {

	void saveBook(Book book);

	List<Book> listBook();

	void updateBook(Book book);

	void deleteBookInfo(int id);

	Book getBookById(int id);

	List<Home> getAllHome();

}