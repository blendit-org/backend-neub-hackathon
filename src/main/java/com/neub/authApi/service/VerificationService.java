package com.neub.authApi.service;

import org.springframework.stereotype.Service;

import com.neub.authApi.entitiy.User;
import com.neub.authApi.exception.VerificationMismatch;
import com.neub.authApi.repository.UserRepository;

@Service
public class VerificationService {
	
	private final UserRepository userRepository;
	
	private final MailService mailService;
	
	

	public VerificationService(UserRepository userRepository, MailService mailService) {
		super();
		this.userRepository = userRepository;
		this.mailService = mailService;
	}
	
	public User verificationCodeMatches(String email, long verificationCode) throws VerificationMismatch {
		User user = userRepository.findByEmail(email).get();
		
		if (user.getOtp() == verificationCode) {
			user.setVerified(true);
			userRepository.save(user);
			return user;
		} else {
			throw new VerificationMismatch("Verification code mismatch");
		}
	}
	
	public void verificationCodeSent(String email) {
		User user = userRepository.findByEmail(email).get();
		long verificationCode = 100000 + (long) (Math.random() * (999999-100000));
		user.setOtp(verificationCode);
		userRepository.save(user);
		mailService.sendMessageWithInputStreamAttachment(user.getEmail(), verificationCode);
	}
}
