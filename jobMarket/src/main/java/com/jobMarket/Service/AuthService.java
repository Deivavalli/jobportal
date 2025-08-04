package com.jobMarket.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jobMarket.DTO.LoginRequestDTO;
import com.jobMarket.DTO.RegisterRequestDTO;
import com.jobMarket.Entity.User;
import com.jobMarket.Repository.UserRepository;
import com.jobMarket.Security.JWTUtil;

@Service
public class AuthService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private JWTUtil jwtUtil;

	public String register(RegisterRequestDTO dto) {

		if (userRepository.existByUserName(dto.name) || userRepository.existByUserEmail(dto.email)) {
			throw new RuntimeException("User alred exist");
		}

		User user = new User();

		user.setName(dto.getName());
		user.setEmail(dto.getEmail());
		user.setPassword(dto.getPassword());
		user.setRole(dto.getRole());

		userRepository.save(user);

		return "User registred succesfully ";

	}

	public String login(LoginRequestDTO dto) {
		User user = userRepository.findByUserEmail(dto.email).orElseThrow(() -> new RuntimeException("User not found"));

		if (!passwordEncoder.matches(dto.password, user.getPassword())) {
			throw new RuntimeException("Invalid credential");
		}

		return jwtUtil.generateToken(user);
	}

}
