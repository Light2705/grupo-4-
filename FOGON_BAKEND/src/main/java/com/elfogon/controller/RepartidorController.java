package com.elfogon.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import com.elfogon.Services.IRepartidorService;
import com.elfogon.DTO.RepartidorDTO;
import com.elfogon.model.Repartidor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/repartidores")
@RequiredArgsConstructor
public class RepartidorController {

    private final IRepartidorService service;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<RepartidorDTO>> findAll() throws Exception {
        List<RepartidorDTO> list = service.findAll()
                .stream()
                .map(this::convertToDto)
                .toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RepartidorDTO> findById(@PathVariable("id") Integer id) throws Exception {
        RepartidorDTO dto = convertToDto(service.findById(id));
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<Repartidor> save(@Valid @RequestBody RepartidorDTO dto) throws Exception {
        Repartidor obj = service.save(convertToEntity(dto));
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getIdRepartidor())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<RepartidorDTO> update(@Valid @PathVariable("id") Integer id,
                                                @RequestBody RepartidorDTO dto) throws Exception {
        Repartidor obj = service.update(convertToEntity(dto), id);
        RepartidorDTO dtoResponse = convertToDto(obj);
        return ResponseEntity.ok(dtoResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private RepartidorDTO convertToDto(Repartidor entity) {
        return modelMapper.map(entity, RepartidorDTO.class);
    }

    private Repartidor convertToEntity(RepartidorDTO dto) {
        return modelMapper.map(dto, Repartidor.class);
    }
}
