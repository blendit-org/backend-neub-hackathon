package com.neub.authApi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neub.authApi.entitiy.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
	Optional<Appointment> findByUserIdAndVaccineIdAndDoseId(Long userId, String vaccineId, String doseId);
}
