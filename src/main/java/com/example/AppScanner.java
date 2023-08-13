package com.example;

import java.util.Scanner;

import com.example.model.Cliente;

public class AppScanner {
    public static void main(String[] args) {
        System.out.println("Criando Classes");
        Cliente cliente = new Cliente();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite o nome: ");
        cliente.setNome(scanner.nextLine());

        System.out.println("Digite o CPF: ");
        cliente.setCpf(scanner.nextLine());

        System.out.println("Digite a cidade: ");
        cliente.setCidade(scanner.nextLine());

        System.out.println("Digite a Renda ");
        cliente.setRenda(scanner.nextDouble());

        System.out.println("Digite o ano de Nascimento: ");
        cliente.setAnoNascimento(scanner.nextInt());
        scanner.nextLine();

        System.out.println("Digite o Sexo (M ou F): ");
        String sexo = scanner.nextLine();
        cliente.setSexo(sexo.charAt(0));

        System.out.println("Renda: " + cliente.getRenda());
        System.out.println("Sexo: " + cliente.getSexo());
        System.out.println("Ano de Nascimento: " + cliente.getAnoNascimento());
        System.out.println("Especial " + cliente.isEspecial());
        System.out.println("Nome: " + cliente.getNome());
        System.out.println("CPF: " + cliente.getCpf());
    }}
