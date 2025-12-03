package br.com.leonardo.tp3.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Tarefa {
    private final String id;
    private final String titulo;
    private final String descricao;
    private final StatusTarefa status;
    private final Usuario responsavel;
    private final LocalDateTime dataCriacao;

    public Tarefa(String titulo, String descricao, StatusTarefa status, Usuario responsavel) {
        this.id = UUID.randomUUID().toString();
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
        this.responsavel = responsavel;
        this.dataCriacao = LocalDateTime.now();
    }

    private Tarefa(String id, String titulo, String descricao, StatusTarefa status, Usuario responsavel, LocalDateTime dataCriacao) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
        this.responsavel = responsavel;
        this.dataCriacao = dataCriacao;
    }

    public String getId() { return id;}
    public String getTitulo() { return titulo; }
    public String getDescricao() { return descricao; }
    public StatusTarefa getStatus() { return status; }
    public Usuario getResponsavel() { return responsavel; }
    public LocalDateTime getDataCriacao() { return dataCriacao; }

    public Tarefa atribuirResponsavel(Usuario novoResponsavel) {
        return new Tarefa(this.id, this.titulo, this.descricao, this.status, novoResponsavel, this.dataCriacao);
    }

    public Tarefa alterarStatus(StatusTarefa novoStatus) {
        return new Tarefa(this.id, this.titulo, this.descricao, novoStatus, this.responsavel, this.dataCriacao);
    }

    public void exibirDetalhes() {
        System.out.println("--- Detalhes da Tarefa ---");
        System.out.println("ID: " + id);
        System.out.println("Título: " + titulo);
        System.out.println("Status: " + status);
        System.out.println("Responsável: " + (responsavel != null ? responsavel.getNome() : "Não atribuído"));
        System.out.println("--------------------------");
    }
}
