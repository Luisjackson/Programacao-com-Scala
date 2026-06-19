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

    val tentativaConversao = solicitacoesRaw.map{ linha =>
      Try{

      }


    }
  }


}