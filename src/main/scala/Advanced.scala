import scala.collection.mutable.ArrayBuffer
import scala.io.Source.fromFile
import scala.math.min

object Advanced {
  def main(args: Array[String]): Unit = {
    //getAnagrams
    //getAnagrams.foreach(println())

    //println(getPrimes(1, 3000000))
    //println(getPrimes(1, 20000000))

    println(commonSubstring("salad", "ladder"))

    println(distance("boot", "battle"))
  }

  def getAnagrams: Unit = {
    var words = ArrayBuffer[String]()
    val lines = (for (line <- fromFile("words.txt", "utf-8").getLines()) yield line).toList
    for (a <- lines; b <- lines) if (b.sortWith(_<_) == a.sortWith(_<_)) words += a
    words.foreach(println)
  }

  def getPrimes(lower: Int = 1, upper: Int): Int = {
    var sum = 0
    for (i <- lower to upper) if (!(2 +: (3 to Math.sqrt(i).toInt by 2) exists (i%_ == 0))) sum += 1
    sum
  }

  def commonSubstring(x: String, y: String): String = {
    val w = Array.ofDim[Int](x.length, y.length)
    var (max, pos) = (0, 0)

    for (i <- 0 until x.length; j <- 0 until y.length if x.charAt(i) == y.charAt(j)) {
      if (i == 0 || j == 0) w(i)(j) = 1 else w(i)(j) = w(i - 1)(j - 1) + 1
      if (max < w(i)(j)) {
        max = w(i)(j)
        pos = i + 1
      }
    }
    if (pos > 0) x.substring(pos - max, pos) else ""
  }

  def distance(a: String, b: String): Int = {
    ((0 to b.length).toList /: a) ((prev, x) => (prev zip prev.tail zip b).scanLeft(prev.head + 1) {
      case (h, ((d, v), y)) => min(min(h + 1, v + 1), d + (if (x == y) 0 else 1))
    }) last
  }
}
