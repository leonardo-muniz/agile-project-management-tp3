package br.com.leonardo.tp3.model;

import java.util.ArrayList;
import java.util.List;

public class Projeto {
    private String nome;
    private String descricao;
    private List<Sprint> sprints;

    public Projeto(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        this.sprints = new ArrayList<>();
    }

    public void adicionarSprint(Sprint sprint) {
        this.sprints.add(sprint);
    }

    public void removerSprint(Sprint sprint) {
        this.sprints.remove(sprint);
    }

    public List<Sprint> listarSprints() {
        return sprints;
    }
}
