package com.andrew.auth;

import com.andrew.model.entity.Employee;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<HttpStatus> createUser(
            @RequestBody RegisterRequest registerRequest
    ) {
        try {
            authService.register(registerRequest);
            return ResponseEntity.ok(HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return e.getMessage().endsWith("exists") ?
                    ResponseEntity.status(HttpStatus.CONFLICT).build() :
                    ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> doLogin(
            @RequestBody LoginRequest loginRequest
    ) {
        try {
            return ResponseEntity.ok(authService.authenticate(loginRequest));
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new AuthenticationResponse());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new AuthenticationResponse());
        }
    }

    @PreAuthorize("hasAnyAuthority('USER', 'OPERATOR', 'SUPER_ADMIN')")
    @PostMapping("/logout")
    public String performLogout(
            @AuthenticationPrincipal Employee user,
            Authentication authentication,
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        authService.doLogout(authentication, request, response);
        return "redirect:/login";
    }
}
