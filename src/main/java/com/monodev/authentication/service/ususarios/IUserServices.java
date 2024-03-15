package com.monodev.authentication.service.ususarios;
import java.util.UUID;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Service;

import   com.monodev.authentication.models.dto.UserDto;
import com.monodev.authentication.models.request.UsertRequest;


@Service
public interface IUserServices {
    public CompletableFuture<UserDto> createUser(UsertRequest userDto);
    public CompletableFuture<UserDto> getUser(UUID id);
    public CompletableFuture<List<UserDto>> getUsers(UUID tenantId);
    public CompletableFuture<UserDto> updateUser(UUID id, UsertRequest userDto);
    public CompletableFuture<UserDto> deleteUser(UUID id);
}
