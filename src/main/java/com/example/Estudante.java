package com.example;

import java.util.Date;

public class Estudante {
    private String nome;
    private String matricula;
    private Date dataNascimento;
    private String endereco;
    private String emailInstitucional;
    private Celular celular;
    private static int contadorMatricula = 1000; // Contador para matrículas

    public Estudante(String nome, String matricula, Date dataNascimento, String endereco, String email, Celular celular) {
        this.nome = nome;
        if (matricula.isEmpty()) {
            this.matricula = gerarMatriculaUnica();
        } else {
            this.matricula = matricula;
        }
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.emailInstitucional = email;
        this.celular = celular;
    }

    private String gerarMatriculaUnica() {
        // Obtendo os milissegundos atuais
        long milissegundos = System.currentTimeMillis();

        // Incrementando o contador de matrícula
        contadorMatricula++;

        // Criando a matrícula usando os milissegundos e o contador
        return "M" + milissegundos + contadorMatricula;
    }

    public String getMatricula() {
        return this.matricula;
    }


    public Celular getCelular() {
        return this.celular;
    }

    public Date getDataNascimento() {
        return this.dataNascimento;
    }

}
