package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RaceCircuit {

	public String name;
	public Date dateLastCourse;
	public List<RaceHorse> raceHorses;

	public RaceCircuit() {
		raceHorses = new ArrayList<>();
	}
}
