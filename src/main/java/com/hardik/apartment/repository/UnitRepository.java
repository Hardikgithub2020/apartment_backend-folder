package com.hardik.apartment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hardik.apartment.model.Unit;


@Repository
public interface UnitRepository extends JpaRepository<Unit, Long> {

}
