package by.tms.repository;

import by.tms.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepository {

    private final List<User> userList = new ArrayList<>();

    public boolean isExistUsername(String username) {
        for (User list : userList) {
            if (username.equals(list.getUsername())) {
                return true;
            }
        }
        return false;
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public User getUserByUsername(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }


//    public User getUserById(long userId) {
//        for (User list : userList) {
//            if (list.getId() == userId) {
//                return list;
//            }
//        }
//        return null;
//    }
//
//    public void changePassword(long userId, String newPassword) {
//        for (User list : userList) {
//            if (list.getId() == userId) {
//                list.setPassword(newPassword);
//            }
//        }
//    }
//
//    public void changeUsername(long userId, String newUsername) {
//        for (User list : userList) {
//            if (list.getId() == userId) {
//                list.setUsername(newUsername);
//            }
//        }
//    }
}
