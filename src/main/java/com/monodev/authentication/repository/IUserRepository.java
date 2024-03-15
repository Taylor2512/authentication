package com.monodev.authentication.repository;

import java.util.UUID;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.monodev.authentication.models.entity.Usuario;

@Repository
public interface IUserRepository extends JpaRepository<Usuario, UUID>{

    List<Usuario> findByTenantId(UUID tenantId);

}
