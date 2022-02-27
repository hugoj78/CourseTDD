package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RaceCircuit {

	public String name;
	public Date dateLastCourse;
	public List<RaceHorse> raceHorses;
	public RaceHorse raceHorseWinner;

	public RaceCircuit() {
		raceHorses = new ArrayList<>();
		raceHorseWinner = new RaceHorse();
	}

	public RaceCircuit(String circuitName) {
		this.name = circuitName;
		this.raceHorses = new ArrayList<>();
		this.raceHorseWinner = new RaceHorse();
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

	public RaceHorse getRaceHorseWinner() {
		return raceHorseWinner;
	}

	public void setRaceHorseWinner(RaceHorse raceHorseWinner) {
		this.raceHorseWinner = raceHorseWinner;
	}

}
