package model;

import java.util.ArrayList;
import java.util.List;

public class RaceTrack {

	public String name;
	public List<RaceHorse> raceHorses;
	public List<RaceCircuit> raceCircuits;

	public RaceTrack(String name) {
		this.name = name;
		this.raceHorses = new ArrayList<>();
		this.raceCircuits = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
