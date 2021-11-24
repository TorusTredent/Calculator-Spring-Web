package by.tms.service;

import by.tms.entity.User;
import by.tms.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserUsername(String username) {
        return userRepository.getUserUsername(username);
    }

    public boolean isExistUsername(String username) {
        return userRepository.isExistUsername(username);
    }

    public void registrationUser(User user) {
        userRepository.addUser(user);
    }
}
