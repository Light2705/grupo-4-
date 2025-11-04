package com.elfogon.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import com.elfogon.Services.IAsignacionRepartoService;
import com.elfogon.DTO.AsignacionRepartoDTO;
import com.elfogon.model.AsignacionReparto;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/asignaciones-reparto")
@RequiredArgsConstructor
public class AsignacionRepartoController {

    private final IAsignacionRepartoService service;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<AsignacionRepartoDTO>> findAll() throws Exception {
        List<AsignacionRepartoDTO> list = service.findAll()
                .stream()
                .map(this::convertToDto)
                .toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AsignacionRepartoDTO> findById(@PathVariable("id") Integer id) throws Exception {
        AsignacionRepartoDTO dto = convertToDto(service.findById(id));
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<AsignacionReparto> save(@Valid @RequestBody AsignacionRepartoDTO dto) throws Exception {
        AsignacionReparto obj = service.save(convertToEntity(dto));
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getIdAsignacion())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AsignacionRepartoDTO> update(@Valid @PathVariable("id") Integer id,
                                                       @RequestBody AsignacionRepartoDTO dto) throws Exception {
        AsignacionReparto obj = service.update(convertToEntity(dto), id);
        AsignacionRepartoDTO dtoResponse = convertToDto(obj);
        return ResponseEntity.ok(dtoResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private AsignacionRepartoDTO convertToDto(AsignacionReparto entity) {
        return modelMapper.map(entity, AsignacionRepartoDTO.class);
    }

    private AsignacionReparto convertToEntity(AsignacionRepartoDTO dto) {
        return modelMapper.map(dto, AsignacionReparto.class);
    }
}
