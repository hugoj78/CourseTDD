package model;

import java.util.ArrayList;
import java.util.List;

public class RaceHorse {

	public String name;
	public List<RaceCircuit> raceCircuits;

	public RaceHorse() {
		raceCircuits = new ArrayList<RaceCircuit>();
	}
}
