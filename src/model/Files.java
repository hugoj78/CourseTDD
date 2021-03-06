package model;

import java.util.List;

public class Files {
	public String name;
	public String path;
	public String extention;
	public List<String> firstline;
	public List<List<String>> data;

	public String getName() {
		return name;
	}

	public Files(String name, String path, String extention) {
		super();
		this.name = name;
		this.path = path;
		this.extention = extention;
	}

	public Files(String name, String path, String extention, List<String> firstline) {
		super();
		this.name = name;
		this.path = path;
		this.extention = extention;
		this.firstline = firstline;
	}

	public Files(String name, String path, String extention, List<String> firstline, List<List<String>> data) {
		super();
		this.name = name;
		this.path = path;
		this.extention = extention;
		this.firstline = firstline;
		this.data = data;
	}

	public String getExtention() {
		return extention;
	}

	public void setExtention(String extention) {
		this.extention = extention;
	}

	public List<String> getFirstline() {
		return firstline;
	}

	public void setFirstline(List<String> firstline) {
		this.firstline = firstline;
	}

	public List<List<String>> getData() {
		return data;
	}

	public void setData(List<List<String>> data) {
		this.data = data;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
