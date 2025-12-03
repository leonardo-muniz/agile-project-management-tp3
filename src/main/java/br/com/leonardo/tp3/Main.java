package br.com.leonardo.tp3;

import br.com.leonardo.tp3.repository.MemoriaTarefaRepository;
import br.com.leonardo.tp3.repository.TarefaRepository;
import br.com.leonardo.tp3.service.TarefaService;

public class Main {
    public static void main(String[] args) {
        // 1. Criamos a implementação concreta (dependência)
        TarefaRepository repo = new MemoriaTarefaRepository();

        // 2. Injetamos a dependência no serviço (Injeção via Construtor)
        TarefaService service = new TarefaService(repo);

        // 3. Usamos o serviço
        // O serviço não sabe que está salvando em memória, ele só conhece a interface.

    }
}