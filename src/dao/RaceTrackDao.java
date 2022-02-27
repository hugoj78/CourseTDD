package dao;

import model.Data;
import model.RaceTrack;

public class RaceTrackDao {

	public RaceTrack raceTrack = new RaceTrack("Leibinou Stadium");

	public RaceTrackDao() {
		Data.setRaceTrack(raceTrack);
	}

	public String getName() {
		return raceTrack.getName();
	}

	public void setName(String name) {
		raceTrack.setName(name);
	}
}
