package main;

import people.Employee;
import java.util.*;

public class EmployeeManagement {

    public Scanner input = new Scanner(System.in);

    public Employee addEmployee() {
        System.out.print("Nome: ");
        String name = input.nextLine();

        System.out.print("CPF: ");
        long cpf = input.nextLong();
        Employee employee = new Employee(name, cpf);

        System.out.print("Número de identidade profissional: ");
        int employeeId = input.nextInt();
        employee.setEmployeeId(employeeId);

        System.out.println("Salário: R$ ");
        double salary = input.nextDouble();
        employee.setSalary(salary);

        return employee;
    }

    public void showAllEmployees(ArrayList<Employee> employees) {
        if (employees.isEmpty()) {
            System.out.println("Não há funcionários cadastrados");
        } else {
            for (Employee employee:employees) {
                System.out.println(employee);
            }
        }
    }

    public Employee findEmployee(long cpf, ArrayList<Employee> employees) {
        if (!employees.isEmpty()) {
            for (Employee employee: employees) {
                if (employee.getCpf() == cpf) {
                    return employee;
                }
            }
        }
        return null;
    }

    public Employee changeEmployee (Employee employee) {
        System.out.println("Selecione:");
        System.out.println("\t[1] - Modificar nome");
        System.out.println("\t[2] - Modificar salário");
        System.out.println("\t[3] - Modificar identidade profissional");
        System.out.println("\t[4] - Voltar");

        int option = input.nextInt();
        input.nextLine();

        switch (option) {
            case 1:
                System.out.println("Novo nome: ");
                String name = input.nextLine();
                employee.setName(name);
                break;
            case 2:
                System.out.println("Novo salário: R$ ");
                double salary = input.nextDouble();
                employee.setSalary(salary);
                break;
            case 3:
                System.out.println("Nova identidade profissional: ");
                int employeeId = input.nextInt();
                employee.setEmployeeId(employeeId);
                break;
            default:
                break;
        }
        return employee;
    }
}
