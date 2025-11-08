package com.neub.authApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neub.authApi.entitiy.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long>{

}
