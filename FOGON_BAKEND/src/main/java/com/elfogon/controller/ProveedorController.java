package com.elfogon.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import com.elfogon.Services.IProveedorService;
import com.elfogon.DTO.ProveedorDTO;
import com.elfogon.model.Proveedor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/proveedores")
@RequiredArgsConstructor
public class ProveedorController {

    private final IProveedorService service;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<ProveedorDTO>> findAll() throws Exception {
        List<ProveedorDTO> list = service.findAll()
                .stream()
                .map(this::convertToDto)
                .toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProveedorDTO> findById(@PathVariable("id") Integer id) throws Exception {
        ProveedorDTO dto = convertToDto(service.findById(id));
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<Proveedor> save(@Valid @RequestBody ProveedorDTO dto) throws Exception {
        Proveedor obj = service.save(convertToEntity(dto));
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getIdProveedor())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProveedorDTO> update(@Valid @PathVariable("id") Integer id,
                                               @RequestBody ProveedorDTO dto) throws Exception {
        Proveedor obj = service.update(convertToEntity(dto), id);
        ProveedorDTO dtoResponse = convertToDto(obj);
        return ResponseEntity.ok(dtoResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private ProveedorDTO convertToDto(Proveedor entity) {
        return modelMapper.map(entity, ProveedorDTO.class);
    }

    private Proveedor convertToEntity(ProveedorDTO dto) {
        return modelMapper.map(dto, Proveedor.class);
    }
}
