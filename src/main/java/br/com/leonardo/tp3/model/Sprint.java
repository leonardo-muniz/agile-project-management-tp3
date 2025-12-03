package br.com.leonardo.tp3.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Sprint {
    private String nome;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private List<Tarefa> tarefas;

    public Sprint(String nome, LocalDate dataInicio, LocalDate dataFim) {
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(Tarefa tarefa) {
        this.tarefas.add(tarefa);
    }

    public void removerTarefa(Tarefa tarefa) {
        this.tarefas.remove(tarefa);
    }

    public List<Tarefa> listarTarefas() {
        return tarefas;
    }
}
