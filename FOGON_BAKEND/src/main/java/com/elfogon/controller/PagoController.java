package com.elfogon.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import com.elfogon.Services.IPagoService;
import com.elfogon.DTO.PagoDTO;
import com.elfogon.model.Pago;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pagos")
@RequiredArgsConstructor
public class PagoController {

    private final IPagoService service;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<PagoDTO>> findAll() throws Exception {
        List<PagoDTO> list = service.findAll()
                .stream()
                .map(this::convertToDto)
                .toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagoDTO> findById(@PathVariable("id") Integer id) throws Exception {
        PagoDTO dto = convertToDto(service.findById(id));
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<Pago> save(@Valid @RequestBody PagoDTO dto) throws Exception {
        Pago obj = service.save(convertToEntity(dto));
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getIdPago())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PagoDTO> update(@Valid @PathVariable("id") Integer id,
                                          @RequestBody PagoDTO dto) throws Exception {
        Pago obj = service.update(convertToEntity(dto), id);
        PagoDTO dtoResponse = convertToDto(obj);
        return ResponseEntity.ok(dtoResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private PagoDTO convertToDto(Pago entity) {
        return modelMapper.map(entity, PagoDTO.class);
    }

    private Pago convertToEntity(PagoDTO dto) {
        return modelMapper.map(dto, Pago.class);
    }
}
