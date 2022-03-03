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

	public ArrayList<RaceCircuit> getDataRaceCircuit(Files file) {

		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
		List<List<String>> circuit = csvDao.getDataOnCsv(file.path, file.name, file.extention);
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
				e.printStackTrace();
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

}
