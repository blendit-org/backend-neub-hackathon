package com.neub.authApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neub.authApi.entitiy.DosageInformation;

@Repository
public interface DosesRepository extends JpaRepository<DosageInformation, String>{

}
