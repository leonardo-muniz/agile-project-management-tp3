package br.com.leonardo.tp3.service;

import br.com.leonardo.tp3.model.Tarefa;
import br.com.leonardo.tp3.repository.TarefaRepository;

// Item 4 do Exercício 5: Classe focada em regra de negócio
public class TarefaService {
    // Item 1 do Exercício 5: Dependência da ABSTRAÇÃO (Interface), não da implementação
    private final TarefaRepository tarefaRepository;

    // INJEÇÃO DE DEPENDÊNCIA VIA CONSTRUTOR
    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public void criarNovaTarefa(Tarefa tarefa) {
        // Validação de Regra de Negócio (SRP)
        if (tarefa.getTitulo() == null || tarefa.getTitulo().isEmpty()) {
            throw new IllegalArgumentException("O título da tarefa é obrigatório.");
        }
        // Delega a persistência para o repositório injetado
        tarefaRepository.salvar(tarefa);
    }

    public void listarTarefas() {
        tarefaRepository.buscarTodas().forEach(Tarefa::exibirDetalhes);
    }
}
