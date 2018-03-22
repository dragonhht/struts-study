package landray.study.service.impl;

import landray.study.dao.BookDao;
import landray.study.form.BookForm;
import landray.study.model.Book;
import landray.study.model.Home;
import landray.study.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;

	@Override
	public void saveBook(BookForm form) {
		Book book = formToModel(form);
		if (book != null) {
			Home home = new Home();
			home.setId(form.getHomeId());
			book.setHome(home);
			bookDao.saveBook(book);
		}
	}


	@Override
	public void deleteBook(String id) {
		int n = Integer.parseInt(id);
		bookDao.deleteBookInfo(n);
	}


	@Override
	public void updateBook(BookForm form) {
		Book book = formToModel(form);
		if (book != null) {
			Home home = new Home();
			home.setId(form.getHomeId());
			book.setHome(home);
			bookDao.updateBook(book);
		}
	}


	@Override
	public List<Book> showBooks() {
		return bookDao.listBook();
	}

	@Override
	public Book getBookById(String id) {
		int n = Integer.parseInt(id);
		return bookDao.getBookById(n);
	}

	@Override
	public List<Home> getAllHome() {
		return bookDao.getAllHome();
	}
	
	
	private Book formToModel(BookForm bookForm) {
		if (bookForm != null) {
			Book book = new Book();
			if (bookForm.getBookName() != null && !bookForm.equals("")) {
				book.setBookHome(bookForm.getBookHome());
				book.setBookMarks(bookForm.getBookMarks());
				book.setBookName(bookForm.getBookName());
				book.setBookPrice(bookForm.getBookPrice());
				book.setBookType(bookForm.getBookType());
				book.setBrowseFlag(bookForm.getBrowseFlag());
				book.setId(bookForm.getId());
			}
			return book;
		}
		return null;
	}
	

}
