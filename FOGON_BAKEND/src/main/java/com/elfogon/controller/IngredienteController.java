package com.elfogon.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import com.elfogon.Services.IIngredienteService;
import com.elfogon.DTO.IngredienteDTO;
import com.elfogon.model.Ingrediente;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/ingredientes")
@RequiredArgsConstructor
public class IngredienteController {

    private final IIngredienteService service;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<IngredienteDTO>> findAll() throws Exception {
        List<IngredienteDTO> list = service.findAll()
                .stream()
                .map(this::convertToDto)
                .toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IngredienteDTO> findById(@PathVariable("id") Integer id) throws Exception {
        IngredienteDTO dto = convertToDto(service.findById(id));
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<Ingrediente> save(@Valid @RequestBody IngredienteDTO dto) throws Exception {
        Ingrediente obj = service.save(convertToEntity(dto));
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getIdIngrediente())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<IngredienteDTO> update(@Valid @PathVariable("id") Integer id,
                                                 @RequestBody IngredienteDTO dto) throws Exception {
        Ingrediente obj = service.update(convertToEntity(dto), id);
        IngredienteDTO dtoResponse = convertToDto(obj);
        return ResponseEntity.ok(dtoResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private IngredienteDTO convertToDto(Ingrediente entity) {
        return modelMapper.map(entity, IngredienteDTO.class);
    }

    private Ingrediente convertToEntity(IngredienteDTO dto) {
        return modelMapper.map(dto, Ingrediente.class);
    }
}
