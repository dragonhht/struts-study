package landray.study.service;

import landray.study.form.HomeForm;
import landray.study.model.Home;

import java.util.List;

public interface HomeService {

	List<Home> showLibrary();

	void saveLibrary(HomeForm homeForm);

	void updateLibrary(HomeForm homeForm);

	void delLibrary(String id);

	Home getHomeById(String id);

	Home getHomeById(int id);

}