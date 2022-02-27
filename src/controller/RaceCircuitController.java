package controller;

import java.util.List;

import dao.RaceCircuitDao;
import model.Data;
import model.RaceCircuit;
import model.RaceHorse;

public class RaceCircuitController {

	RaceCircuitDao raceCircuitDao = new RaceCircuitDao();

	public List<RaceCircuit> getAllRaceCircuits() {
		return Data.getRaceTrack().raceCircuits;
	}

	public void createRaceCircuit(String nameCircuit) {
		raceCircuitDao.createRaceCircuit(nameCircuit);
	}

	public void updateRaceCircuitName(RaceCircuit raceCircuit, String newNameCircuit) {
		raceCircuitDao.updateRaceCircuitName(raceCircuit, newNameCircuit);
	}

	public boolean deleteRaceCircuit(RaceCircuit raceCircuit) {
		return raceCircuitDao.deleteRaceCircuit(raceCircuit);
	}

	public boolean addRaceHorseToRaceCircuit(RaceCircuit raceCircuit, List<RaceHorse> raceHorseList) {
		return raceCircuitDao.addRaceHorseToRaceCircuit(raceCircuit, raceHorseList);
	}

}
