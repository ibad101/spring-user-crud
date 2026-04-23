package com.mecaps.springpractice.Repository;


import com.mecaps.springpractice.Entity.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;

/*
👉 This is the main thing

👉 JpaRepository provides:

save() → insert/update
findById() → get by id
findAll() → get all data
deleteById() → delete
 */
@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<UserTable,Long> {
}
    /*
    JpaRepository<UserTable, Long>
    save(user);          // insert or update
findById(1L);       // get by id
findAll();          // get all users
deleteById(1L);     // delete user
     */

