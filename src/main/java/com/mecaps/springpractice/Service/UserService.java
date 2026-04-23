package com.mecaps.springpractice.Service;

import com.mecaps.springpractice.Entity.UserTable; // Import Entity (table class)
import com.mecaps.springpractice.Repository.Repository; // Import Repository (DB operations)
import org.springframework.beans.factory.annotation.Autowired; // For dependency injection
import org.springframework.stereotype.Service; // Marks class as Service layer

import java.util.List; // For handling list of users

@Service // Marks this class as Service (Business Logic Layer)
public class UserService {

    @Autowired // Automatically injects Repository object
    private Repository repository;


    // ===================== READ (GET USER BY ID) =====================
    public UserTable getUserByID(Long id) {

        // Fetch user from database using ID
        // If user not found → throw RuntimeException
        UserTable userTable = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("user not found " + id));

        // Return the fetched user object
        return userTable;
    }


    // ===================== READ (GET ALL USERS) =====================
    public List<UserTable> getallUsers() {

        // Fetch all users from database
        List<UserTable> all = repository.findAll();

        // Return list of users
        return all;
    }


    // ===================== CREATE (INSERT USER) =====================
    public String createUser(UserTable request) {

        // Create a new object (to avoid directly saving request object)
        UserTable userTable = new UserTable();

        // Set values from request object to new object
        userTable.setUser_name(request.getUser_name());
        userTable.setAge(request.getAge());
        userTable.setLocation(request.getLocation());

        // Save the new user into database
        UserTable save = repository.save(userTable);

        // Return success message (String used as simple response)
        return "User create successfully";
    }


    // ===================== UPDATE USER =====================
    public String UpdateUser(Long id, UserTable request) {

        // Find existing user by ID
        // If not found → throw exception
        UserTable userTable = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("USER NOT found + " + id));

        // Update existing user fields with new values
        userTable.setUser_name(request.getUser_name());
        userTable.setAge(request.getAge());
        userTable.setLocation(request.getLocation());

        // Save updated user back to database
        UserTable save = repository.save(userTable);

        // Return success message
        return "user update successfully";
    }


    // ===================== DELETE USER =====================
    public String deleteUser(Long id) {

        // Check if user exists in database
        UserTable userTable = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("user not found " + id));

        // Delete user using ID
        repository.deleteById(id);

        // Return success message
        return "User deleted successfully";
    }
}