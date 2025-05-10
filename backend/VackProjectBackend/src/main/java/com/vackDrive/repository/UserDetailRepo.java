package com.vackDrive.repository;

import com.vackDrive.model.Student;
import com.vackDrive.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailRepo extends JpaRepository<Users,Integer> {

    Users findByUsername(String username);
}
