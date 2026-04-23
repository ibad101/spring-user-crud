package com.mecaps.springpractice.Service;

import com.mecaps.springpractice.Entity.UserTable;
import com.mecaps.springpractice.Repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private Repository repository;

    public UserTable getUserByID(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("user not found " + id));
    }

    public List<UserTable> getallUsers() {
        return repository.findAll();
    }

    public String createUser(UserTable request) {

        UserTable userTable = new UserTable();

        // ✅ FIXED mapping
        userTable.setUserName(request.getUserName());
        userTable.setAge(request.getAge());
        userTable.setAddress(request.getAddress());

        repository.save(userTable);

        return "User create successfully";
    }

    public String UpdateUser(Long id, UserTable request) {

        UserTable userTable = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("USER NOT found " + id));

        // ✅ FIXED mapping
        userTable.setUserName(request.getUserName());
        userTable.setAge(request.getAge());
        userTable.setAddress(request.getAddress());

        repository.save(userTable);

        return "user update successfully";
    }

    public String deleteUser(Long id) {

        UserTable userTable = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("user not found " + id));

        repository.deleteById(id);

        return "User deleted successfully";
    }
}