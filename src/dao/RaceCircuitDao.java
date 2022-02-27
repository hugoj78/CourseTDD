package dao;

import java.util.List;

import model.Data;
import model.RaceCircuit;
import model.RaceHorse;

public class RaceCircuitDao {

	public boolean createRaceCircuit(String circuitName) {
		return Data.getRaceTrack().raceCircuits.add(new RaceCircuit(circuitName));
	}

	public List<RaceCircuit> getAllRaceCircuit() {
		return Data.getRaceTrack().raceCircuits;
	}

	public void updateRaceCircuitName(RaceCircuit raceCircuit, String newCircuitName) {
		raceCircuit.setName(newCircuitName);
	}

	public boolean deleteRaceCircuit(RaceCircuit raceCircuit) {
		return Data.getRaceTrack().raceCircuits.remove(raceCircuit);
	}

	public boolean addRaceHorseToRaceCircuit(RaceCircuit raceCircuit, List<RaceHorse> raceHorseList) {
		if (raceHorseList.size() != 6) {
			return false;
		}
		return raceCircuit.raceHorses.addAll(raceHorseList);
	}

}
