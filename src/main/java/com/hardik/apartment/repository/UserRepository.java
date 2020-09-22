package com.hardik.apartment.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hardik.apartment.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}

