package web.service;

import web.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {
    private final List<User> carList= new ArrayList<>();

    public List<User> fiveUser() {
        carList.add(new User("Ivan", "Ivanov", "ivanov@mail.ru", 45));
        carList.add(new User("Sergey", "Sergeev", "sergeev@mail.ru", 23));
        carList.add(new User("Roman", "Romanov", "romanov@mail.ru", 28));
        carList.add(new User("Pavel", "Pavlov", "pavlov@mail.ru", 34));
        carList.add(new User("Fedor", "Fedorovic", "fedorovic@mail.ru", 26));

        return carList;
    }

    @Override
    public List<User> getUser(Integer count) {
        return carList
                .stream().limit(count)
                .collect(Collectors.toList());
    }
}