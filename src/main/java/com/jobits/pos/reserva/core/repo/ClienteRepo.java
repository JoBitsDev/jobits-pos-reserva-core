/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobits.pos.reserva.core.repo;

import com.jobits.pos.reserva.core.domain.Cliente;
import java.util.List;

/**
 *
 * JoBits
 *
 * @author Jorge
 *
 */
public interface ClienteRepo extends com.root101.clean.core.app.repo.CRUDRepository<Cliente> {

    public Cliente crearCliente(Cliente newCliente);
    
    public Cliente editarCliente(Cliente cliente);
    
    public Cliente borrarCliente(Cliente cliente);

    public Cliente findCLiente(int idCliente);

    public List<Cliente> findAllClientes();
    
    

}
