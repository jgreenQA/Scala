package factorial

object Factorial {
  def main(args: Array[String]): Unit = {
    println(getFactorial(120))
  }

  def getFactorial(numberIn: Int): String = {
    var (number, counter) = (numberIn, 1)
    while (number != 1 && counter < numberIn) {counter += 1; number /= counter}
    if (number == 1) s"$numberIn = $counter!" else s"$numberIn = NONE"
  }
}