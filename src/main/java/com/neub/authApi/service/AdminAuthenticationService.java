package com.neub.authApi.service;

import org.springframework.stereotype.Service;

import com.neub.authApi.dto.LoginAdminDto;
import com.neub.authApi.entitiy.Admin;
import com.neub.authApi.exception.UserNotVerifiedError;
import com.neub.authApi.repository.AdminRepository;
import com.neub.authApi.repository.UserRepository;

@Service
public class AdminAuthenticationService {

	private final AdminRepository adminRepository;
	
	public AdminAuthenticationService(AdminRepository adminRepository) {
		super();
		this.adminRepository = adminRepository;
	}



	public Admin authenticate(LoginAdminDto loginAdminDto) throws UserNotVerifiedError {
		// TODO Auto-generated method stub
		
		Admin admin = new Admin();
		
		if (adminRepository.existsById(loginAdminDto.getAdminId())) {
			admin = adminRepository.findById(loginAdminDto.getAdminId()).get();
			System.out.println(admin.getEmail() + "   " +admin.getPassword() + " " + loginAdminDto.getPassword());
			if (admin.getPassword().equals(loginAdminDto.getPassword())) { // check admin id password
				return admin;
			}
			else { 
				throw new UserNotVerifiedError("Admin User not verified: password incorrect");
			}
		}
		else {
			throw new UserNotVerifiedError("Admin user not verified");
		}
	}

}
