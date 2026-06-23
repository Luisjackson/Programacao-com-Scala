import scala.io.Source
import scala.util.Try

object RelatorioPalavras {
  def main(args: Array[String]): Unit ={

    val caminho_arquivo = "ProgramacaoComScala/src/main/scala/entregaveis/texto.txt"

    val linhasDoArquivo = lerArquivo(caminho_arquivo)

    val palavrasSeparadas = limpezaENormalizacao(linhasDoArquivo)

    val palavrasFiltradas = filtroERegraDeNegocio(palavrasSeparadas)

    val relatorioFrequencia = agregacaoEFrequencia(palavrasFiltradas)

    gerarRelatorioFinal(relatorioFrequencia)

  }

  def lerArquivo(caminho: String): List[String] = {

    val linhas_do_arquivo = Try {
      val fonte = Source.fromFile(caminho)
      val linhas = fonte.getLines().toList
      fonte.close()
      linhas
    }.getOrElse(List.empty[String])

    if (linhas_do_arquivo.isEmpty) {
      println("Arquivo nao encontrado")
    }

    println(s"Sucesso! Foram lidas ${linhas_do_arquivo.length} linhas do arquivo.\n")

    linhas_do_arquivo
  }

  def limpezaENormalizacao(lista: List[String]): List[String] = {
    lista.flatMap(linha => linha.toLowerCase().split(" "))
  }

  def filtroERegraDeNegocio(lista: List[String]): List[String] = {
    lista.filter(linha => linha.length >= 3)
  }

  def agregacaoEFrequencia(lista: List[String]): Map[String,Int] = {
    val palagrasAgregadas = lista.groupBy(palavra => palavra)

    val frequencia = palagrasAgregadas.map{ case (palavra, listaDeRepetidas) =>
      val quantidade = listaDeRepetidas.length
      palavra -> quantidade
    }
    frequencia
  }

  def gerarRelatorioFinal(frequencia: Map[String, Int]): Unit = {

    val listaDecrescente = frequencia.toList.sortBy(_._2).reverse

    println("\n====== RELATÓRIO DE PALAVRAS ======")

    listaDecrescente.foreach { case (palavra, quantidade) =>
      println(s" * $palavra: $quantidade ocorrências")
    }
    println("===================================")
  }

}


RelatorioPalavras.main(Array())