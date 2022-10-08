package Operations;


import Entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddEmp {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try{
          //  Employee emp1 = new Employee("Igor", "IT",  1000);
            Employee emp2 = new Employee("Oliya", "Sales",  2500);
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            session.save(emp2);
            session.getTransaction().commit();
            System.out.println("You add a new employee");
        }finally {
            factory.close();
        }


    }

}
