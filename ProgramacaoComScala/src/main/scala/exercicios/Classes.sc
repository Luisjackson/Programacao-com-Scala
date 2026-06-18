case class Molde(nome: String, tipo: String) {
  def resumo(): String = s"Eu sou uma $nome, uma classe do tipo $tipo"
}

class ClasseNormal(nome: String, tipo: String) {
  def resumo(): String = s"Eu sou uma $nome, uma classe do tipo $tipo"
}


object Classes {
  def main(args: Array[String]): Unit = {

    val moldura = Molde("Classe", "CaseClass")

    println(moldura)

    val nomeAtualizado = moldura.copy(nome = "Luisao")

    println(moldura)

    val molduraNormal = new ClasseNormal("Classe", "ClasseNormal")

    println(molduraNormal)
  }
}

Classes.main(Array())

