package com.example;

import java.util.ArrayList;
import java.util.List;

import com.example.model.Cliente;

public class AppListas {
    public static void main(String[] args) {
        List<Cliente> listaClientes = new ArrayList<>();
        var cliente1 = new Cliente();
        cliente1.setNome("Thiago");

        var cliente2 = new Cliente();
        cliente2.setNome("Teo");

        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        for (Cliente cliente : listaClientes) {
            System.out.println(cliente);
        }
    }
}
