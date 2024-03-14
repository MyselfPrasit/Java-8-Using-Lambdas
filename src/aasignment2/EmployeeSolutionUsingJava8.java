package aasignment2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeSolutionUsingJava8 {

	public static void main(String[] args) {

		List<Employee> employeeList = new ArrayList<Employee>();
		
		createEmployeeList(employeeList);
		
		task1Solution(employeeList);
		
		task2Solution(employeeList);
		
		task3Solution(employeeList);
		
		task4Solution(employeeList);
		
		task5Solution(employeeList);
		
		task6Solution(employeeList);
		
		task7Solution(employeeList);
		
		task8Solution(employeeList);
		
		task9Solution(employeeList);
		
		task10Solution(employeeList);
		
		task11Solution(employeeList);
		
		task12Solution(employeeList);
		
		task13Solution(employeeList);
		
		task14Solution(employeeList);
		
		task15Solution(employeeList);
	}
	
	/**
	 * @param employeeList
	 */
	private static void createEmployeeList(List<Employee> employeeList) {
		employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));
	}
	
	
	/**
	 * @param employeeList
	 */
	private static void task1Solution(List<Employee> employeeList) {
		// How many male and female employees are there in the organization
		Map<String, Long> noOfMaleAndFemaleEmployees=employeeList.stream().
				collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println(noOfMaleAndFemaleEmployees);
	}
	
	/**
	 * @param employeeList
	 */
	private static void task2Solution(List<Employee> employeeList) {
		// Print the name of all departments in the organization
		employeeList.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);
	}

	/**
	 * @param employeeList
	 */
	private static void task3Solution(List<Employee> employeeList) {
		// What is the average age of male and female employees
		Map<String, Double> avgAgeOfMaleAndFemaleEmployees=
				employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
		System.out.println(avgAgeOfMaleAndFemaleEmployees);
	}
	
	/**
	 * @param employeeList
	 */
	private static void task4Solution(List<Employee> employeeList) {
		// Get the details of highest paid employee in the organization
		Optional<Employee> highestPaidEmployeeWrapper=
				employeeList.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
				         
				Employee highestPaidEmployee = highestPaidEmployeeWrapper.get();
				System.out.println("Details Of Highest Paid Employee : ");
				System.out.println("==================================");
				System.out.println("ID : "+highestPaidEmployee.getId());
				System.out.println("Name : "+highestPaidEmployee.getName());
				System.out.println("Age : "+highestPaidEmployee.getAge());
				System.out.println("Gender : "+highestPaidEmployee.getGender());
				System.out.println("Department : "+highestPaidEmployee.getDepartment());
				System.out.println("Year Of Joining : "+highestPaidEmployee.getYearOfJoining());
				System.out.println("Salary : "+highestPaidEmployee.getSalary());
	}
	
	/**
	 * @param employeeList
	 */
	private static void task5Solution(List<Employee> employeeList) {
		// Get the names of all employees who have joined after 2015
		employeeList.stream().filter(e -> e.getYearOfJoining() > 2015).map(Employee::getName).forEach(System.out::println);
	}
	
	/**
	 * @param employeeList
	 */
	private static void task6Solution(List<Employee> employeeList) {
		// Count the number of employees in each department
		Map<String, Long> employeeCountByDepartment=
				employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
				Set<Entry<String, Long>> entrySet = employeeCountByDepartment.entrySet();
				for (Entry<String, Long> entry : entrySet)
				{
				    System.out.println(entry.getKey()+" : "+entry.getValue());
				}
	}

	/**
	 * @param employeeList
	 */
	private static void task7Solution(List<Employee> employeeList) {
		// What is the average salary of each department
		Map<String, Double> avgSalaryOfDepartments= employeeList.stream().
				collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
		Set<Entry<String, Double>> avgEntryset = avgSalaryOfDepartments.entrySet();
		for (Entry<String, Double> entry : avgEntryset) 
			{
				System.out.println(entry.getKey()+" : "+entry.getValue());
			}
	}
	
	/**
	 * @param employeeList
	 */
	private static void task8Solution(List<Employee> employeeList) {
		// Get the details of youngest male employee in the product development department
		Optional<Employee> youngestMaleEmployeeInProductDevelopmentWrapper= employeeList.stream()
				.filter(e -> e.getGender()=="Male" && e.getDepartment()=="Product Development").min(Comparator.comparingInt(Employee::getAge));
				         
				Employee youngestMaleEmployeeInProductDevelopment = youngestMaleEmployeeInProductDevelopmentWrapper.get();
				System.out.println("Details Of Youngest Male Employee In Product Development");
				System.out.println("----------------------------------------------");
				System.out.println("ID : "+youngestMaleEmployeeInProductDevelopment.getId());
				System.out.println("Name : "+youngestMaleEmployeeInProductDevelopment.getName());
				System.out.println("Age : "+youngestMaleEmployeeInProductDevelopment.getAge());
				System.out.println("Year Of Joinging : "+youngestMaleEmployeeInProductDevelopment.getYearOfJoining());
				System.out.println("Salary : "+youngestMaleEmployeeInProductDevelopment.getSalary());
	}
	
	/**
	 * @param employeeList
	 */
	private static void task9Solution(List<Employee> employeeList) {
		// Who has the most working experience in the organization
				Optional<Employee> seniorMostEmployeeWrapper=
						employeeList.stream().sorted(Comparator.comparingInt(Employee::getYearOfJoining)).findFirst();
						Employee seniorMostEmployee = seniorMostEmployeeWrapper.get();
						System.out.println("Senior Most Employee Details :");
						System.out.println("----------------------------");
						System.out.println("ID : "+seniorMostEmployee.getId());
						System.out.println("Name : "+seniorMostEmployee.getName());
						System.out.println("Age : "+seniorMostEmployee.getAge());
						System.out.println("Gender : "+seniorMostEmployee.getGender());
						System.out.println("Age : "+seniorMostEmployee.getDepartment());
						System.out.println("Year Of Joinging : "+seniorMostEmployee.getYearOfJoining());
						System.out.println("Salary : "+seniorMostEmployee.getSalary());
	}
	
	/**
	 * @param employeeList
	 */
	private static void task10Solution(List<Employee> employeeList) {
		// How many male and female employees are there in the sales and marketing team
		Map<String, Long> countMaleFemaleEmployeesInSalesMarketing= employeeList.stream().filter(e -> e.getDepartment()=="Sales And Marketing")
								            .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println(countMaleFemaleEmployeesInSalesMarketing);
	}
	
	/**
	 * @param employeeList
	 */
	private static void task11Solution(List<Employee> employeeList) {
		// What is the average salary of male and female employees
		Map<String, Double> avgSalaryOfMaleAndFemaleEmployees=employeeList.stream().
				collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println(avgSalaryOfMaleAndFemaleEmployees);
	}
	
	/**
	 * @param employeeList
	 */
	private static void task12Solution(List<Employee> employeeList) {
		// List down the names of all employees in each department
		Map<String, List<Employee>> employeeListByDepartment=employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
		Set<Entry<String, List<Employee>>> employeeEntrySet = employeeListByDepartment.entrySet();
		for (Entry<String, List<Employee>> entry : employeeEntrySet) 
			{
				System.out.println("--------------------------------------");
				System.out.println("Employees In "+entry.getKey() + " : ");
				System.out.println("--------------------------------------");
				List<Employee> list = entry.getValue();
				  for (Employee e : list) 
				    {
				        System.out.println(e.getName());
				    }
			}
	}
	
	/**
	 * @param employeeList
	 */
	private static void task13Solution(List<Employee> employeeList) {
		// What is the average salary and total salary of the whole organization
		DoubleSummaryStatistics employeeSalaryStatistics= employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
		System.out.println("Average Salary = "+employeeSalaryStatistics.getAverage());
		System.out.println("Total Salary = "+employeeSalaryStatistics.getSum());
	}
	
	/**
	 * @param employeeList
	 */
	private static void task14Solution(List<Employee> employeeList) {
		// Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years
		Map<Boolean, List<Employee>> partitionEmployeesByAge=employeeList.stream().collect(Collectors.partitioningBy(e -> e.getAge() > 25));
				Set<Entry<Boolean, List<Employee>>> ageEntrySet = partitionEmployeesByAge.entrySet();
				for (Entry<Boolean, List<Employee>> entry : ageEntrySet) 
				{
				    System.out.println("----------------------------");
				    if (entry.getKey()) 
				        System.out.println("Employees older than 25 years :");
				    else
				        System.out.println("Employees younger than or equal to 25 years :");
				    System.out.println("----------------------------");
				    List<Employee> list = entry.getValue();
				    for (Employee e : list) 
				        System.out.println(e.getName());
				}
	}
	
	/**
	 * @param employeeList
	 */
	private static void task15Solution(List<Employee> employeeList) {
		// Who is the oldest employee in the organization? What is his age and which department he belongs to
		Optional<Employee> oldestEmployeeWrapper = employeeList.stream().max(Comparator.comparingInt(Employee::getAge));
		Employee oldestEmployee = oldestEmployeeWrapper.get();
		System.out.println("Name : "+oldestEmployee.getName());
		System.out.println("Age : "+oldestEmployee.getAge());
		System.out.println("Department : "+oldestEmployee.getDepartment());
	}

}
