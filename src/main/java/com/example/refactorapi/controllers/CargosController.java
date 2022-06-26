package com.example.refactorapi.controllers;

import com.example.refactorapi.models.CargosModels;
import com.example.refactorapi.models.dto.CargosDto;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.refactorapi.services.CargosServices;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/cargos-refactor")
public class CargosController {

    final
    CargosServices cargosServices;

    public CargosController(CargosServices cargosServices) {
        this.cargosServices = cargosServices;
    }

    //@RequestMapping(method = RequestMethod.POST, path =  "/create")
    @PostMapping
    public ResponseEntity<Object> saveCargos(@RequestBody @Valid CargosDto cargosDto){
        if (cargosServices.existsByNomeCargo(cargosDto.getNomeCargo())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: This name has already been created!");
        }
        var cargosModel = new CargosModels();
        System.err.println(cargosDto);
        BeanUtils.copyProperties(cargosDto,cargosModel);
        System.err.println(cargosDto.toString() + " == " + cargosModel.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(cargosServices.save(cargosModel));
    }
@GetMapping
    public ResponseEntity<List<CargosModels>> getAllCargos(){
        return ResponseEntity.status(HttpStatus.OK).body(cargosServices.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneCargo(@PathVariable(value = "id")long id){
        Optional<CargosModels> cargosModelsOptional = cargosServices.findById(id);
        if (!cargosModelsOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cargo NÃO localizado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(cargosModelsOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCargo(@PathVariable(value = "id")long id){
        Optional<CargosModels> cargosModelsOptional = cargosServices.findById(id);
        if (!cargosModelsOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cargo NÃO localizado");
        }
        cargosServices.delete(cargosModelsOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Cargo EXCLUIDO com sucesso!!!");
    }
}
