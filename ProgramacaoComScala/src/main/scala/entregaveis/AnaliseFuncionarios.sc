import scala.util.{Try, Failure, Success}

object AnaliseFuncionarios {

  case class Funcionario(
                          id: Int,
                          nome: String,
                          departamento: String,
                          salario: Double
                        )

  def main(args: Array[String]): Unit = {



    val dadosBrutos = List(
      "1,Alice,TI,8000.0",
      "2,Bob,TI,9500.0",
      "3,Carlos,RH,6000.0",
      "4,Diana,Vendas,7200.0",
      "5,Eduardo,Vendas,7800.0",
      "6,Fernanda,RH,6500.0",
      "7,Gabriel,TI,12000.0",
      "8,Helena,Vendas,5500.0",
      "9,Igor,TI,8200.0",
      "10,Julia,RH,5800.0",
      "11,Lucas,Vendas,9300.0",
      "12,Mariana,TI,15000.0",
      "13,Invalido,,0.0",             // Departamento vazio, salário zero
      "14,Sem Salario,TI,INVALIDO",   // Salário não numérico
      "15,Negativo,Vendas,-5000.0",   // Salário negativo
      "16,Nome Vazio,,7000.0",        // Nome e departamento vazios (assumindo que nome não pode ser vazio)
      "ID_INVALIDO,Erro,TI,9000.0",   // ID não numérico
      "18,Falta Campo,TI",            // Linha com campos faltando
      "19,Renato,RH,6200.0",          // Registro válido no meio da sujeira
      "20,Carla,TI,salario_alto"      // Outro salário inválido
    )

    val dadosConvetidos = conversaoDados(dadosBrutos)
    val regrasAplicadas = aplicarRegras(dadosConvetidos)
    gerarRelatorio(regrasAplicadas)

  }

  def conversaoDados(lista: List[String]): List[Funcionario] = {
    lista.flatMap{ linha =>
      Try {
        val campos = linha.split(",")
        Funcionario(
          id = campos(0).toInt,
          nome = campos(1),
          departamento = campos(2),
          salario = campos(3).toDouble
        )
      }.toOption
    }
  }

  def aplicarRegras(lista: List[Funcionario]): List[Funcionario] = {
    lista.filter(funcionario =>
      funcionario.id >= 0 &&
      funcionario.nome.nonEmpty &&
        funcionario.departamento.nonEmpty &&
        funcionario.salario > 0
    )
  }



  def gerarRelatorio(lista: List[Funcionario]): Unit = {

    val departamentoAgrupado = lista.groupBy(_.departamento)

    val somaSalarialPorDepartamento = departamentoAgrupado.view.mapValues{
      func => func.map(_.salario).reduce(_+_)
    }.toMap

    val mediaSalarialPorDepartamento = somaSalarialPorDepartamento.map { case (depto, somaTotal) =>
      val qtdFuncionarios = departamentoAgrupado(depto).length
      val media = somaTotal / qtdFuncionarios
      depto -> media
    }

    val FuncionarioMaiorSalario = lista.reduce((f1, f2) => if(f1.salario > f2.salario) f1 else f2)
    val FuncionarioMenorSalario = lista.reduce((f1,f2) => if(f1.salario < f2.salario) f1 else f2)
    

    val mediaSalarialGeral = (lista.map(_.salario).reduce(_+_))/lista.length

    val funcSalariosAcimaMedia = lista.filter(func => func.salario > mediaSalarialGeral)

    println("====== RELATORIO DE FUNCIONARIOS =======\n")
    println("MEDIA POR DEPARTAMENTO:")
    println(mediaSalarialPorDepartamento)
    println(s"\nO maior Salario: ${FuncionarioMaiorSalario.nome} ${FuncionarioMaiorSalario.salario} ")
    println(s"\nO menor Salario: ${FuncionarioMenorSalario.nome} ${FuncionarioMenorSalario.salario} ")
    println("\nFuncionarios com salario acima da média: \n")
    funcSalariosAcimaMedia.foreach{ funcionario =>
      println(s"${funcionario.nome}: ${funcionario.salario}")
    }

  }

}

AnaliseFuncionarios.main(Array())