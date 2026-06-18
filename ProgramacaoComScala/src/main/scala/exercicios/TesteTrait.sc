trait Animal {
  def emitirSom(): Unit
}

case class Cachorro(nome: String, raça: String) extends Animal {

  def emitirSom(): Unit = {
    println("Au Au au")

  }

}
val nina = Cachorro("Ninna", "Poodle")

nina.emitirSom()