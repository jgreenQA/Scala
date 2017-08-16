object Intermediate {
  def main(args: Array[String]): Unit = {
    println(blackjack(18, 21))

    println(uniqueSum(1, 2, 3))

    println(tooHot(80, false))
  }

  def blackjack(x: Int, y: Int): Int = {
    if (x >= y || y > 21) x
    else if (x < y || x > 21) y
    else 0
  }

  def uniqueSum(x: Int, y: Int, z: Int): Int = {
    var sum = 0
    List(x, y, z).distinct.foreach(sum += _)
    sum
  }

  def tooHot(x: Int, b: Boolean): Boolean = {
    if (b) x >= 60 && x <= 100 else x >= 60 && x <= 90
  }
}