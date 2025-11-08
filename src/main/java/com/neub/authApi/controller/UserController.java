package com.neub.authApi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neub.authApi.dto.LoginUserDto;
import com.neub.authApi.entitiy.Notifications;
import com.neub.authApi.entitiy.User;
import com.neub.authApi.repository.NotificationRepository;
import com.neub.authApi.service.UserService;

@RequestMapping("/users")
@RestController
public class UserController {
	private final UserService userService;
	
	private final NotificationRepository notificationRepository;


    public UserController(UserService userService, NotificationRepository notificationRepository) {
		super();
		this.userService = userService;
		this.notificationRepository = notificationRepository;
	}

	@GetMapping("/me")
    public ResponseEntity<User> authenticatedUser() {
    	
    	System.out.println("[debug] /users/me");
    	
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User currentUser = (User) authentication.getPrincipal();

        return ResponseEntity.ok(currentUser);
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> allUsers() {
    	
    	System.out.println("[debug] /users/");
    	
        List <User> users = userService.allUsers();

        return ResponseEntity.ok(users);
    }
    
    @PostMapping("/notifications")
    public ResponseEntity<List<Notifications>> allNotifications(@RequestBody LoginUserDto user) {
    	return ResponseEntity.ok(notificationRepository.findByUserId(user.getUserId()));
    }
    
    
}
