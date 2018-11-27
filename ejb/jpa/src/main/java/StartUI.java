import entities.Employee;
import service_on_database.EmployeeService;
import service_on_database.impl.EmployeeServiceImpl;

import javax.persistence.*;

public class StartUI {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeeService");
        EntityManager em = emf.createEntityManager();
        EmployeeService service = new EmployeeServiceImpl();
        em.getTransaction().begin();
        Employee emp = service.create(2, "Sergey", 10000);
        em.getTransaction().commit();
        System.out.println(emp);
        em.getTransaction().begin();
        service.delete(2);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
