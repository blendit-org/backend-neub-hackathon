package com.neub.authApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neub.authApi.entitiy.Notifications;

@Repository
public interface NotificationRepository extends JpaRepository<Notifications, Long> {
	List<Notifications> findByUserId(Long userId);
}
