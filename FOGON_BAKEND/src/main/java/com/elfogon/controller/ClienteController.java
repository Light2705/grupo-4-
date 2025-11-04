package com.elfogon.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import com.elfogon.Services.IClienteService;
import com.elfogon.DTO.ClienteDTO;
import com.elfogon.model.Cliente;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final IClienteService service;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> findAll() throws Exception {
        List<ClienteDTO> list = service.findAll()
                .stream()
                .map(this::convertToDto)
                .toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> findById(@PathVariable("id") Integer id) throws Exception {
        ClienteDTO dto = convertToDto(service.findById(id));
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<Cliente> save(@Valid @RequestBody ClienteDTO dto) throws Exception {
        Cliente obj = service.save(convertToEntity(dto));
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getIdCliente())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> update(@Valid @PathVariable("id") Integer id,
                                             @RequestBody ClienteDTO dto) throws Exception {
        Cliente obj = service.update(convertToEntity(dto), id);
        ClienteDTO dtoResponse = convertToDto(obj);
        return ResponseEntity.ok(dtoResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private ClienteDTO convertToDto(Cliente entity) {
        return modelMapper.map(entity, ClienteDTO.class);
    }

    private Cliente convertToEntity(ClienteDTO dto) {
        return modelMapper.map(dto, Cliente.class);
    }
}
