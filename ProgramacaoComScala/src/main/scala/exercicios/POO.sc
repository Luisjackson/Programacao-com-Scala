import scala.util.Random

class Pessoa(
              val id: Int,
              val nome: String,
              val idade: Int,
              val altura: Double
            ){

  def seApresentar() = println(s"Olá, meu nome é $nome, eu tenho $idade anos, e tenho $altura de altura")

  def nivelDeBeleza(id: Int) = println(s"Com base no seu id: $id, seu nivel de beleza é ${id*idade+100*Random.nextInt(11)}%")
}

val Luis = new Pessoa(1, "Luis", 12, 1.65)

Luis.seApresentar()
Luis.nivelDeBeleza(1)



object calculadora {
  def soma(numero1: Double, numero2: Double): Double = numero1 + numero2
  def subtracao(numero1: Double, numero2: Double): Double = numero1 - numero2
  def divisao(numero1: Double, numero2: Double): Double = numero1 / numero2
  def multiplicacao(numero1: Double, numero2: Double): Double = numero1 * numero2
}


calculadora.soma(1,2)
calculadora.multiplicacao(3,4)

