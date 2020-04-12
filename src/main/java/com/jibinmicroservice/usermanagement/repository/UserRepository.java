package com.jibinmicroservice.usermanagement.repository;

import com.jibinmicroservice.usermanagement.dto.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    List<User> userList = new ArrayList<>();


    public List<User> getAllUsers() {
        return userList;
    }

    public User getUser(String id) {
        Optional<User> first = userList.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst();

        if (first.isPresent())
            return first.get();
        else

            return new User();


    }

    public void addUser(User user) {
        userList.add(user);
    }

    public User updateUser(User user) {
        for (User us : userList) {
            if (us.getId().equals(user.getId())) {
                us.setName(user.getName());
                us.setAddress(user.getAddress());
                return us;
            }
        }
        return new User();
    }

    public User deleteUser(String id) {
        Optional<User> first = userList.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst();
        if (first.isPresent()) {
            User user = first.get();
            userList.remove(user);
            return user;
        } else
            return new User();

    }
}
