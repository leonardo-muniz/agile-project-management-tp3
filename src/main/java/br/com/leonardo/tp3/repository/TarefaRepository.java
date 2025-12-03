package br.com.leonardo.tp3.repository;

import br.com.leonardo.tp3.model.Tarefa;
import java.util.List;

// Item 2 do Exercício 5: Interface definindo o contrato
public interface TarefaRepository {
    void salvar(Tarefa tarefa);
    List<Tarefa> buscarTodas();
}
