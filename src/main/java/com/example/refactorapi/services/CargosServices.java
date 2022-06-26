package com.example.refactorapi.services;

import com.example.refactorapi.models.CargosModels;
import org.springframework.stereotype.Service;
import com.example.refactorapi.repositories.CargosRepositorie;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CargosServices {
    final
    CargosRepositorie cargosRepositorie;

    public CargosServices(CargosRepositorie cargosRepositorie) {
        this.cargosRepositorie = cargosRepositorie;
    }

    @Transactional
    public CargosModels save(CargosModels cargosModels) {
        return cargosRepositorie.save(cargosModels);
    }

    public boolean existsByNomeCargo(String nomeCargo){
        return cargosRepositorie.existsByNomeCargo(nomeCargo);
    }

    public List<CargosModels> findAll() {
    return cargosRepositorie.findAll();
    }

    public Optional<CargosModels> findById(long id) {
        return cargosRepositorie.findById(id);
    }
    @Transactional
    public void delete(CargosModels cargosModels) {
        cargosRepositorie.delete(cargosModels);
    }
}