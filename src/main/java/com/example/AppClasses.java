package com.example;

import com.example.model.Cliente;

public class AppClasses {
    public static void main(String[] args) {
        System.out.println("Criando Classes");
        Cliente cliente = new Cliente();
        cliente.setRenda(-10000);
        cliente.setSexo('M');
        cliente.setAnoNascimento(1980);
        cliente.setNome("Manoel");
        cliente.setCpf("99999999999");
        System.out.println("Renda: " + cliente.getRenda());
        System.out.println("Sexo: " + cliente.getSexo());
        System.out.println("Ano de Nascimento: " + cliente.getAnoNascimento());
        System.out.println("Especial " + cliente.isEspecial());
        System.out.println("Nome: " + cliente.getNome());
        System.out.println("CPF: " + cliente.getCpf());
        System.out.println();

        Cliente cliente2 = new Cliente(2000, 'F');
        cliente2.setAnoNascimento(1970);
        cliente2.setNome("Joana");
        cliente2.setCpf("9999999999");
        System.out.println("Renda: " + cliente2.getRenda());
        System.out.println("Sexo: " + cliente2.getSexo());
        System.out.println("Ano de Nascimento: " + cliente2.getAnoNascimento());
        System.out.println("Especial " + cliente2.isEspecial());
        System.out.println("Nome: " + cliente2.getNome());
        System.out.println("CPF: " + cliente2.getCpf());

        if (cliente.getCpf().equals(cliente2.getCpf())) {
            System.out.println("CPFs são iguais");
        } else {
            System.out.println("Cpfs são diferentes");
        }
    }}
