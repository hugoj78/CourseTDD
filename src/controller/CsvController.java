package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import dao.CsvDao;
import model.Files;
import model.RaceCircuit;
import model.RaceHorse;

public class CsvController {

	CsvDao csvDao = new CsvDao();
	SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");

	public ArrayList<RaceCircuit> getDataRaceCircuit(Files file) {

		List<List<String>> circuit = csvDao.getDataOnCsv(file);
		circuit.remove(0);
		ArrayList<RaceCircuit> arrayCircuit = new ArrayList<RaceCircuit>();

		for (int i = 0; i < circuit.size(); i++) {

			try {
				String name = circuit.get(i).get(0).toString();
				Date date = formatDate.parse(circuit.get(i).get(1).replaceAll("Z$", "+0000"));
				// TODO CHANGER AGE

				RaceHorse besthorse = new RaceHorse(circuit.get(i).get(2), 0);
				arrayCircuit.add(new RaceCircuit(name, date, besthorse));

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}

		}

		return arrayCircuit;

	}

	public ArrayList<RaceCircuit> getTenLastCircuit(ArrayList<RaceCircuit> arrayCircuit) {
		// TODO Auto-generated method stub
		Collections.sort(arrayCircuit);
		ArrayList<RaceCircuit> tenCircuit = new ArrayList<RaceCircuit>();

		int i = arrayCircuit.size();
		int e = 0;
		while ((i > 0) && (e < 10)) {
			tenCircuit.add(arrayCircuit.get(i - 1));

			i--;
			e++;
		}
		return tenCircuit;

	}

	public boolean saveCircuits(Files f, ArrayList<RaceCircuit> arrayCircuit) {
		List<List<String>> circuits = new ArrayList<>();

		for (int i = 0; i < arrayCircuit.size(); i++) {

			List<String> circuit = new ArrayList<String>();
			String name = arrayCircuit.get(i).getName();
			String date = formatDate.format(arrayCircuit.get(i).getDateLastCourse());
			String bestHosre = arrayCircuit.get(i).getRaceHorseWinner().getName();
			circuit.add(name);
			circuit.add(date);
			circuit.add(bestHosre);

			circuits.add(circuit);

		}

		List<String> firstline = new ArrayList<String>();

		firstline.add("name");
		firstline.add("date");
		firstline.add("RaceHorse");
		f.setFirstline(firstline);
		f.setData(circuits);

		if (csvDao.pathExist(f) == false) {
			boolean create = csvDao.createCsv(f);
			if (create == false) {
				return false;
			}

		}

		return csvDao.updateCsv(f);

		// TODO Auto-generated method stub

	}

}
