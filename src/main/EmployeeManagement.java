package main;

import people.Employee;
import java.util.ArrayList;

public class EmployeeManagement {
    public Employee addEmployee() {
        Employee employee = new Employee("nome", 10);
        return employee;
    }

    public Employee removeEmployee() {
        Employee employee = new Employee("nome", 10);
        return employee;
    }

    public void showAllEmployees(ArrayList<Employee> employees){
        System.out.println(employees);
    }

    public Employee findEmployee(int cpf, ArrayList<Employee> employees) {
        for (Employee employee: employees) {
            if (employee.getCpf() == cpf) {
                return employee;
            }
        }
        return null;
    }

    public Employee changeEmployee (Employee employee) {
        return employee;
    }
}
