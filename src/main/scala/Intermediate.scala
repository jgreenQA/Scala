object Intermediate {
  def main(args: Array[String]): Unit = {
    println(blackjack(18, 21))
  }

  def blackjack(x: Int, y: Int): Int = {
    if (x >= y || y > 21) x
    else if (x < y || x > 21) y
    else 0
  }
}