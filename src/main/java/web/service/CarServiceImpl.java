package web.service;

import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarServiceImpl implements CarService {
    private final List<Car> carList= new ArrayList<>();

    public List<Car> fiveCars() {
        carList.add(new Car("NISSAN", "MURANO", 2018));
        carList.add(new Car("LADA", "NIVA", 2018));
        carList.add(new Car("MAZDA", "CX-5", 2019));
        carList.add(new Car("FORD", "EXPLORER", 2017));
        carList.add(new Car("AURUS", "SENAT", 2021));
        return carList;
    }

    @Override
    public List<Car> getCar(Integer count) {
        return carList
                .stream().limit(count)
                .collect(Collectors.toList());
    }
}