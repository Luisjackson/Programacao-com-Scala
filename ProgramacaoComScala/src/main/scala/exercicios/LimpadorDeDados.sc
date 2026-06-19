object LimpadorDeDados {

  case class UsuarioLimpo(nome: String, cpf: String, estado: String)

  def limparRegistro(linhaSujas: String): UsuarioLimpo = {

    val linhaFatiada = linhaSujas.split(";")
    
    val nomeFatiado = linhaFatiada(0).trim.toUpperCase()
    
    val cpfLimpo = linhaFatiada(1).trim.replace(".","").replace("-","")
    
    val estadoLimpo = linhaFatiada(2).trim.toUpperCase()
    

    // 1. Fatie a linha usando o .split(";")
    // 2. Limpe o nome: Remova os espaços nas pontas e deixe tudo MAIÚSCULO
    // 3. Limpe o CPF: Remova os espaços, os pontos e os traços
    // 4. Limpe o Estado: Remova os espaços e deixe tudo MAIÚSCULO

    // Retorne a case class preenchida com as variáveis limpas
    UsuarioLimpo(nomeFatiado, cpfLimpo, estadoLimpo) // Substitua isso!
  }

  def main(args: Array[String]): Unit = {

    // Lote de dados extraídos de um sistema legado (Muito sujos!)
    val dadosBrutos = List(
      "  Luis Jackson ; 111.222.333-44 ; ba ",
      "sofia ; 555.666.777-88 ;  BA",
      " Pedro ; 999.888.777-66 ; rj "
    )

    println("=== INICIANDO PIPELINE DE LIMPEZA ===")

    // Passamos todos os dados pela nossa função de limpeza
    val dadosProcessados = dadosBrutos.map(linha => limparRegistro(linha))


    // Exibe o resultado bonito no console
    dadosProcessados.foreach(usuario => println(usuario))
  }
}



//Resultado esperado no seu terminal quando você rodar:
//UsuarioLimpo(LUIS JACKSON,11122233344,BA)
//UsuarioLimpo(SOFIA,55566677788,BA)
//UsuarioLimpo(PEDRO,99988877766,RJ)

LimpadorDeDados.main(Array())