package factorial

object Factorial {
  def main(args: Array[String]): Unit = {
    println(getFactorial(120))
  }

  def getFactorial(a: Int): String = {
    var (e, i) = (a, 1)
    while (e != 1 && i < a) {i += 1; e /= i}
    if (e == 1) s"$a = $i!" else "NONE"
  }
}
