package com.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TurmaCurso {
    private String local;
    private int vagas;
    private int vagasDisponiveis;
    private Date inicioAulas;
    private Date fimAulas;
    private Date inicioMatriculas;
    private Date fimMatriculas;
    private List<Estudante> estudantesMatriculados;

    public TurmaCurso(String local, int vagas, Date inicioAulas, Date fimAulas, Date inicioMatriculas, Date fimMatriculas) {
        this.local = local;
        this.vagas = vagas;
        this.vagasDisponiveis = vagas;
        this.inicioAulas = inicioAulas;
        this.fimAulas = fimAulas;
        this.inicioMatriculas = inicioMatriculas;
        this.fimMatriculas = fimMatriculas;
        this.estudantesMatriculados = new ArrayList<>();
    }

    public int getVagasDisponiveis() {
        return this.vagasDisponiveis;
    }

    public void setVagasDisponiveis(int vagasDisponiveis) {
        this.vagasDisponiveis = vagasDisponiveis;
    }

    public Date[] getPeriodoMatriculas() {
        return new Date[]{inicioMatriculas, fimMatriculas};
    }

    public boolean podeMatricular(Estudante estudante, Date dataMatricula) {
        if (estudante.getDataNascimento().before(dataMatricula) && this.vagasDisponiveis > 0) {
            Date[] periodoMatriculas = getPeriodoMatriculas();
            return dataMatricula.after(periodoMatriculas[0]) && dataMatricula.before(periodoMatriculas[1]);
        }
        return false;
    }

    public void matricularEstudante(Estudante estudante, Date dataMatricula) {
        if (podeMatricular(estudante, dataMatricula)) {
            this.estudantesMatriculados.add(estudante);
            this.vagasDisponiveis--;
        }
    }

    public List<Estudante> listarEstudantesMatriculados() {
        return this.estudantesMatriculados;
    }
}
