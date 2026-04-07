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
        Cliente temp = buscar(cliente.getDocumento());
        if(temp == null){
            listaClientes.add(cliente);
            return true;
        }
        return false;
    }
    
    public Cliente buscar (String documento){
        for (int i = 0; i < listaClientes.size(); i++) {
            if(listaClientes.get(i).getDocumento().equals(documento)){
                return listaClientes.get(i);
            }
        }
        return null;
    }
    
    public ArrayList<Cliente> listarClientes(){
        return listaClientes;
    }

    public void mostrarHistorialCliente(String documento) {
        for (int i = 0; i < listaClientes.size(); i++) {
             if(listaClientes.get(i).getDocumento().equals(documento)) {
                 listaClientes.get(i).mostrarHistorial();
                 return;
             }
        }
        System.out.println("Cliente no encontrado.");
    }

}
