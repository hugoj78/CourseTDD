package dao;

import java.util.List;

import model.Data;
import model.RaceHorse;

public class RaceHorseDao {

	public List<RaceHorse> getAllRaceHorse() {
		return Data.getRaceTrack().raceHorses;
	}

	public boolean createRaceHorse(String horseName, int age) {
		return Data.getRaceTrack().raceHorses.add(new RaceHorse(horseName, age));
	}

	public void updateRaceHorseName(RaceHorse raceHorse, String newHorseName) {
		raceHorse.setName(newHorseName);
	}

	public boolean deleteRaceHorse(RaceHorse raceHorse) {
		return Data.getRaceTrack().raceHorses.remove(raceHorse);
	}

	public RaceHorse getFirstRaceHorseByName(String raceHorseName) {
		List<RaceHorse> raceHorses = Data.getRaceTrack().raceHorses;
		for (int i = 0; i < raceHorses.size(); i++) {
			if (raceHorses.get(i).name.equals(raceHorseName)) {
				return raceHorses.get(i);
			}
		}
		return null;
	}

}
