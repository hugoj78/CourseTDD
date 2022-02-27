package controller;

import dao.RaceHorseDao;
import model.RaceHorse;

public class RaceHorseController {

	RaceHorseDao raceHorseDao = new RaceHorseDao();

	public void createRaceHorse(String nameHorse) {
		raceHorseDao.createRaceHorse(nameHorse);
	}

	public void updateRaceHorseName(RaceHorse raceHorse, String newNameHorse) {
		raceHorseDao.updateRaceHorseName(raceHorse, newNameHorse);
	}

	public boolean deleteRaceHorse(RaceHorse raceHorse) {
		return raceHorseDao.deleteRaceHorse(raceHorse);
	}

}
