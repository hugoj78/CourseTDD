package model;

import java.util.ArrayList;
import java.util.List;

public class RaceHorse {

	public String name;
	public List<RaceCircuit> raceCircuits;

	public RaceHorse() {
		raceCircuits = new ArrayList<RaceCircuit>();
	}

	public RaceHorse(String horseName) {
		this.name = horseName;
		this.raceCircuits = new ArrayList<RaceCircuit>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<RaceCircuit> getRaceCircuits() {
		return raceCircuits;
	}

	public void setRaceCircuits(List<RaceCircuit> raceCircuits) {
		this.raceCircuits = raceCircuits;
	}
}
