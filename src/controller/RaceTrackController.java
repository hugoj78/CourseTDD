package controller;

import dao.RaceTrackDao;

public class RaceTrackController {

	RaceTrackDao raceTrackDao = new RaceTrackDao();

	public String getRaceTrackName() {
		return raceTrackDao.getName();
	}

	public void setRaceTrackName(String name) {
		raceTrackDao.setName(name);
	}

}
