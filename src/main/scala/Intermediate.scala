object Intermediate {
  def main(args: Array[String]): Unit = {
    println(blackjack(18, 21))

    println(uniqueSum(1, 2, 3))

    println(tooHot(80, false))
  }

  def blackjack(num1: Int, num2: Int): Int = {
    if (num1 >= num2 || num2 > 21) num1
    else if (num1 < num2 || num1 > 21) num2
    else 0
  }

  def uniqueSum(num1: Int, num2: Int, num3: Int): Int = {
    var sum = 0
    List(num1, num2, num3).distinct.foreach(sum += _)
    sum
  }

  def tooHot(temp: Int, summer: Boolean): Boolean = {
    if (summer) temp >= 60 && temp <= 100 else temp >= 60 && temp <= 90
  }
}