package com.nisum.user.in_memory_repository.repository;

import com.nisum.user.in_memory_repository.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IUserDataRepository extends JpaRepository<User, UUID> {

    Boolean existsUserByEmailIgnoreCase(String email);

    User findFirstByEmailIgnoreCase(String email);
}
