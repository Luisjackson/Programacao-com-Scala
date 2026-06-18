object TesteOption {
  def main(args: Array[String]): Unit = {

    val idadeLuis: Option[Int] = Some(18)

    println(idadeLuis)// Me retorna Some(18)

    val contatos = Map(
      "Mae" -> 815659,
      "Pai" -> 440289,
      "Irmã" -> 123456
    )

    val numeroPai: Option[Int] = contatos.get("Cachorro") // Vai me retornar None pq não existe

    println(numeroPai)

    val numeroPaiFinal = numeroPai.getOrElse(1) // Tratar com getOrElse

    println(numeroPaiFinal)


  }
}

TesteOption.main(Array())