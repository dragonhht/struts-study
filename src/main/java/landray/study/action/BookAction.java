package landray.study.action;

import landray.study.form.BookForm;
import landray.study.model.Book;
import landray.study.model.Home;
import landray.study.service.BookService;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller("/bookman")
public class BookAction extends DispatchAction {

	@Autowired
	private BookService bookService;

	/**
	 *	展示所有图书信息.
	 */
	public ActionForward showBooks(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<Book> books = bookService.showBooks();
		request.setAttribute("books", books);
		return mapping.findForward("showbook");
	}
	
	public ActionForward toAddBookPage(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<Home> homes = getAllHome();
		request.setAttribute("homes", homes);
		return mapping.findForward("addbook");
	}
	
	public ActionForward addBook(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		BookForm bookForm = (BookForm) form;
		bookService.addBook(bookForm);
		return showBooks(mapping, bookForm, request, response);
	}
	
	public ActionForward delBook(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		bookService.deleteBook(id);
		return showBooks(mapping, form, request, response);
	}
	
	public ActionForward showUpdatePage(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		Book book = bookService.getBookById(id);
		BookForm bookForm = (BookForm)form;
		bookForm.setBookHome(book.getBookHome());
		bookForm.setBookMarks(book.getBookMarks());
		bookForm.setBookName(book.getBookName());
		bookForm.setBookPrice(book.getBookPrice());
		bookForm.setBookType(book.getBookType());
		bookForm.setBrowseFlag(book.getBrowseFlag());
		bookForm.setId(book.getId());
		bookForm.setHomeId(book.getHome().getId());
		request.setAttribute("book", bookForm);
		List<Home> homes = getAllHome();
		request.setAttribute("homes", homes);
		return mapping.findForward("editbook");
	}
	
	public ActionForward updateBook(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		BookForm bookForm = (BookForm) form;
		bookService.updateBook(bookForm);
		return showBooks(mapping, bookForm, request, response);
	}
	
	private List<Home> getAllHome() {
		return bookService.getAllHome();
	}
}
