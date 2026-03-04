/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import java.util.ArrayList;
import modelo.Cliente;

/**
 *
 * @author LUZ ELENA
 */
public class ControladorCliente {
     ArrayList<Cliente> listaClientes;

    public ControladorCliente() {
        listaClientes = new ArrayList<>();
    }
    
    public boolean registar (Cliente cliente){
        listaClientes.add(cliente);
        return true;
    }
    
    public Cliente buscar (int documento){
        for (int i = 0; i < listaClientes.size(); i++) {
            if(listaClientes.get(i).getDocumento() == documento){
                return listaClientes.get(i);
            }
        }
        return null;
    }
}
