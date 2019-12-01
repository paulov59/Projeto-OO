package main;

import people.Employee;
import java.util.*;

public class EmployeeManagement {

    public Scanner input = new Scanner(System.in);

    public boolean validateCpf(String cpf) {
        return cpf.matches("[0-9]*");
    }

    public Employee addEmployee() {
        int employeeId = 0;
        String cpf = null;
        double salary = 0;
        boolean flag;

        System.out.print("Nome: ");
        String name = input.nextLine();

        flag = false;
        while (!flag) {
            try {
                flag = true;
                System.out.print("CPF: ");
                cpf = input.nextLine();
                if (!validateCpf(cpf) || cpf.length() != 11) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Por favor, insira um CPF válido");
                flag = false;
            }
        }
        Employee employee = new Employee(name, cpf);

        flag = false;
        while (!flag) {
            try {
                flag = true;
                System.out.print("Número de identidade profissional: ");
                employeeId = input.nextInt();
            } catch (Exception e) {
                System.out.println("Por favor, insira uma identidade profissional válida");
                input.nextLine();
                flag = false;
            }
        }
        input.nextLine();
        employee.setEmployeeId(employeeId);

        flag = false;
        while (!flag) {
            try {
                flag = true;
                System.out.print("Salário: R$ ");
                salary = input.nextDouble();
            } catch (Exception e) {
                System.out.println("Por favor, insira um valor válido");
                input.nextLine();
                flag = false;
            }
        }
        input.nextLine();
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

    public Employee findEmployee(String cpf, ArrayList<Employee> employees) {
        if (!employees.isEmpty()) {
            for (Employee employee: employees) {
                if (employee.getCpf().equals(cpf)) {
                    return employee;
                }
            }
        }
        return null;
    }

    public Employee changeEmployee (Employee employee) {
        System.out.println(employee);
        System.out.println("Selecione:");
        System.out.println("\t[1] - Modificar nome");
        System.out.println("\t[2] - Modificar salário");
        System.out.println("\t[3] - Modificar identidade profissional");
        System.out.println("\t[4] - Voltar");

        int option = 0;
        boolean flag = false;
        while (!flag) {
            try {
                flag = true;
                option = input.nextInt();
                if (option < 1 || option > 4) {
                    throw new Exception("Opção inválida");
                }
            } catch (Exception e) {
                System.out.println("Por favor, selecione uma opção válida");
                input.nextLine();
                flag = false;
            }
        }
        input.nextLine();

        switch (option) {
            case 1:
                System.out.print("Novo nome: ");
                String name = input.nextLine();
                employee.setName(name);
                break;
            case 2:
                double salary = 0;
                flag = false;
                while (!flag) {
                    try {
                        flag = true;
                        System.out.print("Novo salário: R$ ");
                        salary = input.nextDouble();
                    } catch (Exception e) {
                        System.out.println("Por favor, insira um valor válido");
                        input.nextLine();
                        flag = false;
                    }
                }
                input.nextLine();
                employee.setSalary(salary);
                break;
            case 3:
                int employeeId = 0;
                flag = false;
                while (!flag) {
                    try {
                        flag = true;
                        System.out.print("Nova identidade profissional: ");
                        employeeId = input.nextInt();
                    } catch (Exception e) {
                        System.out.println("Por favor, insira uma identidade profissional válida");
                        input.nextLine();
                        flag = false;
                    }
                }
                input.nextLine();
                employee.setEmployeeId(employeeId);
                break;
            default:
                break;
        }
        return employee;
    }
}
