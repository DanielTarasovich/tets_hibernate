package Operations;

import Entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class ShowAllEmployees {
    public static void main(String[] args) {
        SessionFactory factory =  new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();


        try{
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            List<Employee> list;
            list= session.createQuery("from Employee").getResultList();
            for(Employee e : list)
                System.out.println(e);


            session.getTransaction().commit();
            System.out.println("You were got list with all employee");





        }finally {
            factory.close();
        }
    }
}
