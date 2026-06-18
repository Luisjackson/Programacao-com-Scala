//Os sensores de uma estação meteorológica em Salvador enviaram um lote de leituras de temperatura.
//O problema é que houve oscilação na rede e alguns dados vieram corrompidos em formato de texto.
//Seu objetivo é garantir que o pipeline não quebre ao tentar converter esses textos para números (Double).

import scala.util.{Try, Success, Failure}

object TesteTry {
  def main(args: Array[String]): Unit = {

    val dadosSensores = List("10.3", "5.6", "70.5", "98.5", "100", "Erro NA REDE ", "10.9", "Falha Na Leitura")


    for(dado <- dadosSensores){

      val tentativa = Try(dado.toDouble)

      tentativa match {
        case Success(value) => println(s"$value")
        case Failure(_) => println(s"o Dado:  '$dado' não passou")
      }
    }

    val dadosLimpos = dadosSensores.map(dado =>
      Try(dado.toDouble).getOrElse(0.0)
    )
    
    println(dadosLimpos)
  }
}


TesteTry.main(Array())