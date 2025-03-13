package web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import web.model.Car;
import web.service.CarService;

@Component
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent> {
    private final CarService carService;

    @Autowired
    public DataInitializer(CarService carService) {
        this.carService = carService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (carService.getAll(1).isEmpty()) {
            carService.add(new Car("the first car", 1));
            carService.add(new Car("the second car", 2));
            carService.add(new Car("the third car", 3));
            carService.add(new Car("the fourth car", 4));
            carService.add(new Car("the fifth car", 5));
        }
    }
}
