package com.elfogon.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import com.elfogon.Services.IPlatoService;
import com.elfogon.DTO.PlatoDTO;
import com.elfogon.model.Plato;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/platos")
@RequiredArgsConstructor
public class PlatoController {

    private final IPlatoService service;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<PlatoDTO>> findAll() throws Exception {
        List<PlatoDTO> list = service.findAll()
                .stream()
                .map(this::convertToDto)
                .toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlatoDTO> findById(@PathVariable("id") Integer id) throws Exception {
        PlatoDTO dto = convertToDto(service.findById(id));
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<Plato> save(@Valid @RequestBody PlatoDTO dto) throws Exception {
        Plato obj = service.save(convertToEntity(dto));
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getIdPlato())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlatoDTO> update(@Valid @PathVariable("id") Integer id,
                                           @RequestBody PlatoDTO dto) throws Exception {
        Plato obj = service.update(convertToEntity(dto), id);
        PlatoDTO dtoResponse = convertToDto(obj);
        return ResponseEntity.ok(dtoResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private PlatoDTO convertToDto(Plato entity) {
        return modelMapper.map(entity, PlatoDTO.class);
    }

    private Plato convertToEntity(PlatoDTO dto) {
        return modelMapper.map(dto, Plato.class);
    }
}
