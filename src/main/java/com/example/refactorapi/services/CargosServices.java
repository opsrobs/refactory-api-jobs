package com.example.refactorapi.services;

import com.example.refactorapi.models.CargosModels;
import org.springframework.stereotype.Service;
import com.example.refactorapi.repositories.CargosRepositorie;


import javax.transaction.Transactional;

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
}