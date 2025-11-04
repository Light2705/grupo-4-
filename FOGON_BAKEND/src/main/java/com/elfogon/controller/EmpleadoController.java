package com.elfogon.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import com.elfogon.Services.IEmpleadoService;
import com.elfogon.DTO.EmpleadoDTO;
import com.elfogon.model.Empleado;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/empleados")
@RequiredArgsConstructor
public class EmpleadoController {

    private final IEmpleadoService service;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<EmpleadoDTO>> findAll() throws Exception {
        List<EmpleadoDTO> list = service.findAll()
                .stream()
                .map(this::convertToDto)
                .toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> findById(@PathVariable("id") Integer id) throws Exception {
        EmpleadoDTO dto = convertToDto(service.findById(id));
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<Empleado> save(@Valid @RequestBody EmpleadoDTO dto) throws Exception {
        Empleado obj = service.save(convertToEntity(dto));
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getIdEmpleado())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> update(@Valid @PathVariable("id") Integer id,
                                              @RequestBody EmpleadoDTO dto) throws Exception {
        Empleado obj = service.update(convertToEntity(dto), id);
        EmpleadoDTO dtoResponse = convertToDto(obj);
        return ResponseEntity.ok(dtoResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private EmpleadoDTO convertToDto(Empleado entity) {
        return modelMapper.map(entity, EmpleadoDTO.class);
    }

    private Empleado convertToEntity(EmpleadoDTO dto) {
        return modelMapper.map(dto, Empleado.class);
    }
}
