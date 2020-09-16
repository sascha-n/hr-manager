package view;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

import db.EmployeeDB;
import models.Employee;
import util.HRManagerUtil;

public class View {

    private static final Scanner scanner = new Scanner(System.in);
    private static EmployeeDB db = new EmployeeDB();

    /**
     * Show the interface to add a employee to the db
     */
    public void showAddEmployee() {
        //TODO: implement
    	
    	Employee employee = new Employee();
    	
    	System.out.println("Prename: ");
    	String prename = scanner.nextLine();
    	
    	System.out.println("Surname: ");
    	String surname = scanner.nextLine();
    	
    	System.out.println("Job Description: ");
    	String jobDescription = scanner.nextLine();
    	
    	System.out.println("Birth date (e.g.: 01.01.1990): ");
    	String birthdateString = scanner.next();
    	
    	System.out.println("Salary: ");
    	Double salary = scanner.nextDouble();
    	
    	System.out.println("Employment date (e.g.: 01.09.2020): ");
    	String employmentDate = scanner.next();
    	
    	employee.setPrename(prename);
    	employee.setSurname(surname);
    	employee.setJobDescription(jobDescription);
    	
    	try {
			employee.setBirthdate(HRManagerUtil.formatter.parse(birthdateString));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	employee.setSalary(salary);
    	
    	try {
			employee.setEmploymentDate(HRManagerUtil.formatter.parse(employmentDate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	db.addEmployee(employee);
    }

    /**
     * Show the interface to edit a employee to the db
     */
    public void showEditEmployee() {
        //TODO: implement
    	showListEmployees();
    	
    	Employee employee = new Employee();
    	System.out.println("ID: ");
    	int id = scanner.nextInt();
    	
    	if (db.employeeExists(id) == true) {
    		System.out.println("Prename: ");
        	String prename = scanner.next();
        	
        	System.out.println("Surname: ");
        	String surname = scanner.next();
        	
        	System.out.println("Job Description: ");
        	String jobDescription = scanner.next();
        	
        	System.out.println("Birth date (e.g.: 01.01.1990): ");
        	String birthdateString = scanner.next();
        	
        	System.out.println("Salary: ");
        	Double salary = scanner.nextDouble();
        	
        	System.out.println("Employment date (e.g.: 01.09.2020): ");
        	String employmentDate = scanner.next();
        	
        	employee.setPrename(prename);
        	employee.setSurname(surname);
        	employee.setJobDescription(jobDescription);
        	
        	try {
    			employee.setBirthdate(HRManagerUtil.formatter.parse(birthdateString));
    		} catch (ParseException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        	
        	employee.setSalary(salary);
        	
        	try {
    			employee.setEmploymentDate(HRManagerUtil.formatter.parse(employmentDate));
    		} catch (ParseException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        	db.updateEmployee(employee);
    	}
    }

    /**
     * Show the list of all employees from the db
     */
    public void showListEmployees() {
        //TODO: implement
    	// formatter for the table
    	System.out.printf("%10s %30s %22s %40s %10s %22s", "ID", "NAME", "BIRTH DATE", "JOB DESCRIPTION", "SALARY", "EMPLOYMENT DATE");
    	
    	System.out.println(db.getEmployees().toString());
    }

    /**
     * Show the interface to delete a employee
     */
    public void showDeleteEmployee() {
        //TODO: implement
    	System.out.println("Enter the ID of the employee: ");
    	int id = scanner.nextInt();
    	db.deleteEmployee(null, id);
    }

    /**
     * Internal method to print out a employee
     * @param employee to show
     */
    private void showEmployee(Employee employee) {
        //TODO: implement
    }

}
