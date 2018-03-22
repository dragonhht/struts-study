package landray.study.dao;

import landray.study.model.Home;

import java.util.List;

public interface HomeDao {

	List<Home> showLibrary();

	void addLibrary(Home home);

	void updateLibrary(Home home);

	void delLibrary(int id);

	Home getHomeById(int id);

}