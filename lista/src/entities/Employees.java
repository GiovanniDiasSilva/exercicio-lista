package entities;

public class Employees {

	private int id;
	private String name;
	private double wage;

	public Employees() {

	}

	public Employees(int id, String name, double wage) {
		this.id = id;
		this.name = name;
		this.wage = wage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {
		this.wage = wage;
	}

	public void increaseWage(double percentage) {
		wage += wage * percentage / 100.0;
	}

	@Override
	public String toString() {
		return "Employees [id= " + id + ", name= " + name + ", " + String.format("new wage %.2f", wage) + "]";
	}

}
