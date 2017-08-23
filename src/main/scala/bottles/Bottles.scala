package bottles

object Bottles {
  def main(args: Array[String]): Unit = {
    println(getLyrics(99))
  }

  def getLyrics(bottles: Int): String = {
    if (bottles != 0) {
      s"\n\n$bottles bottles of beer on the wall, $bottles bottles of beer." +
        s"\nTake one down and pass it around, ${bottles-1} bottles of beer on the wall. ${getLyrics(bottles-1)}"
    } else {
      s"\n\nNo more bottles of beer on the wall, no more bottles of beer. " +
        s"\nGo to the store and buy some more, 99 bottles of beer on the wall."
    }
  }
}