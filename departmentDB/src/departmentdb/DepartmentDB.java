/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package departmentdb;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Department;
import model.Employee;

/**
 *
 * @author ntpsm
 */
public class DepartmentDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Department dep1 = new Department();
        Department dep2 = new Department();
        Employee emp1 = new Employee();
        Employee emp2 = new Employee();
        Employee emp3 = new Employee();
        Employee emp4 = new Employee();
        
        dep1.setName("IT");
        dep1.setDepartmentid(1);
        dep2.setName("HR");
        dep2.setDepartmentid(2);

        emp1.setName("John");
        emp2.setName("Marry");
        emp3.setName("Henry");
        emp4.setName("Clark");
        emp1.setSalary(11111);
        emp2.setSalary(22222);
        emp3.setSalary(33333);
        emp4.setSalary(444444);
        emp1.setJob("NetWork Admin");
        emp2.setJob("HR Manager");
        emp3.setJob("Programmer");
        emp4.setJob("HR recuiter");
        emp1.setDepartmentid(dep1);
        emp2.setDepartmentid(dep2);
        emp3.setDepartmentid(dep1);
        emp4.setDepartmentid(dep2);
        emp1.setEmployeeid(1);
        emp2.setEmployeeid(2);
        emp3.setEmployeeid(3);
        emp4.setEmployeeid(4);
        
        persist(dep1);
        persist(dep2);
        persist(emp1);
        persist(emp2);
        persist(emp3);
        persist(emp4);
           
    }

    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("departmentDBPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
}
