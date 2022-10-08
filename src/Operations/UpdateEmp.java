package Operations;

import Entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateEmp {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();


        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            Employee employee = session.get(Employee.class, 2);
            employee.setSalary(777);


            //  session.createQuery("update from Employee set salary = 777 where name ='Igor'");//is a variant with a SQL query

            session.getTransaction().commit();
            System.out.println("Your update was done");


        } finally {
            factory.close();
        }


    }
}
