package com.example.demo.peristance.repository;

import com.example.demo.peristance.entity.RoleEntity;
import com.example.demo.peristance.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, String> {
}