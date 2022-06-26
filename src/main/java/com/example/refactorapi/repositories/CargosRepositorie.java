package com.example.refactorapi.repositories;


import com.example.refactorapi.models.CargosModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CargosRepositorie extends JpaRepository<CargosModels, UUID> {

    boolean existsByNomeCargo(String nomeCargo);

}
