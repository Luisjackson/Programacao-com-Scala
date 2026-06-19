object LimpadorEstoque {

  // O Molde de Destino
  case class ProdutoLimpo(nome: String, categoria: String, precoFinal: Double)

  def processarLinha(linhaSuja: String): ProdutoLimpo = {

    val linhaSeparada = linhaSuja.split(";")

    val nomeLimpo = linhaSeparada(0).trim.toUpperCase
    val tipoLimpo = linhaSeparada(1).trim.toUpperCase

    val tipoFormatado = tipoLimpo

    val precoSemR$ = linhaSeparada(2).replace("R$","").trim

    val precoFormatado = precoSemR$.replace(".","").replace(",",".")

    val precoDouble = precoFormatado.toDouble


    ProdutoLimpo(nomeLimpo, tipoLimpo, precoDouble)
  }

  def main(args: Array[String]): Unit = {

    // Lote de dados extraídos de um sistema legado
    val exportacaoLegada = List(
      "   smart tv 55 polegadas ; ELETRONICOS ; R$ 2.500,00 ",
      "Cafeteira expressa;  Eletrodomesticos  ;R$ 350,99",
      "  MESA DE ESCRITORIO ; moveis ; R$ 1.200,50   "
    )

    println("=== PROCESSANDO CATÁLOGO DE ESTOQUE ===")

    val catalogoLimpo = exportacaoLegada.map(linha => processarLinha(linha))
    catalogoLimpo.foreach(produto => println(produto))
  }
}

LimpadorEstoque.main(Array())

//Resultado esperado:
//
//  === PROCESSANDO CATÁLOGO DE ESTOQUE ===
//    ProdutoLimpo(SMART TV 55 POLEGADAS, ELETRONICOS, 2500.0)
//  ProdutoLimpo(CAFETEIRA EXPRESSA, ELETRODOMESTICOS, 350.99)
//  ProdutoLimpo(MESA DE ESCRITORIO, MOVEIS, 1200.5)