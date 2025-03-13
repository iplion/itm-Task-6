package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.CarDao;
import web.model.Car;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarDao carDao;

    @Transactional
    public void add(Car car) {

        carDao.save(car);
    }

    @Transactional
    public List<Car> getAll(Integer count) {
        return carDao.getAll(count);
    }
}
