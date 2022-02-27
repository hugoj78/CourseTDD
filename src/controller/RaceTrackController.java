package controller;

import dao.RaceTrackDao;
import model.RaceTrack;

public class RaceTrackController {

	RaceTrackDao raceTrackDao = new RaceTrackDao();

	public RaceTrack getRaceTrack() {
		return raceTrackDao.raceTrack;
	}

	public String getRaceTrackName() {
		return raceTrackDao.getName();
	}

	public void setRaceTrackName(String name) {
		raceTrackDao.setName(name);
	}

}
