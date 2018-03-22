package landray.study.service;

import landray.study.form.BookForm;
import landray.study.model.Book;
import landray.study.model.Home;

import java.util.List;

public interface BookService {

	void saveBook(BookForm form);

	void deleteBook(String id);

	void updateBook(BookForm form);

	List<Book> showBooks();

	Book getBookById(String id);

	List<Home> getAllHome();

}