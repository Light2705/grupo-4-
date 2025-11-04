package com.elfogon.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import com.elfogon.Services.IPedidoService;
import com.elfogon.DTO.PedidoDTO;
import com.elfogon.model.Pedido;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final IPedidoService service;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<PedidoDTO>> findAll() throws Exception {
        List<PedidoDTO> list = service.findAll()
                .stream()
                .map(this::convertToDto)
                .toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> findById(@PathVariable("id") Integer id) throws Exception {
        PedidoDTO dto = convertToDto(service.findById(id));
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<Pedido> save(@Valid @RequestBody PedidoDTO dto) throws Exception {
        Pedido obj = service.save(convertToEntity(dto));
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getIdPedido())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoDTO> update(@Valid @PathVariable("id") Integer id,
                                            @RequestBody PedidoDTO dto) throws Exception {
        Pedido obj = service.update(convertToEntity(dto), id);
        PedidoDTO dtoResponse = convertToDto(obj);
        return ResponseEntity.ok(dtoResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private PedidoDTO convertToDto(Pedido entity) {
        return modelMapper.map(entity, PedidoDTO.class);
    }

    private Pedido convertToEntity(PedidoDTO dto) {
        return modelMapper.map(dto, Pedido.class);
    }
}
