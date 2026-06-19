# 🚀 Programação com Scala
Este repositório contém os estudos e práticas desenvolvidos durante a trilha de **Fundamentos de Engenharia de Dados**, com o objetivo principal de adquirir fluência nos conceitos essenciais da linguagem Scala voltados para o processamento de Big Data com Apache Spark.

## 🎯 Objetivo
Construir uma base sólida em Scala funcional e Orientação a Objetos, dominando a sintaxe exigida para a criação de pipelines, manipulação de DataFrames e tratamento de dados em larga escala.

## 📚 Tópicos Abordados
Os scripts e exercícios deste repositório cobrem os seguintes conceitos:
- **Sintaxe Básica:** Tipos de dados e variáveis (`val` vs `var`).
- **Estruturas de Controle:** `if/else`, `for`, `match/case`.
- **Coleções e Programação Funcional:** Uso de `List`, `Seq`, `Map`, `Set` e métodos de alta ordem (`map`, `filter`, `reduce`).
- **Orientação a Objetos:** Classes, Objects, `case class` (essencial para Datasets no Spark) e `traits`.
- **Tratamento de Erros Funcional:** O fim do NullPointerException com `Option` e fluxos seguros com `Try`, `Success` e `Failure`.

## 🗂️ Estrutura do Repositório

Para facilitar a avaliação e a organização do código, o repositório foi dividido em duas áreas principais:

* 📁 **`entregaveis/`**: Contém os códigos oficiais exigidos para a conclusão do módulo de *Onboarding*. É aqui que estão os projetos finais e os exercícios consolidados.
* 📁 **`exercicios/`** *(ou testes)*: Contém os rascunhos, testes de conceito (traits, case classes, Try/Option) e práticas diárias feitas durante o estudo teórico.

```text
Programacao-com-Scala/
 ├── ProgramacaoComScala/
 │    ├── build.sbt                # Configurações do projeto SBT
 │    └── src/main/scala/
 │         ├── entregaveis/        # 🎯AVALIAÇÃO
 │              └── ...
 │         └── exercicios/         # 📝 Testes e estudos teóricos
 │              └── ...
 └── README.md
```

## ✅ Entregas do Módulo (Checklist)

As atividades abaixo refletem os requisitos da trilha de Engenharia de Dados e podem ser validadas na pasta `entregaveis/`:

* [x] **Projeto Base:** Projeto inicializado via SBT do zero, versionado no Git, compilando e rodando sem erros.
* [ ] **Domínio de Sintaxe:** 10 a 15 exercícios resolvidos utilizando manipulação de coleções, funções de alta ordem (`map`, `filter`, `reduce`) e modelagem com `case classes`.
* [ ] **Mini-programa (Desafio Final):** Aplicação para ler um arquivo de texto, contar as palavras e imprimir um relatório no terminal. *(Em desenvolvimento)*

## ⚙️ Como Executar o Projeto

Este projeto foi construído utilizando o **SBT (Scala Build Tool)**.

**Pré-requisitos:**

* JDK (Java 8, 11 ou 17)
* SBT instalado
* Git

**Passo a Passo para Avaliação:**

1. Clone este repositório para a sua máquina local:
```bash
git clone [https://github.com/Luisjackson/Programacao-com-Scala.git](https://github.com/Luisjackson/Programacao-com-Scala.git)

```


2. Acesse o diretório raiz do projeto SBT:
```bash
cd Programacao-com-Scala/ProgramacaoComScala

```


3. **Para rodar via terminal (SBT):**
   Inicie o console do SBT e mande executar o projeto. O SBT compilará o código e, se houver múltiplos arquivos executáveis (com `def main`), ele perguntará qual você deseja rodar (ex: os da pasta `entregaveis`).
```bash
sbt run

```


4. **Para rodar via IDE (IntelliJ IDEA):**
* Abra o IntelliJ e clique em *Open*.
* Selecione a pasta `ProgramacaoComScala`.
* Confirme o *Load SBT Project* no canto inferior direito.
* Navegue até `src/main/scala/entregaveis/`, abra o arquivo desejado e clique no botão verde *Run* (Play) ao lado da declaração do `object`.




