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

	public void getDataTest() {

	}

	CsvDao csvDao = new CsvDao();

	public ArrayList<RaceCircuit> getLastTenDataRaceCircuit(Files file) {
		// TODO Auto-generated method stub
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
		List<List<String>> circuit = csvDao.getDataOnCsv(file.path, file.name, file.extention);
		System.out.println(circuit);
		circuit.remove(0);
		System.out.println(circuit);

		Date d = new Date();

		System.out.println(d);

		ArrayList<RaceCircuit> arraylist = new ArrayList<RaceCircuit>();

		for (int i = 0; i < circuit.size(); i++) {
			String name = circuit.get(i).get(0).toString();

			Date date = null;
			try {
				System.out.println(circuit.get(i).get(1));
				date = formatter.parse(circuit.get(i).get(1).replaceAll("Z$", "+0000"));

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RaceHorse besthorse = new RaceHorse(circuit.get(i).get(2));

			arraylist.add(new RaceCircuit(name, date, besthorse));
		}

		System.out.println(arraylist);
		Collections.sort(arraylist);

		System.out.println(arraylist);

		return arraylist;
	}

}
