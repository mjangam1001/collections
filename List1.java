package com.mrunali.collectionpackage;

import java.time.LocalDateTime;
import java.util.*;

public class List1   {
	public static void main(String[] args) 
	{
		String city="Pune";
		ArrayList<Employee> emp = new ArrayList<Employee>();
		emp.add(new Employee("Pushkar","Mumbai",20000,LocalDateTime.of(1997, 9, 14, 06,30)));
		emp.add(new Employee("Animesh","Pune",22000,LocalDateTime.of(1996, 9, 14, 06,30)));
		emp.add(new Employee("Swara","Pune",21000,LocalDateTime.of(1996, 5, 1, 06,30)));
		emp.add(new Employee("Esha","Kolkata",21500,LocalDateTime.of(1997, 10, 14, 06,30)));
		emp.add(new Employee("Syed","Banglore",21700,LocalDateTime.of(1995, 9, 14, 06,30)));
		
		System.out.println("Average salary \n" +avgSalary(emp));
		sortArraylist(emp);
		System.out.println("Sorting according to salary\n" +emp);
		sortDOB(emp);
		System.out.println("Sorting according to DOB\n" +emp);
		System.out.println("Employees in Pune :\n" +searchCity(city, emp));
		
	}
	
	private static ArrayList<Employee> searchCity(String city, ArrayList<Employee> emp)
	{
		ArrayList<Employee> empsearch = new ArrayList<Employee>();
		for(Employee e:emp)
		{
			if(city.equals(e.getCity()))
				empsearch.add(e);
		}
		return empsearch;
	}
	
	private static ArrayList<Employee> sortArraylist(ArrayList<Employee> emp)
	{
		Collections.sort(emp, new Comparator<Employee>() {
			public int compare(Employee o1, Employee o2)
			{
				return Integer.compare(o2.getSalary(), o1.getSalary());
			}
			
		});
		return emp;
		
	}
	private static ArrayList<Employee> sortDOB(ArrayList<Employee> emp)
	{
		Collections.sort(emp, new Comparator<Employee>() {
			public int compare(Employee o1, Employee o2)
			{
				if(o1.getDob().isEqual(o2.getDob()))
				{
					return 0;
				}
				if(o1.getDob().isBefore(o2.getDob()))
				{
					return -1;
				}
				else
					return 1;
			}
			
		});
		return emp;
		
	}
	private static float avgSalary(ArrayList<Employee> emp)
	{
		float sum=0;
		int counter=0;
		for(Employee e:emp){
			sum=sum+e.getSalary();
			counter++;	
		}
		return sum/counter;
	}

}
