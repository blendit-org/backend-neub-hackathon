package com.neub.authApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neub.authApi.entitiy.CenterVaccineStock;

@Repository
public interface CenterVaccineStockRepository extends JpaRepository<CenterVaccineStock, Long>{

}
