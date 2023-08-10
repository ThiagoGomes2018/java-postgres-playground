package com.example;

public class Cliente{
    private String nome;
    private double renda;
    private char sexo;
    private int anoNascimento;
    private boolean especial;
    private String cpf;
    private String cidade;

    public Cliente(){
        double aleatorio = Math.random();
        if(aleatorio > 0.5)
            especial = true;
    }

    public Cliente(double renda, char sexo){
        this();
        setRenda(renda);
        setSexo(sexo);
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

   public boolean isEspecial() {
    return especial;
}

    public void setEspecial(boolean especial) {
        this.especial = especial;
    }

    public double getRenda() {
            return renda;
        }

    public void setRenda(double renda) {
        if (renda>=0) {
            this.renda = renda;
        } else {
            System.out.println("A renda deve ser maior ou igual a 0");
        }
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        if(sexo == 'M' || sexo == 'F')
            this.sexo = sexo;
        else
            System.out.println("Sexo Inválido");
    }

    public String toString(){
        return "Cliente" + nome +"Cidade " + cidade;
    }
}