package controller;

import dao.RaceHorseDao;
import model.RaceHorse;

public class RaceHorseController {

	RaceHorseDao raceHorseDao = new RaceHorseDao();

	public void createRaceHorse(String nameHorse) {
		// raceHorseDao.createRaceHorse(nameHorse);
	}

	public void updateRaceHorseName(String newNameHorse) {
		// TODO Auto-generated method stub

	}

	public boolean deleteRaceHorse(RaceHorse raceHorse) {
		return false;
	}

}
