package com.nisum.user.in_memory_repository.repository;

import com.nisum.user.in_memory_repository.entities.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.UUID;

@Repository
public interface IParameterDataRepository extends JpaRepository<Parameter, UUID> {

    Parameter findFirstByKeyIgnoreCase(String key);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Parameter SET value=?2 WHERE id=?1")
    Integer updateParameter(UUID id, String value);

}

