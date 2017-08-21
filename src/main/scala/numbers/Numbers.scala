package numbers

import scala.io.StdIn.readLine

object Numbers {
  def main(args: Array[String]): Unit = {
    val num = Integer.parseInt(readLine("Enter number: ")).toLong
    val scale = readLine("Enter scale: ").toLowerCase.charAt(0)

    if (scale != 's' && scale != 'l') println(s"\nShort scale: ${getNum(num)}\nLong scale: ${getNum(num, 'l')}")
    else println(getNum(num, scale))
  }

  def getNum(num: Long, scale: Char = 's'): String = {
    val sScale = Array("quintillion", "quadrillion", "trillion", "billion", "million", "thousand", "hundred")
    val lScale = Array("trillion", "billiard", "billion", "milliard", "million", "thousand", "hundred")

    if (num < 0) s"minus ${getNum(-num)}"

    else if (scale == 's' && num >= 1000000000000000000L) s"${getNum(num / 1000000000000000000L, scale)} ${sScale(0)} ${getNum(num % 1000000000000000000L, scale)}"
    else if (scale == 's' && num >= 100000000000000L) s"${getNum(num / 100000000000000L, scale)} ${sScale(1)} ${getNum(num % 100000000000000L, scale)}"
    else if (scale == 's' && num >= 1000000000000L) s"${getNum(num / 1000000000000L, scale)} ${sScale(2)} ${getNum(num % 1000000000000L, scale)}"
    else if (scale == 's' && num >= 1000000000) s"${getNum(num / 1000000000, scale)} ${sScale(3)} ${getNum(num % 1000000000, scale)}"
    else if (scale == 's' && num >= 1000000) s"${getNum(num / 1000000, scale)} ${sScale(4)} ${getNum(num % 1000000, scale)}"
    else if (scale == 's' && num >= 1000) s"${getNum(num / 1000, scale)} ${sScale(5)} ${getNum(num % 1000, scale)}"
    else if (scale == 's' && num >= 100) s"${getNum(num / 100, scale)} ${sScale(6)} ${getNum(num % 100, scale)}"

    else if (scale == 'l' && num >= 1000000000000000000L) s"${getNum(num / 1000000000000000000L, scale)} ${lScale(0)} ${getNum(num % 1000000000000000000L, scale)}"
    else if (scale == 'l' && num >= 100000000000000L) s"${getNum(num / 100000000000000L, scale)} ${lScale(1)} ${getNum(num % 100000000000000L, scale)}"
    else if (scale == 'l' && num >= 1000000000000L) s"${getNum(num / 1000000000000L, scale)} ${lScale(2)} ${getNum(num % 1000000000000L, scale)}"
    else if (scale == 'l' && num >= 1000000000) s"${getNum(num / 1000000000, scale)} ${lScale(3)} ${getNum(num % 1000000000, scale)}"
    else if (scale == 'l' && num >= 1000000) s"${getNum(num / 1000000, scale)} ${lScale(4)} ${getNum(num % 1000000, scale)}"
    else if (scale == 'l' && num >= 1000) s"${getNum(num / 1000, scale)} ${lScale(5)} ${getNum(num % 1000, scale)}"
    else if (scale == 'l' && num >= 100) s"${getNum(num / 100, scale)} ${lScale(6)} ${getNum(num % 100, scale)}"

    else if (num >= 20) num / 10 match {
      case 2    => s"twenty ${getNum(num % 10, scale)}"
      case 3    => s"thirty ${getNum(num % 10, scale)}"
      case 5    => s"fifty ${getNum(num % 10, scale)}"
      case n@_  => s"${getNum(n, scale).stripSuffix("t")}ty ${getNum(num % 10, scale)}"
    }

    else num match {
      case 0    => ""
      case 1    => "one"
      case 2    => "two"
      case 3    => "three"
      case 4    => "four"
      case 5    => "five"
      case 6    => "six"
      case 7    => "seven"
      case 8    => "eight"
      case 9    => "nine"
      case 10   => "ten"
      case 11   => "eleven"
      case 12   => "twelve"
      case 13   => "thirteen"
      case 15   => "fifteen";
      case n@_  => s"${getNum(n - 10, scale).stripSuffix("t")}teen"
    }
  }
}