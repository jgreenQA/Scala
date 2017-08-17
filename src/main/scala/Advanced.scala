import scala.collection.mutable.ArrayBuffer
import scala.io.Source.fromFile
import scala.math.min

object Advanced {
  def main(args: Array[String]): Unit = {
    println(getAnagrams("words.txt"))

    println(getPrimes(1, 3000000))
    println(getPrimes(1, 20000000))

    println(commonSubstring("salad", "ladder"))

    println(distance("boot", "battle"))
  }

  def getAnagrams(file: String): String = {
    var (max, maxLen) = ("", 0)
    val lines = (for (line <- fromFile(file, "utf-8").getLines()) yield line).toList

    val anagrams = lines.map(line => (line.toList.sortWith(_<_), line))
      .groupBy(group => group._1)
      .map(elements => (elements._1, elements._2.map(_._2)))
      .toList
      .sortWith( _._2.size > _._2.size)

    for (anagram <- anagrams) if (anagram._2.length > maxLen && anagram._2.head.length > max.length) {
      max = anagram._2.head
      maxLen = anagram._2.length
    }
    max
  }

  def getPrimes(lower: Int = 1, upper: Int): Int = {
    var sum = 0
    for (number <- lower to upper) if (!(2 +: (3 to Math.sqrt(number).toInt by 2) exists (number %_ == 0))) sum += 1
    sum
  }

  def commonSubstring(string1: String, string2: String): String = {
    val matches = Array.ofDim[Int](string1.length, string2.length)
    var (max, pos) = (0, 0)

    for (xcounter <- 0 until string1.length; ycounter <- 0 until string2.length if string1.charAt(xcounter) == string2.charAt(ycounter)) {
      if (xcounter == 0 || ycounter == 0) {
        matches(xcounter)(ycounter) = 1
      } else {
        matches(xcounter)(ycounter) = matches(xcounter - 1)(ycounter - 1) + 1
      }

      if (max < matches(xcounter)(ycounter)) {
        max = matches(xcounter)(ycounter)
        pos = xcounter + 1
      }
    }
    if (pos > 0) string1.substring(pos - max, pos) else ""
  }

  def distance(string1: String, string2: String): Int = {
    ((0 to string2.length).toList /: string1) ((prev, x) => (prev zip prev.tail zip string2).scanLeft(prev.head + 1) {
      case (h, ((d, v), y)) => min(min(h + 1, v + 1), d + (if (x == y) 0 else 1))
    }) last
  }
}