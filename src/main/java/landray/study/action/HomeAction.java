package landray.study.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import landray.study.form.HomeForm;
import landray.study.model.Home;
import landray.study.service.HomeService;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller("/library")
public class HomeAction extends DispatchAction {

	@Autowired
	private HomeService service;

	public ActionForward addHome(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HomeForm homeForm = (HomeForm) form;
		service.saveLibrary(homeForm);
		return showHomes(mapping, homeForm, request, response);
	}

	public ActionForward updateHome(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		HomeForm homeForm = (HomeForm) form;
		service.updateLibrary(homeForm);
		
		return showHomes(mapping, homeForm, request, response);
	}
	
	public ActionForward updatePage(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String id = request.getParameter("id");
		Home home = service.getHomeById(id);
		HomeForm form2 = (HomeForm) form;
		form2.setId(home.getId());
		form2.setHomeMarks(home.getHomeMarks());
		form2.setHomeName(home.getHomeName());
		request.setAttribute("home", form2);
		return mapping.findForward("updateHome");
	}
	
	public ActionForward showHomes(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			List<Home> homes = service.showLibrary();
			request.setAttribute("homes", homes);
			return mapping.findForward("showhome");
	}
	
	public ActionForward deleteHome(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			
			String id = request.getParameter("id");
			service.delLibrary(id);
			return showHomes(mapping, form, request, response);
	}
	
	public ActionForward showLibraryBooks(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String id = request.getParameter("id");
		Home home = service.getHomeById(id);
		request.setAttribute("home", home);
		return mapping.findForward("showlibrarybooks");
		
	}
}
