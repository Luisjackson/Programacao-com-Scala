/*
Principais coleçoes
  List

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










