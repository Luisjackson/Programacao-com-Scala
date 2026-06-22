import scala.util.{Try, Success, Failure}

object AnaliseSolicitacoes {

  case class Solicitacao(
                          id: Int,
                          cliente: String,
                          rendaMensal: Double,
                          valorSolicitado: Double,
                          scoreCredito: Int,
                          status: String
                        )

  def main(args: Array[String]): Unit = {

    // Mock de Csv/Parquet
    val solicitacoesRaw = List(
      ("1", "João", "5000", "20000", "720", "APROVADA"),
      ("2", "Maria", "3000", "15000", "450", "REPROVADA"),
      ("3", "Carlos", "7000", "30000", "810", "APROVADA"),
      ("4", "Ana", "2500", "10000", "390", "REPROVADA"),
      ("5", "Pedro", "6000", "25000", "670", "EM_ANALISE"),
      ("6", "Lucas", "4000", "18000", "520", "APROVADA"),
      ("7", "Fernanda", "3500", "12000", "480", "EM_ANALISE"),
      ("8", "Juliana", "8000", "40000", "850", "APROVADA"),
      ("9", "Marcos", "2000", "8000", "300", "REPROVADA"),
      ("10", "Patricia", "9000", "50000", "900", "APROVADA"),
      ("11", "Roberto", "1000", "5000", "200", "REPROVADA"),
      ("12", "Camila", "4500", "22000", "610", "EM_ANALISE"),
      ("13", "Erro1", "abc", "10000", "700", "APROVADA"), // renda inválida
      ("14", "Erro2", "4000", "xyz", "650", "APROVADA"), // valor inválido
      ("15", "Erro3", "5000", "20000", "score", "REPROVADA"), // score inválido
      ("16", "Erro4", "3000", "15000", "600", "INEXISTENTE") // status inválido
    )

    val tentativaConversao = solicitacoesRaw.flatMap { linha =>
      Try {
        Solicitacao(id = linha._1.toInt,
          cliente = linha._2,
          rendaMensal = linha._3.toDouble,
          valorSolicitado = linha._4.toDouble,
          scoreCredito = linha._5.toInt,
          status = linha._6
        )
      }.toOption
    }

    println(tentativaConversao)

    val solicitacoesValidas = tentativaConversao.filter(solicitacao =>
      solicitacao.status == "APROVADA" ||
        solicitacao.status == "REPROVADA" ||
        solicitacao.status == "EM_ANALISE"
    )


    val solicitacoesAprovadas = solicitacoesValidas.filter(solicitacao => solicitacao.status == "APROVADA")

    val valoresSolicitados = solicitacoesValidas.map(x => x.valorSolicitado)
    println(valoresSolicitados)

    val somaValoresSolicitados = valoresSolicitados.reduce(_+_)
    println(somaValoresSolicitados)

    val valorTotalAprovado = solicitacoesAprovadas.map(_.valorSolicitado).reduce(_+_)
    println(valorTotalAprovado)

    // Compare na lista de cliente, qual cliente tem o x1 (valorSolicitado) maior.
    val clienteMaiorValorSolicitado = solicitacoesValidas.reduce((x1, x2) => if(x1.valorSolicitado > x2.valorSolicitado) x1 else x2)

    println("Cliente com Maior Valor Solicitado " + clienteMaiorValorSolicitado)

    val clienteMaiorScore = solicitacoesValidas.reduce((x1, x2) => if(x1.scoreCredito > x2.scoreCredito) x1 else x2)
    println("Cliente com maior Score: " + clienteMaiorScore)

    val somaScore = solicitacoesValidas.map(_.scoreCredito).reduce(_+_)
    println(somaScore)

    val mediaScore = somaScore.toDouble / solicitacoesValidas.length
    println("Media de score: " + mediaScore)

    val agrupadoPorStatus = solicitacoesValidas.groupBy(_.status)
    println(agrupadoPorStatus)

    val qtdAgrupadoPorStatus = agrupadoPorStatus.size
    println("agrupado por status: "  + qtdAgrupadoPorStatus)

    val solicitacoesScoreBaixo = solicitacoesValidas.filter(x => x.scoreCredito < 500)
    println(solicitacoesScoreBaixo)




    println(solicitacoesValidas.length)

    val solicitacoesValidasAgrupadas = solicitacoesValidas.groupBy(_.status)

    val clientesDeAltoRisco = solicitacoesScoreBaixo.sortBy(_.scoreCredito)
    println(clientesDeAltoRisco)

    println(
      "===== RELATORIO DE CREDITO =====\n" +
        s"TOTAL SOLICITADO: $somaValoresSolicitados\n" +
        s"TOTAL APROVADO: $valorTotalAprovado\n" +
        s"SCORE MÉDIO: $mediaScore\n" +
        "Solicitacoes por status: \n" +
        agrupadoPorStatus.foreach{ case (status, lista) =>
          println(s"$status: " + lista.length)
        }  +
        s"Clientes de Alto Risco: \n" +

        clientesDeAltoRisco.foreach(s => println(s"${s.cliente} (Score: ${s.scoreCredito})"))


    )
  }
}
AnaliseSolicitacoes.main(Array())