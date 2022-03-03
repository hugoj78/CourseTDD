package model;

import java.util.ArrayList;
import java.util.List;

public class RaceHorse {

	public String name;
	public int age;
	public int nbrOfWin;
	public List<RaceCircuit> raceCircuits;

	public RaceHorse() {
		age = 0;
		nbrOfWin = 0;
		raceCircuits = new ArrayList<RaceCircuit>();
	}

	public RaceHorse(String horseName, int age) {
		this.name = horseName;
		this.age = age;
		this.nbrOfWin = 0;
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
