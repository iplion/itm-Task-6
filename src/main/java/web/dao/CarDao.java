package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.List;

@Repository
public class CarDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public CarDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    public List<Car> getAll(Integer limit) {
        var query = sessionFactory.getCurrentSession().createQuery("from Car", Car.class);
        if (limit != null && limit < 5) {
            query.setMaxResults(limit);
        }

        return query.getResultList();
    }
}
