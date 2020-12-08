package eu.fade.jpa;

import java.util.List;

import eu.fade.jpa.domain.Employee;
import eu.fade.jpa.domain.EmployeeService;
import eu.fade.jpa.domain.Name;

public class Main {

    private static EmployeeService service = new EmployeeService();

    private static void findByFirstName() {
        System.out.println("Executing findByFirstName");
        String queryString = "select e from Employee e where lower(e.firstName) = 'bruce'";

        List<Employee> employees = service.queryEmployees(queryString);
        employees.forEach(System.out::println);
    }

    private static void findByLastName() {
        System.out.println("Executing findByLastName");
        String queryString = "select e from Employee e where e.lastName like '%ew%'";

        List<Employee> employees = service.queryEmployees(queryString);
        employees.forEach(System.out::println);
    }

    private static void findByDateInService() {
        System.out.println("Executing findByDateInService");
        String queryString = "select e from Employee e where e.dateInService >= '2021-01-01'";

        List<Employee> employees = service.queryEmployees(queryString);
        employees.forEach(System.out::println);
    }

    private static void findByEmployeeNumber() {
        System.out.println("Executing findByEmployeeNumber");
        String queryString = "select e from Employee e where e.employeeNumber = '16100123 9928'";

        Employee employee = service.findEmployee(queryString);
        System.out.println(employee);
    }

    private static void getAverageWage() {
        System.out.println("Executing getAverageWage");
        String queryString = "select avg(e.wage) from Employee e";

        Double averageWage = service.getAverage(queryString);
        System.out.println(averageWage);
    }

    private static void numberForEachFunction() {
        System.out.println("Executing numberForEachFunction");
        String queryString = "select e.function, count(e) from Employee e group by e.function";

        List<Object[]> results = service.getGroupedBy(queryString);
        results.forEach(objects -> System.out.println(objects[0] + " -> " + objects[1]));
    }

    private static void getListOfNames() {
        System.out.println("Executing getListOfNames");

        List<Name> names = service.getListOfNames();
        names.forEach(name -> System.out.println(name.getFirstName() + " " + name.getLastName()));
    }

    private static void getAllEmployeesOfIt() {
        System.out.println("Executing getAllEmployeesOfIt");
        String queryString = "select e from Employee e left join e.departments d where d.name = 'IT'";

        List<Employee> employees = service.queryEmployees(queryString);
        employees.forEach(System.out::println);
    }

    private static void getEmployeeWithHighestWage() {
        System.out.println("Executing getAllEmployeesOfIt");
        String queryString = "select e from Employee e where e.wage = (select max(e1.wage) from Employee e1)";

        List<Employee> employees = service.queryEmployees(queryString);
        employees.forEach(System.out::println);
    }

    public static void main(String[] args) {
        findByFirstName();
        System.out.println("*********************************************************************************************************");
        System.out.println("       ");
        findByLastName();
        System.out.println("*********************************************************************************************************");
        System.out.println("       ");
        findByDateInService();
        System.out.println("*********************************************************************************************************");
        System.out.println("       ");
        findByEmployeeNumber();
        System.out.println("*********************************************************************************************************");
        System.out.println("       ");
        getAverageWage();
        System.out.println("*********************************************************************************************************");
        System.out.println("       ");
        numberForEachFunction();
        System.out.println("*********************************************************************************************************");
        System.out.println("       ");
        getListOfNames();
        System.out.println("*********************************************************************************************************");
        System.out.println("       ");
        getAllEmployeesOfIt();
        System.out.println("*********************************************************************************************************");
        System.out.println("       ");
        getEmployeeWithHighestWage();
        System.out.println("*********************************************************************************************************");
        System.out.println("       ");
    }
}
