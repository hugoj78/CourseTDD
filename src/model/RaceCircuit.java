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

	public RaceCircuit(String circuitName) {
		this.name = circuitName;
		this.raceHorses = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateLastCourse() {
		return dateLastCourse;
	}

	public void setDateLastCourse(Date dateLastCourse) {
		this.dateLastCourse = dateLastCourse;
	}

	public List<RaceHorse> getRaceHorses() {
		return raceHorses;
	}

	public void setRaceHorses(List<RaceHorse> raceHorses) {
		this.raceHorses = raceHorses;
	}

}
