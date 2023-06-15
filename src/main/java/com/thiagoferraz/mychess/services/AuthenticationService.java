package com.thiagoferraz.mychess.services;

import com.thiagoferraz.mychess.model.entities.Player;
import com.thiagoferraz.mychess.model.enums.Role;
import com.thiagoferraz.mychess.model.tos.AuthenticationResponse;
import com.thiagoferraz.mychess.model.tos.RegisterRequest;
import com.thiagoferraz.mychess.repositories.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final PlayerRepository playerRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;

    public AuthenticationResponse register(RegisterRequest request) {

        Player player = Player.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        playerRepository.save(player);

        var jwtToken = jwtService.generateToken(player);

        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse authenticate(RegisterRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        Player player = playerRepository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(player);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
