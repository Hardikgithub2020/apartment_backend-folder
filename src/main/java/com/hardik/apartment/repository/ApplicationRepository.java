package com.hardik.apartment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hardik.apartment.model.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long>{

}
