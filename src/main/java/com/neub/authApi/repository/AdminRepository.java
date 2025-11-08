package com.neub.authApi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neub.authApi.entitiy.Admin;
import com.neub.authApi.entitiy.User;

public interface AdminRepository extends JpaRepository<Admin, Long> {
	Optional<Admin> findByAdminId(Long adminId);
}
