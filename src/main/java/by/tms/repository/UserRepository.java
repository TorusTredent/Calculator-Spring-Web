package by.tms.repository;

import by.tms.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepository {

    private final List<User> userList = new ArrayList<>();

}
