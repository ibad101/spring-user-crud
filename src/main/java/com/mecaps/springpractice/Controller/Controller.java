

package com.mecaps.springpractice.Controller;

import com.mecaps.springpractice.Entity.UserTable; // Entity class (maps to DB table)
import com.mecaps.springpractice.Service.UserService; // Service layer (business logic)
import org.springframework.beans.factory.annotation.Autowired; // For dependency injection
import org.springframework.web.bind.annotation.*; // REST annotations

import java.util.List; // For returning list of users

@RestController // Marks this class as REST API controller (returns JSON response)
@RequestMapping("/Users") // Base URL for all APIs in this controller
public class Controller {

    @Autowired // Injects UserService object automatically
    private UserService userService;


    // ===================== GET USER BY ID =====================
    @GetMapping("/getusers/{id}") // Handles GET request with ID in URL
    public UserTable getbyid(@PathVariable Long id){

        // Calls service layer to fetch user by ID
        UserTable userbyID = userService.getUserByID(id);

        // Returns user object as JSON response
        return userbyID;
    }


    // ===================== GET ALL USERS =====================
    @GetMapping("/getalluser") // Handles GET request to fetch all users
    public List<UserTable> getall (){

        // Calls service layer to get all users from database
        List<UserTable> userTables = userService.getallUsers();

        // Returns list of users as JSON
        return  userTables;
    }


    // ===================== CREATE USER =====================
    @PostMapping("/create") // Handles POST request to create new user
    public String  create(@RequestBody UserTable request){

        // @RequestBody converts JSON request into UserTable object

        // Calls service layer to save user in database
        String user = userService.createUser(request);

        // Returns success message
        return  user;
    }


    // ===================== UPDATE USER =====================
    @PutMapping("/update/{id}") // Handles PUT request to update existing user
    public String update (@PathVariable Long id , @RequestBody UserTable request){

        // @PathVariable → gets ID from URL
        // @RequestBody → gets updated data from request body

        // Calls service layer to update user details
        return userService.UpdateUser(id, request);
    }


    // ===================== DELETE USER =====================
    @DeleteMapping("/delete/{id}") // Handles DELETE request to remove user
    public String delete (@PathVariable Long id ){

        // Calls service layer to delete user by ID
        return  userService.deleteUser(id);
    }

}

