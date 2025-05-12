package com.enlatadosmg.enlatado.cliente;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ClienteService {

    private ArbolAVL arbolAVL = new ArbolAVL();

    @Autowired
    private ClienteRepository clienteRepository;

    @PostConstruct
    public void cargarClientesEnArbol() {
        List<ClienteEntity> clientes = clienteRepository.findAll();
        for (ClienteEntity entity : clientes) {
            arbolAVL.insertar(entityToModel(entity));
        }
    }

    public void agregarCliente(Cliente cliente) {
        clienteRepository.save(modelToEntity(cliente));
        arbolAVL.insertar(cliente);
    }

    public Cliente buscarCliente(Long cui) {
        return arbolAVL.buscar(cui);
    }

    private Cliente entityToModel(ClienteEntity entity) {
        return new Cliente(
                entity.getCui(),
                entity.getNombre(),
                entity.getApellido(),
                entity.getTelefono(),
                entity.getDireccion()
        );
    }

    private ClienteEntity modelToEntity(Cliente model) {
        ClienteEntity entity = new ClienteEntity();
        entity.setCui(model.getCui());
        entity.setNombre(model.getNombre());
        entity.setApellido(model.getApellido());
        entity.setTelefono(model.getTelefono());
        entity.setDireccion(model.getDireccion());
        return entity;
    }
}
