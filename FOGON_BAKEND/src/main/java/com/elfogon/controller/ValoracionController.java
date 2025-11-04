package com.elfogon.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import com.elfogon.Services.IValoracionService;
import com.elfogon.DTO.ValoracionDTO;
import com.elfogon.model.Valoracion;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/valoraciones")
@RequiredArgsConstructor
public class ValoracionController {

    private final IValoracionService service;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<ValoracionDTO>> findAll() throws Exception {
        List<ValoracionDTO> list = service.findAll()
                .stream()
                .map(this::convertToDto)
                .toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ValoracionDTO> findById(@PathVariable("id") Integer id) throws Exception {
        ValoracionDTO dto = convertToDto(service.findById(id));
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<Valoracion> save(@Valid @RequestBody ValoracionDTO dto) throws Exception {
        Valoracion obj = service.save(convertToEntity(dto));
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getIdValoracion())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ValoracionDTO> update(@Valid @PathVariable("id") Integer id,
                                                @RequestBody ValoracionDTO dto) throws Exception {
        Valoracion obj = service.update(convertToEntity(dto), id);
        ValoracionDTO dtoResponse = convertToDto(obj);
        return ResponseEntity.ok(dtoResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private ValoracionDTO convertToDto(Valoracion entity) {
        return modelMapper.map(entity, ValoracionDTO.class);
    }

    private Valoracion convertToEntity(ValoracionDTO dto) {
        return modelMapper.map(dto, Valoracion.class);
    }
}
