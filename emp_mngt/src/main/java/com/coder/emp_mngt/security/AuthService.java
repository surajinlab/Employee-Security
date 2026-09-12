package com.coder.emp_mngt.security;

import ch.qos.logback.core.net.SMTPAppenderBase;
import com.coder.emp_mngt.dto.LoginRequestDto;
import com.coder.emp_mngt.dto.LoginResponseDto;
import com.coder.emp_mngt.dto.SignupResponseDto;
import com.coder.emp_mngt.entity.User;
import com.coder.emp_mngt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final AuthUtil authUtil;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public LoginResponseDto login(LoginRequestDto loginRequestDto) {

        SMTPAppenderBase<Object> loginResponseDto;
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(), loginRequestDto.getPassword())
        );

        User user = (User) authentication.getPrincipal();

        String token = authUtil.generateAccessToken(user);

        return new LoginResponseDto(token, user.getId());
    }


    public SignupResponseDto signup(LoginRequestDto signupRequestDto) {

        User user = userRepository.findByUsername(signupRequestDto.getUsername()).orElse(null);

        if (user != null) throw new IllegalArgumentException("User already exists");

        user = userRepository.save(User.builder()
                .username(signupRequestDto.getUsername())
//                .password(passwordEncoder.encode(signupRequestDto.getPassword())
                .password(passwordEncoder.encode(signupRequestDto.getPassword()))
                .build()
        );

        return new SignupResponseDto(user.getId(), user.getUsername());
    }
}
