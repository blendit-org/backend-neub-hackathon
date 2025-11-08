package com.neub.authApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neub.authApi.entitiy.VaccineInformation;

@Repository
public interface VaccineRepository extends JpaRepository<VaccineInformation, String>{

}
