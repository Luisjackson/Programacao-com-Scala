# Lista de Exercícios Scala para Spark e Engenharia de Dados

## Objetivo

Praticar os principais conceitos de Scala utilizados em Engenharia de Dados e Apache Spark:

* Sintaxe básica
* Variáveis (`val` e `var`)
* Estruturas de controle
* Coleções (`List`, `Seq`, `Map`, `Set`)
* Programação funcional (`map`, `filter`, `reduce`, `flatMap`)
* Funções de alta ordem e lambdas
* Orientação a Objetos (`class`, `object`, `case class`, `trait`)
* Tratamento funcional de erros (`Option` e `Try`)
* Processamento de dados
* ETL
* Análises financeiras
* Pipelines de dados

---

# Exercício 1 — Análise de Solicitações de Crédito

## Contexto

Você trabalha em uma fintech que recebe milhares de solicitações de crédito todos os dias.
Antes que uma solicitação seja enviada para análise humana, é necessário gerar alguns indicadores para ajudar na tomada de decisão.
Seu objetivo é desenvolver um programa em Scala capaz de processar uma coleção de solicitações de crédito e gerar um relatório analítico.

## Objetivo

Simular a análise inicial de pedidos de crédito realizados por clientes.

## Conceitos

* case class
* Option
* Try
* filter
* map
* groupBy
* reduce

## Modelo

Solicitação de Crédito:

* id
* cliente
* rendaMensal
* valorSolicitado
* scoreCredito
* status

### Status

* APROVADA
* REPROVADA
* EM_ANALISE

## Requisitos

* Filtrar solicitações aprovadas.
* Calcular valor total solicitado.
* Calcular valor total aprovado.
* Encontrar cliente com maior valor solicitado.
* Encontrar cliente com maior score.
* Calcular média de score dos clientes.
* Agrupar solicitações por status.
* Identificar solicitações com score abaixo de 500.
* Tratar registros inválidos utilizando Try.

## Aproximação com Spark

Muito semelhante a pipelines utilizados por bancos e fintechs para análise de crédito.

## Relatório Esperado

O programa deve gerar um relatório semelhante a:

===== RELATÓRIO DE CRÉDITO =====

- Total solicitado: R$ 450.000 

- Total aprovado: R$ 230.000

- Score médio: 645

Solicitações por status:

- APROVADA -> 8

- REPROVADA -> 4

- EM_ANALISE -> 3

Clientes de alto risco:

- João

- Maria

- Carlos
---

# Exercício 2 — Cadastro e Análise de Funcionários

## Contexto

Você é responsável pelo departamento de Recursos Humanos e precisa gerar um relatório sobre a folha de pagamento e a estrutura da empresa.

## Objetivo

Realizar análises sobre uma base de funcionários.

## Conceitos

* case class
* List
* filter
* map
* reduce
* groupBy

## Modelo

Funcionário:

* id
* nome
* departamento
* salário

## Requisitos

* Listar funcionários por departamento.
* Calcular média salarial por departamento.
* Encontrar maior salário.
* Encontrar menor salário.
* Encontrar funcionários acima da média salarial.

## Aproximação com Spark

Equivalente a relatórios de RH.

## Relatório Esperado

O programa deve gerar um relatório semelhante a:

===== RELATÓRIO DE FUNCIONÁRIOS =====

Média salarial por departamento:
- TI: R$ 8.500
- RH: R$ 6.000
- Vendas: R$ 7.200

Maior salário: R$ 15.000 (Fulano)

Menor salário: R$ 4.000 (Ciclano)

Funcionários com salário acima da média (R$ 7.233):
- Fulano
- Beltrano
---

# Exercício 3 — Detecção de Inadimplência

## Contexto

Você trabalha em uma empresa de cobrança e precisa identificar clientes com pagamentos em atraso para iniciar o processo de negociação.

## Objetivo

Analisar uma carteira de clientes para identificar possíveis inadimplentes.

## Conceitos

* case class
* trait
* Option
* filter
* map
* reduce
* groupBy

## Modelo

Contrato:

* idContrato
* cliente
* valorParcela
* parcelasPagas
* parcelasEmAtraso
* saldoDevedor

## Requisitos

* Identificar contratos inadimplentes.
* Listar clientes com mais de 3 parcelas em atraso.
* Calcular valor total da carteira.
* Calcular saldo devedor total.
* Encontrar cliente com maior dívida.
* Agrupar contratos por faixa de atraso.

### Faixas

* EM_DIA
* ATRASO_LEVE
* ATRASO_MODERADO
* ATRASO_GRAVE

## Desafio Extra

Criar um trait para classificação de risco de inadimplência.

## Aproximação com Spark

Muito parecido com relatórios gerenciais de risco de crédito.

## Relatório Esperado

O programa deve gerar um relatório semelhante a:

===== RELATÓRIO DE INADIMPLÊNCIA =====

- Total da carteira: R$ 1.200.000         

- Total devedor: R$ 150.000

Cliente com maior dívida:
- Empresa X (R$ 25.000)

Clientes com mais de 3 parcelas em atraso:
- Cliente A
- Cliente B
- Cliente C

Contratos por faixa de atraso:
- EM_DIA -> 150
- ATRASO_LEVE -> 20
- ATRASO_MODERADO -> 8
- ATRASO_GRAVE -> 3
---

# Exercício 4 — Processamento de Leituras de Sensores

## Contexto

Você está desenvolvendo um sistema para uma estação meteorológica que coleta dados de temperatura de vários sensores. Ocasionalmente, os sensores enviam dados corrompidos que precisam ser descartados.

## Objetivo

Tratar dados inválidos e gerar estatísticas.

## Conceitos

* List
* map
* filter
* reduce
* Option
* Try
* funções

## Dados

* 25.3
* 31.7
* ERRO
* 42.1
* FALHA
* 18.2
* 29.5
* NULO

## Requisitos

* Converter apenas leituras válidas.
* Descartar leituras inválidas.
* Calcular:

    * média
    * máximo
    * mínimo
* Informar quantas leituras foram descartadas.
* Gerar relatório final.

## Aproximação com Spark

Muito parecida com limpeza de dados antes de gravar em um Data Lake.

## Relatório Esperado

O programa deve gerar um relatório semelhante a:

===== RELATÓRIO DE TEMPERATURA =====

- Leituras válidas: 5
- Leituras descartadas: 3

Estatísticas:
- Média: 27.76 °C
- Máxima: 42.1 °C
- Mínima: 18.2 °C
---

# Exercício 5 — Sistema de Pedidos

## Contexto

Você gerencia um e-commerce e precisa de um resumo diário das vendas para entender o desempenho da loja.

## Objetivo

Analisar pedidos de venda.

## Conceitos

* case class
* filter
* map
* reduce
* groupBy

## Modelo

Pedido:

* id
* cliente
* valor
* status

### Status

* APROVADO
* PENDENTE
* CANCELADO

## Requisitos

* Calcular faturamento total.
* Filtrar pedidos aprovados.
* Agrupar pedidos por status.
* Encontrar pedido mais caro.
* Encontrar pedido mais barato.

## Aproximação com Spark

Análise de vendas.

## Relatório Esperado

O programa deve gerar um relatório semelhante a:

===== RELATÓRIO DE PEDIDOS =====

Faturamento total (aprovados): R$ 12.500

Pedidos por status:
- APROVADO -> 50
- PENDENTE -> 15
- CANCELADO -> 5


- Pedido mais caro: R$ 1.200 (ID: 123)
- Pedido mais barato: R$ 50 (ID: 456)

---

# Exercício 6 — ETL de Clientes

## Contexto

Você precisa preparar uma base de dados de clientes para uma campanha de marketing. A base original contém registros inválidos, e-mails ausentes e clientes inativos que devem ser removidos.

## Objetivo

Simular uma etapa de transformação de dados.

## Conceitos

* case class
* Option
* Try
* funções
* map
* filter

## Modelo

Cliente:

* id
* nome
* email
* status

## Dados

Incluir:

* emails ausentes
* registros inválidos
* status diferentes

## Requisitos

* Validar registros.
* Remover registros inválidos.
* Filtrar clientes ativos.
* Gerar lista final pronta para carregamento.

## Aproximação com Spark

Pipeline ETL.

## Relatório Esperado

O programa deve gerar um relatório semelhante a:

===== RELATÓRIO DE ETL DE CLIENTES =====

Total de registros recebidos: 1000

Registros inválidos removidos: 50

Clientes inativos removidos: 150

Total de clientes ativos e válidos: 800

Exemplo de cliente processado:
- id: 1, nome: "Cliente A", email: "cliente_a@email.com", status: "ATIVO"
---

# Exercício 7 — Análise de Logs

## Contexto

Você é um engenheiro de confiabilidade (SRE) e precisa analisar os logs de uma aplicação para identificar a frequência de erros e outros eventos importantes.

## Objetivo

Processar logs de aplicação.

## Conceitos

* case class
* map
* filter
* groupBy
* Try

## Modelo

Log:

* timestamp
* nível
* mensagem

## Requisitos

* Contar logs por nível.
* Listar apenas erros.
* Encontrar horário com maior quantidade de erros.
* Gerar relatório consolidado.

## Aproximação com Spark

Muito comum em Data Engineering.

## Relatório Esperado

O programa deve gerar um relatório semelhante a:

===== RELATÓRIO DE LOGS =====

Total de logs processados: 15.000

Logs por nível:
- INFO -> 12.000
- WARN -> 2.500
- ERROR -> 500

Horário com pico de erros: 14:35h

Exemplos de mensagens de erro:
- "NullPointerException at com.example.Service:123"
- "Database connection timeout"
---

# Exercício 8 — Word Count

## Contexto

Você precisa analisar um grande volume de texto (como livros, artigos ou posts de redes sociais) para extrair as palavras mais comuns e entender os principais temas abordados.

## Objetivo

Implementar o exemplo clássico do Spark.

## Conceitos

* leitura de arquivo
* flatMap
* map
* groupBy
* reduce

## Arquivo

Arquivo texto contendo várias frases.

## Requisitos

* Contar palavras.
* Encontrar palavras únicas.
* Encontrar palavra mais frequente.
* Exibir Top 10 palavras.

## Aproximação com Spark

É literalmente o primeiro exemplo da documentação do Spark.

## Relatório Esperado

O programa deve gerar um relatório semelhante a:

===== RELATÓRIO DE PALAVRAS =====

Total de palavras: 5.890

Palavras únicas: 1.234

Palavra mais frequente: "scala" (87 vezes)

Top 10 palavras mais frequentes:
1. scala (87)
2. spark (75)
3. dados (68)
4. engenharia (55)
5. pipeline (43)
6. com (41)
7. de (39)
8. para (35)
9. que (31)
10. um (29)
---

# Exercício 9 — Pipeline de Transações Financeiras

## Contexto

Você está construindo um dashboard para um aplicativo de finanças pessoais. O objetivo é dar ao usuário uma visão clara de seus gastos, categorizados e agrupados.

## Objetivo

Projeto integrando conceitos de ETL e processamento financeiro.

## Conceitos

* case class
* trait
* Option
* Try
* map
* filter
* reduce
* groupBy
* funções de alta ordem

## Modelo

Transação:

* id
* cliente
* valor
* categoria
* status

### Categorias

* ALIMENTAÇÃO
* TRANSPORTE
* SAÚDE
* LAZER

### Status

* APROVADA
* PENDENTE
* CANCELADA

## Requisitos

* Criar pelo menos 30 transações.
* Filtrar aprovadas.
* Calcular total movimentado.
* Calcular média por categoria.
* Encontrar maior e menor transação.
* Agrupar por categoria.
* Agrupar por cliente.
* Encontrar clientes que movimentaram mais de R$ 1000.
* Tratar registros inválidos usando Try.
* Utilizar Option para campos opcionais.
* Gerar relatório final.

## Aproximação com Spark

Muito próxima de pipelines financeiros reais.

## Relatório Esperado

O programa deve gerar um relatório semelhante a:

===== RELATÓRIO FINANCEIRO =====

Total movimentado (aprovadas): R$ 8.750,00

Média de gasto por categoria:
- ALIMENTAÇÃO: R$ 85,50

- TRANSPORTE: R$ 45,20
- SAÚDE: R$ 150,00
- LAZER: R$ 120,80

Maior transação: R$ 950,00 (Categoria: LAZER)

Menor transação: R$ 15,00 (Categoria: TRANSPORTE)

Clientes com gastos acima de R$ 1000:
- Cliente X
- Cliente Y
---

# Exercício 10 — Pipeline de Cartões de Crédito

## Contexto

Você trabalha no time de prevenção a fraudes de uma operadora de cartão de crédito. Seu trabalho é analisar o fluxo de transações em tempo real para identificar atividades suspeitas e proteger os clientes.

## Objetivo

Simular o processamento de transações realizadas por cartões de crédito.

## Conceitos

* case class
* trait
* Option
* Try
* map
* filter
* reduce
* groupBy
* funções de alta ordem

## Modelo

TransaçãoCartão:

* id
* cliente
* estabelecimento
* categoria
* valor
* data
* status

### Categorias

* ALIMENTAÇÃO
* TRANSPORTE
* COMPRAS
* SAÚDE
* LAZER

### Status

* APROVADA
* NEGADA
* SUSPEITA

## Requisitos

* Calcular volume financeiro movimentado.
* Calcular ticket médio das compras.
* Identificar cliente que mais gastou.
* Identificar estabelecimento com maior faturamento.
* Agrupar gastos por categoria.
* Calcular percentual de transações negadas.
* Listar transações suspeitas.
* Encontrar os 5 clientes com maior volume financeiro.
* Tratar registros inválidos usando Try.
* Utilizar Option para informações opcionais.

## Desafio Extra

Criar um mecanismo simples de detecção de fraude.

Exemplos:

* Compras acima de R$ 10.000.
* Muitas compras em curto intervalo de tempo.
* Compras em categorias incomuns.

## Aproximação com Spark

Extremamente próximo de pipelines reais de processamento financeiro, risco e antifraude.

## Relatório Esperado

O programa deve gerar um relatório semelhante a:

===== RELATÓRIO DE TRANSAÇÕES DE CARTÃO =====

Volume financeiro total: R$ 2.5M

Ticket médio: R$ 89,50

Cliente com maior volume de gastos:
- Cliente Z (R$ 25.800,00)

Estabelecimento com maior faturamento:
- Loja ABC (R$ 150.000,00)

Percentual de transações negadas: 2.5%

Transações suspeitas de fraude:
- ID: txn_123, Cliente: A, Valor: R$ 12.000, Motivo: Valor muito acima da média
- ID: txn_456, Cliente: B, Valor: R$ 50, Motivo: 5 transações em menos de 1 minuto
Essa versão já está organizada em uma progressão de aprendizado que começa por análises financeiras, alterna com exercícios de dados mais gerais e termina com dois projetos que se aproximam bastante de jobs Spark reais.