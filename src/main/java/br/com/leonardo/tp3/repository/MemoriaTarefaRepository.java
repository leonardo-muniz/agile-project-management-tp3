package br.com.leonardo.tp3.repository;

import br.com.leonardo.tp3.model.Tarefa;
import java.util.ArrayList;
import java.util.List;

public class MemoriaTarefaRepository implements TarefaRepository {
    private final List<Tarefa> listaTarefas = new ArrayList<>();

    @Override
    public void salvar(Tarefa tarefa) {
        listaTarefas.add(tarefa);
        System.out.println("Tarefa salva em memória: " + tarefa.getTitulo());
    }

    @Override
    public List<Tarefa> buscarTodas() {
        return new ArrayList<>(listaTarefas);
    }
}
