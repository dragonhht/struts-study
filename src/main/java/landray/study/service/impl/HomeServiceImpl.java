package landray.study.service.impl;

import landray.study.dao.HomeDao;
import landray.study.form.HomeForm;
import landray.study.model.Home;
import landray.study.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeServiceImpl implements HomeService {

	@Autowired
	private HomeDao homeDao;

	@Override
	public List<Home> showLibrary() {
		return homeDao.showLibrary();
	}

	@Override
	public void addLibrary(HomeForm homeForm) {
		Home home = FormToModel(homeForm);
		if (home != null) {
			homeDao.addLibrary(home);
		}
	}

	@Override
	public void updateLibrary(HomeForm homeForm) {
		if (homeForm != null) {
			Home home = getHomeById(homeForm.getId());
			home.setHomeMarks(homeForm.getHomeMarks());
			home.setHomeName(homeForm.getHomeName());
			homeDao.updateLibrary(home);
		}
	}

	@Override
	public void delLibrary(String id) {
		int n = Integer.parseInt(id);
		homeDao.delLibrary(n);
	}

	@Override
	public Home getHomeById(String id) {
		int n = Integer.parseInt(id);
		return homeDao.getHomeById(n);
	}

	@Override
	public Home getHomeById(int id) {
		return homeDao.getHomeById(id);
	}
	
	private Home FormToModel(HomeForm homeForm) {
		if (homeForm != null) {
			Home home = new Home();
			home.setHomeMarks(homeForm.getHomeMarks());
			home.setHomeName(homeForm.getHomeName());
			home.setId(homeForm.getId());
			return home;
		}
		return null;
	}
	

}
