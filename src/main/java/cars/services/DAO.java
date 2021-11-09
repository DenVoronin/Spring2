package cars.services;
import cars.Car;
import org.hibernate.Session;
import org.hibernate.Transaction;


import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Service
public class DAO {
    public static void update(Car car) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(car);
        tx1.commit();
        session.close();

    }

    public static <Car> List<Car> loadAllData(Class<Car> type) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
       return  session.createCriteria(cars.Car.class).list();
    }

    public static void newCar(Car car) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(car);
        tx1.commit();
        session.close();
    }

}
