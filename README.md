# Sistema de Gestão de Projetos Ágil - TP3 🚀

Este repositório contém a implementação do **Teste de Performance 3 (TP3)** da disciplina de **Engenharia de Software: Clean Code e Boas Práticas**.

O projeto simula o núcleo de um sistema de gestão de projetos ágil (focado na entidade Tarefa), demonstrando a aplicação prática de padrões de arquitetura, segurança de concorrência e qualidade de código.

## 📋 Sobre o Projeto

O objetivo principal deste trabalho não é apenas criar um software funcional, mas sim aplicar rigorosamente conceitos de **Engenharia de Software** para resolver problemas comuns de desenvolvimento, como acoplamento rígido, efeitos colaterais indesejados e inconsistência de dados em ambientes concorrentes.

## 🛠️ Tecnologias Utilizadas

- **Java 21** (Linguagem Core)
- **Maven** (Gerenciamento de Dependências)
- **JUnit 5** (Testes Unitários)
- **Mockito** (Simulação de dependências para testes isolados)

## 🏗️ Conceitos e Práticas Aplicadas

O código foi estruturado para atender aos seguintes requisitos de qualidade:

### 1. Imutabilidade e Concorrência (Exercícios 1 e 3)
A entidade central `Tarefa` e o objeto de valor `RegistroTempo` foram projetados como **Imutáveis**:
- Atributos declarados como `private final`.
- Ausência de métodos *Setters* (evitando mutação de estado).
- Métodos de alteração retornam uma **nova instância** do objeto, garantindo segurança em ambientes *multithread* (Thread-Safety) e eliminando a necessidade de *locks* complexos.

### 2. Controle de Efeitos Colaterais (Exercício 2)
Refatoração de métodos para evitar alterações implícitas de estado (`void` que altera `this`). A abordagem funcional adotada previne inconsistências quando múltiplos processos acessam o mesmo objeto simultaneamente.

### 3. Tipagem Forte e Clareza (Exercício 4)
Substituição de tipos primitivos genéricos por tipos específicos para aumentar a robustez:
- **`BigDecimal`**: Utilizado para valores monetários, evitando erros de precisão de ponto flutuante.
- **`LocalDateTime`**: Utilizado para manipulação de datas (API moderna e imutável do Java).
- **`Enum`**: Utilizado para categorias e status, garantindo *Type Safety* e eliminando "Strings Mágicas".

### 4. Arquitetura e Desacoplamento (Exercício 5)
Aplicação dos princípios **SOLID** e **Injeção de Dependência**:
- **Repository Pattern**: Interface `TarefaRepository` define o contrato de persistência, desacoplando o domínio da infraestrutura.
- **Service Layer**: A classe `TarefaService` contém as regras de negócio e recebe suas dependências via construtor, facilitando a testabilidade e a manutenção.

## 📂 Estrutura do Projeto

```text
src/main/java/br/com/leonardo/tp3
├── model          # Entidades Imutáveis (Tarefa, RegistroTempo, LancamentoFinanceiro)
├── repository     # Interfaces (Contratos) e Implementações de persistência
└── service        # Regras de Negócio com Injeção de Dependência
```

## 🧪 Testes Automatizados
O projeto inclui testes unitários que validam os conceitos aplicados:
- **Teste de Imutabilidade**: Verifica se o objeto original permanece inalterado após operações de modificação.
- **Teste de Validação**: Garante que o sistema rejeite estados inválidos (ex: horas negativas) no momento da construção.
- **Teste com Mocks**: Utiliza Mockito para testar a camada de serviço isoladamente, sem depender de banco de dados real.

Para executar os testes via terminal:
```bash
mvn test
```

--------------------------------------------------------------------------------
*Desenvolvido por [Leonardo Muniz](https://github.com/leonardo-muniz) como requisito avaliativo da disciplina de Engenharia de Software.*