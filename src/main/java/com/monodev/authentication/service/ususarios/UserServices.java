package com.monodev.authentication.service.ususarios;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.monodev.authentication.models.dto.UserDto;
import com.monodev.authentication.models.entity.Usuario;
import com.monodev.authentication.models.request.UsertRequest;
import com.monodev.authentication.repository.IUserRepository;
import com.monodev.authentication.service.mapper.IMapper;

import jakarta.validation.Valid;

@Service
@Valid
public class UserServices implements IUserServices {

    private final IUserRepository userRepository;
    private final IMapper mapper;

    public UserServices(IUserRepository userRepository, IMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public CompletableFuture<UserDto> createUser(UsertRequest userRequest) {
        try {
            Usuario usuario = mapper.map(userRequest);
            if (usuario != null) {
                Usuario savedUsuario = userRepository.save(usuario);
                return CompletableFuture.completedFuture(mapper.map(savedUsuario));
            } else {
                throw new IllegalArgumentException("El usuario no puede ser nulo");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return CompletableFuture.completedFuture(null);
        }
    }

    @Override
    public CompletableFuture<UserDto> getUser(UUID id) {
        try {
            Optional<Usuario> optionalUsuario = userRepository.findById(id);
            return optionalUsuario.map(usuario -> CompletableFuture.completedFuture(mapper.map(usuario)))
                    .orElseGet(() -> CompletableFuture.completedFuture(null));
        } catch (Exception e) {
            e.printStackTrace();
            return CompletableFuture.completedFuture(null);
        }
    }

    @Override
    public CompletableFuture<List<UserDto>> getUsers(UUID tenantId) {
        try {
            List<Usuario> usuarios = userRepository.findByTenantId(tenantId);
            List<UserDto> userDtos = usuarios.stream()
                    .map(usuario -> mapper.map(usuario))
                    .collect(Collectors.toList());
            return CompletableFuture.completedFuture(userDtos);
        } catch (Exception e) {
            e.printStackTrace();
            return CompletableFuture.completedFuture(null);
        }
    }

    @Override
    public CompletableFuture<UserDto> updateUser(UUID id, @Valid UsertRequest userRequest) {
        try {
            Optional<Usuario> optionalUsuario = userRepository.findById(id);
            return optionalUsuario.map(usuario -> {
                Usuario updatedUsuario = mapper.map(userRequest);
                updatedUsuario.setId(id); // Actualizamos el ID
                if (updatedUsuario != null) {
                    updatedUsuario = userRepository.save(updatedUsuario);
                    return CompletableFuture.completedFuture(mapper.map(updatedUsuario));
                } else {
                    throw new IllegalArgumentException("El usuario no puede ser nulo");
                }
            }).orElseGet(() -> CompletableFuture.completedFuture(null));
        } catch (Exception e) {
            e.printStackTrace();
            return CompletableFuture.completedFuture(null);
        }
    }

    @Override
    public CompletableFuture<UserDto> deleteUser(UUID id) {
        try {
            Optional<Usuario> optionalUsuario = userRepository.findById(id);
            return optionalUsuario.map(usuario -> {
                userRepository.delete(usuario);
                return CompletableFuture.completedFuture(mapper.map(usuario));
            }).orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado con ID: " + id));
        } catch (Exception e) {
            e.printStackTrace();
            return CompletableFuture.completedFuture(null);
        }
    }
}
