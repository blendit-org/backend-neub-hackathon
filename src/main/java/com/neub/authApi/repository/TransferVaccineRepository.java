package com.neub.authApi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neub.authApi.entitiy.TransferVaccine;
import com.neub.authApi.entitiy.User;

@Repository
public interface TransferVaccineRepository extends JpaRepository<TransferVaccine, Long> {
	Optional<TransferVaccine> findByTnxId(Long tnxId);
}
