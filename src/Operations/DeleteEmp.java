package Operations;

import Entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteEmp {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            session.createQuery("delete Employee where name ='Igor'")
                    .executeUpdate(); //is a variant with a SQL query


//            Employee employee = session.get(Employee.class, 1);
//            session.delete(employee);

            session.getTransaction().commit();
            System.out.println("You deleted employee");


        } finally {
            factory.close();
        }
    }
}
