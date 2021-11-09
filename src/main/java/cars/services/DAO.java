package cars.services;
import cars.Car;
import org.hibernate.Session;
import org.hibernate.Transaction;


import org.springframework.stereotype.Service;

@Service
public class DAO {
    public static void save(Car car) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(car);
        tx1.commit();
        session.close();

    }

    public static void newCar(Car car) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(car);
        tx1.commit();
        session.close();
    }

}
