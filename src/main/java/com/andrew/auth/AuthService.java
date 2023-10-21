package com.andrew.auth;

import com.andrew.config.JwtService;
import com.andrew.repository.EmployeeRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final EmployeeRepository employeeRepository;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    private final AuthUtils mappingUtils;

    @Transactional
    public void register(RegisterRequest request) throws IllegalArgumentException {
        var user = mappingUtils.mapToEntity(request);

        if (employeeRepository.existsByLogin(user.getLogin())) {
            throw new IllegalArgumentException("User " + user.getLogin() + " already exists");
        }
        employeeRepository.save(user);
    }

    @Transactional(readOnly = true)
    public AuthenticationResponse authenticate(LoginRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(), request.getPassword(), new ArrayList<>()
                    )
            );
        } catch (Exception ignored) {
        }

        var user = employeeRepository.findByLogin(request.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User was not found!"));
        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .id(user.getId())
                .build();
    }

    SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();

    public void doLogout(Authentication authentication, HttpServletRequest request, HttpServletResponse response) {
        logoutHandler.logout(request, response, authentication);
    }
}
