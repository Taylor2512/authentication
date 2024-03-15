package com.monodev.authentication.controller;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.monodev.authentication.config.dto.ActionResult;
import com.monodev.authentication.config.dto.ControllerBase;
import com.monodev.authentication.models.dto.UserDto;
import com.monodev.authentication.models.request.UsertRequest;
import com.monodev.authentication.service.ususarios.IUserServices;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
 

@Tag(name = "User Management", description = "APIs for managing users")
@RestController
@RequestMapping("/users")
public class UserController extends ControllerBase{

    private final IUserServices userServices;

    public UserController(IUserServices userServices) {
        this.userServices = userServices;
    }

    @PostMapping
    public ActionResult createUser(@Valid @RequestBody UsertRequest userRequest ) throws InterruptedException, ExecutionException {
        
        CompletableFuture<UserDto> userDtoCompletableFuture = userServices.createUser(userRequest);
        var location = UriComponentsBuilder.fromPath("/users/{id}").buildAndExpand(userDtoCompletableFuture.get().getId()).toUri();
        return created(userDtoCompletableFuture.get(),"User created successfully",location);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable UUID id) throws InterruptedException, ExecutionException {
        CompletableFuture<UserDto> userDtoCompletableFuture = userServices.getUser(id);
        return ResponseEntity.ok().body(userDtoCompletableFuture.get());
    }

    @GetMapping("/tenant/{tenantId}")
    public ResponseEntity<List<UserDto>> getUsers(@PathVariable UUID tenantId) throws InterruptedException, ExecutionException {
        CompletableFuture<List<UserDto>> usersCompletableFuture = userServices.getUsers(tenantId);
        return ResponseEntity.ok().body(usersCompletableFuture.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable UUID id, @Valid @RequestBody UsertRequest userRequest) throws InterruptedException, ExecutionException {
        CompletableFuture<UserDto> userDtoCompletableFuture = userServices.updateUser(id, userRequest);
        return ResponseEntity.ok().body(userDtoCompletableFuture.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserDto> deleteUser(@PathVariable UUID id) throws InterruptedException, ExecutionException {
        CompletableFuture<UserDto> userDtoCompletableFuture = userServices.deleteUser(id);
        return ResponseEntity.ok().body(userDtoCompletableFuture.get());
    }
}
