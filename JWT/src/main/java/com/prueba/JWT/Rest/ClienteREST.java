package com.prueba.JWT.Rest;


import com.prueba.JWT.Model.Cliente;
import com.prueba.JWT.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente/")
public class ClienteREST {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> findById(Integer id) {
        return clienteRepository.findById(id);
    }

    public Page<Cliente> getAllCliente(Integer page, Integer size, Boolean eneablePagination) {
        return clienteRepository.findAll(eneablePagination ? PageRequest.of(page, size): Pageable.unpaged());
    }

    public void deleteCliente(Integer id) {
        clienteRepository.deleteById(id);
    }

    public Cliente updateCliente(Cliente cliente) {
        if(cliente.getId() != 0 && clienteRepository.existsById(cliente.getId()))
        {
            return clienteRepository.save(cliente);
        }
        return null;
    }

    public boolean existById(Integer id) {
        return clienteRepository.existsById(id);
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }
}
