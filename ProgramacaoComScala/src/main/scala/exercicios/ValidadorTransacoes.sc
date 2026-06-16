object ValidadorTransacoes {
  def main(args: Array[String]): Unit = {

    val transacoes = List(10.0, 500.0, 1500.0, 80.0, 2500.0)
    var totalProcessado: Int = 0

    for (transacao <- transacoes) {

      transacao match{
        case x if x > 2000 => println(s"Transacao nº${totalProcessado}: Alerta Transacao normal")
        case x if x >= 100 && x <= 2000 => println(s"Transacao nº${totalProcessado}: Transacao normal")
        case _ => println(s"Transacao nº${totalProcessado}: de baixo risco")
      }

      totalProcessado += 1

    }

    if(totalProcessado == 5) println((s"Processamento concluido com sucesso, ${totalProcessado} transações"))
    else println("Erro no processamento ")

  }
}

ValidadorTransacoes.main(Array())