package com.example;

import com.example.model.Cliente;

public class AppOperadoresRelacionais {
    public static void main(String[] args) {
        
        var cliente1 = new Cliente();
        cliente1.setAnoNascimento(1980);

        var cliente2 = new Cliente();
        cliente2.setAnoNascimento(2001);

        if(cliente1.getAnoNascimento() == cliente2.getAnoNascimento()){
            System.out.println("Os clientes nasceram no mesmo ano");
            System.out.println("O ano que os clientes nasceram é " + cliente1.getAnoNascimento());
        }
    }
}
