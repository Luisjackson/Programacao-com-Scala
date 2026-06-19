object ManipulacaoDeString {
  def main(args: Array[String]): Unit = {
    val cidade: String = " Salvador "
    println(cidade)

    // Trim remove os espaços em branco do inicio e fim da String
    val cidadeLimpa = cidade.trim()
    println(cidadeLimpa)

    val cpf = "132,659,795+88"
    println(cpf)

    // Replace remove as ocorrencias de um caracter e transforma em outro

    val cpfLimpo = cpf.replace(",",".").replace("+","-")

    println(cpfLimpo)


    // toUpperCase e toLowerCase
    // Transforma a string em Maiscula ou Minuscula

    val nomeMinusculo = "luisjacksonJR"

    val nomeMaiusculo = nomeMinusculo.toUpperCase()
    println(nomeMaiusculo)

    val nomeMinusculoNovamente = nomeMaiusculo.toLowerCase()
    println(nomeMinusculoNovamente)

    // .split("caracter")
    // Pega uma string e transforma ela em pedaços a partir do caracter limitador
    // E transforma em um array
    // Posso acessar com (0) (1) (2) (3) (4) ....

    val nomeCompleto: String = "Luis Jackson Michael Jackon Obama"

    val nomeDividido = nomeCompleto.split(' ')

    for(nome <- nomeDividido) println(nome)

    // .substring(posicao inicial, pos final)
    // Para extrair os caracter de uma posicao especifica
    // Necessario saber as posições corretamente.

    val dataNascimento = "2002-01-15"

    val anoExtraido = dataNascimento.substring(0,4) // Estrair da pos 0 até a 4.

    println(anoExtraido)




  }
}

ManipulacaoDeString.main(Array())