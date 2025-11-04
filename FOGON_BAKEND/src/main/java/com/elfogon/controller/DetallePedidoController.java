package com.elfogon.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import com.elfogon.Services.IDetallePedidoService;
import com.elfogon.DTO.DetallePedidoDTO;
import com.elfogon.model.DetallePedido;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/detalles-pedido")
@RequiredArgsConstructor
public class DetallePedidoController {

    private final IDetallePedidoService service;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<DetallePedidoDTO>> findAll() throws Exception {
        List<DetallePedidoDTO> list = service.findAll()
                .stream()
                .map(this::convertToDto)
                .toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetallePedidoDTO> findById(@PathVariable("id") Integer id) throws Exception {
        DetallePedidoDTO dto = convertToDto(service.findById(id));
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<DetallePedido> save(@Valid @RequestBody DetallePedidoDTO dto) throws Exception {
        DetallePedido obj = service.save(convertToEntity(dto));
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getIdDetallePedido())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetallePedidoDTO> update(@Valid @PathVariable("id") Integer id,
                                                   @RequestBody DetallePedidoDTO dto) throws Exception {
        DetallePedido obj = service.update(convertToEntity(dto), id);
        DetallePedidoDTO dtoResponse = convertToDto(obj);
        return ResponseEntity.ok(dtoResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private DetallePedidoDTO convertToDto(DetallePedido entity) {
        return modelMapper.map(entity, DetallePedidoDTO.class);
    }

    private DetallePedido convertToEntity(DetallePedidoDTO dto) {
        return modelMapper.map(dto, DetallePedido.class);
    }
}
