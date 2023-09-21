/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package departmentdb;

import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.Department;
import model.Employee;

/**
 *
 * @author ntpsm
 */
public class DepartmentReport {
     public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("departmentDBPU");
        EntityManager em = emf.createEntityManager();

        // "All employee (by ID)"
        System.out.println("All employee (by ID)");
        System.out.println("---------------------------");
        TypedQuery<Employee> queryById = em.createQuery("SELECT e FROM Employee e", Employee.class);
        List<Employee> employeesById = queryById.getResultList();
        for (Employee employee : employeesById) {
            System.out.println("ID: " + employee.getEmployeeid());
            System.out.println("Name: " + employee.getName());
            System.out.println("Job: " + employee.getJob());
            System.out.println("Salary: " + employee.getSalary());
            System.out.println("Department: " + employee.getName());
            System.out.println("---------------------------");
        }
        // "All employee (by Department)"
        System.out.println("All employee (by Department)");
        System.out.println("---------------------------");
        TypedQuery<Department> queryByDepartment = em.createQuery("SELECT d FROM Department d", Department.class);
        List<Department> departments = queryByDepartment.getResultList();
        for (Department department : departments) {
            System.out.println("Department ID: " + department.getDepartmentid() + " Department Name: " + department.getName());
            System.out.println("---------------------------");
          TypedQuery<Employee> queryEmployeesByDepartment = em.createQuery(
    "SELECT e FROM Employee e WHERE e.department.departmentid = :departmentId",
    Employee.class
);
queryEmployeesByDepartment.setParameter("departmentId", department.getDepartmentid());
            List<Employee> employeesByDepartment = queryEmployeesByDepartment.getResultList();
            for (Employee employee : employeesByDepartment) {
                System.out.println("ID: " + employee.getEmployeeid());
                System.out.println("Name: " + employee.getName());
                System.out.println("Job: " + employee.getJob());
                System.out.println("Salary: " + employee.getSalary());
                System.out.println("---------------------------");
            }
        }

        em.close();
        emf.close();
    }
}
