package com.neub.authApi.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neub.authApi.entitiy.Center;

@Repository
public interface CenterRepository extends JpaRepository<Center, Long>{

}
