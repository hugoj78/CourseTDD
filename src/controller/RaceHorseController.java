package controller;

import java.util.List;

import dao.RaceHorseDao;
import model.Data;
import model.RaceHorse;

public class RaceHorseController {

	RaceHorseDao raceHorseDao = new RaceHorseDao();

	public List<RaceHorse> getAllRaceHorses() {
		return Data.getRaceTrack().raceHorses;
	}

	public void createRaceHorse(String nameHorse) {
		raceHorseDao.createRaceHorse(nameHorse);
	}

	public void updateRaceHorseName(RaceHorse raceHorse, String newNameHorse) {
		raceHorseDao.updateRaceHorseName(raceHorse, newNameHorse);
	}

	public boolean deleteRaceHorse(RaceHorse raceHorse) {
		return raceHorseDao.deleteRaceHorse(raceHorse);
	}

	public RaceHorse getFirstRaceHorseByName(String raceHorseName) {
		return raceHorseDao.getFirstRaceHorseByName(raceHorseName);
	}

}
