package com.neub.authApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neub.authApi.entitiy.RequestVaccine;

@Repository
public interface RequestVaccineRepository extends JpaRepository<RequestVaccine, Long>{

}
