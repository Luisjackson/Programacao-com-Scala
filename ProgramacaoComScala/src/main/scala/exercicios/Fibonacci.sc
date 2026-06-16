// 0 1 1 2 3 5 8 13 21 34
//Mostrar os 10 primeiros numeros da sequencai de fibonaci

object Fibonacci {
  def main(args: Array[String]): Unit = {
    var a = 0
    var b = 1
    for (i <- 1 to 10){
      print(a + " ")
      val proximo = a + b
      a = b
      b = proximo
    }
  }
}

Fibonacci.main(Array())