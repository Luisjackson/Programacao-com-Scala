/*
Principais coleçoes
  Seq - Estrutura generica ou Lista
  List - Lista c metodos filter/map/reduce
  Set - nao permite duplicados
  Map - estrutura de chave/valor

Principais metodos
  map -> Cria uma nova coleção com a aplicação da função/lambda
  filter -> Filtra a partir da condição
  reduce -> Vai comprimindo a lista até sobra um unico valor
            pode ser soma, pode ser multiplicação e tals.
*/

val listaNumeros = List(1,2,3,4,5,6,7,8,9,10)
val listaNumerosDuplicados = listaNumeros.map(x => x*2)


val ehPah = listaNumeros.filter(x => x % 2 == 0)
val ehImpar = listaNumeros.filter(x => x%2 != 0)


val listaInteiros = List(124, 300, 5691, 5641)
val listaFormatada = listaInteiros.map(x => s"RS ${x/100.0}")

val maioresQueUm = listaNumeros.filter(x => x > 1)

val idades = List(35, 24, 50, 67, 21, 11)
// Filtrar a idade do mais velho
val maisVelho = idades.reduce((acc, x) => if(acc > x) acc else x )

// Somar tudo e mostrar o preço final
val listaPrecosProdutos = List(12, 15, 65, 12, 32, 65)
val PrecosFinal = listaPrecosProdutos.reduce((acc, x) => acc + x)


val sequenciaDeNumeros = Seq(1,2,3,4,5, 5, 4, 7, 1, 2 ,3)

val sequenciaDuplicadas = sequenciaDeNumeros.map(_*2)

val semDuplicados = sequenciaDeNumeros.toSet

print(semDuplicados)

val numerosLuis = Map[String, String](
  "numero" -> "44028922",
  "idade" -> "18",
  "FuturoSalario" -> "300000"
)

println(numerosLuis("FuturoSalario"))

val numeros = Set(1, 2, 3, 4, 5)
val numeros2 = Set(1, 5, 1, 2, 3)
val numeros3 = Set(0, 1, 5, 7, 8)
val numeros4 = Set(5, 2, 3, 4, 0)

val conjuntos = List(numeros, numeros2, numeros3, numeros4)

for (conjunto <- conjuntos) {
  println(conjunto)
}

val numeroExiste = numeros.contains(5)  

def functionsss(parametro: Int): Int = {
  parametro
}

functionsss(10)