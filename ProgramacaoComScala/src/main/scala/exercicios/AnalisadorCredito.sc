
/*
Sua missão é criar um programa em Scala que receba uma lista de registros de
pendências financeiras de um CPF (valores que a pessoa deve no mercado), filtre
 as dívidas cadastradas por engano, aplique uma taxa de juros de atraso e calcule
 o montante total que o cliente precisa regularizar para recuperar o seu score de crédito.

 Regra do Filtro: No sistema do mercado, valores abaixo de R$ 5.0 são
 considerados pequenos erros de sistema ou tarifas residuais e devem ser descartados.
  Use .filter para manter apenas as dívidas maiores ou iguais a 5.0.

  O Resultado Esperado no Terminal:
  === RELATÓRIO DE REGULARIZAÇÃO DE CRÉDITO ===
Dívida Corrigida: R$ 138.575
Dívida Corrigida: R$ 575.0
Dívida Corrigida: R$ 2875.0
=============================================
TOTAL NECESSÁRIO PARA RECUPERAR SCORE: R$ 3588.575

 */

object AnalisadorCredito {

  def filtrarDividas(lista: List[Double]): List[Double] = {
    lista.filter(x => x >= 5.0)
  }

  def main(args: Array[String]): Unit = {

    val dividas = List(120.50, 3.40, 500.00, 1.20, 2500.00, 4.99)

    val dividasFiltradas = filtrarDividas(dividas)

    val FiltradasComTaxaDeJuros = dividasFiltradas.map(_*1.15)

    val valorRestante = FiltradasComTaxaDeJuros.reduce(_+_)

    val DividasFormatadas = FiltradasComTaxaDeJuros.map(x => s"Divida Corrigida: RS ${x}")

    println("=====================")
    println(DividasFormatadas.mkString("\n"))
    println("=====================")
    println(f"Total Necessario para recuperar o Score: ${valorRestante}")



  }

}

AnalisadorCredito.main(Array())