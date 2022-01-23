package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employees;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);

		List<Employees> list = new ArrayList<>();
		System.out.println("Exercise number 1");
		System.out.println("How many employees will be registred? ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.print("");
			System.out.println("Employoee #" + (i + 1) + ":");
			System.out.print("Id: ");
			Integer id = sc.nextInt();
			while (hasId(list, id)) {
				System.out.println("Id already taken! Ty again: ");
				id = sc.nextInt();
			}
			
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Wage: ");
			double wage = sc.nextDouble();

			Employees emp = new Employees(id, name, wage);

			list.add(emp);

		}

		System.out.println("Enter the employee id that will have salary increase: ");
		int idwage = sc.nextInt();
		
		Employees emp = list.stream().filter(x -> x.getId() == idwage).findFirst().orElse(null);
		
		//Integer pos = position(list, idwage);
		
		if (emp == null) {
			System.out.println("");
			System.out.println("Id not found");
		} else {
			System.out.print("Enter the percentage: ");
			double percent = sc.nextDouble();
			emp.increaseWage(percent);
		}
		System.out.println("");
		System.out.println("List of employees: ");
		for (Employees e : list) {
			System.out.println(e);
		}

		sc.close();

	}

	/*public static Integer position(List<Employees> list, int id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				return i;
			}
		}
		return null;
	}
	*/
	public static boolean hasId(List<Employees> list, int id) {
		Employees emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}
}
