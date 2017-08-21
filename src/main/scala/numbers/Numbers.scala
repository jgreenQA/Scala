package numbers

import scala.io.StdIn.readLine
import scala.io.StdIn.readLong

object Numbers {
  def main(args: Array[String]): Unit = {
    print("Enter number: ")
    val num = readLong()
    val scale = readLine("Enter scale: ").toLowerCase.charAt(0)

    if (scale != 's' && scale != 'l') println(s"\nShort scale: ${getNum(num)}\nLong scale: ${toScale(getNum(num), 'l')}")
    else println(getNum(num))
  }

  def getNum(num: Long): String = {
    if (num < 0) s"minus ${getNum(-num)}"

    else if (num >= 100) getScaleName(num)

    else if (num >= 20) num / 10 match {
      case 2    => s"twenty ${getNum(num % 10)}"
      case 3    => s"thirty ${getNum(num % 10)}"
      case 5    => s"fifty ${getNum(num % 10)}"
      case n@_  => s"${getNum(n).stripSuffix("t")}ty ${getNum(num % 10)}"
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
      case n@_  => s"${getNum(n - 10).stripSuffix("t")}teen"
    }
  }

  def toScale(num: String, scale: Char): String = {
    val numToScale: String = if (scale == 'l') {
      num.replaceAll("billion", "milliard")
        .replaceAll("trillion", "billion")
        .replaceAll("quadrillion", "billiard")
        .replaceAll("quintillion", "trillion")
    } else if (scale == 's') {
      num.replaceAll("trillion", "quintillion")
        .replaceAll("billiard", "quadrillion")
        .replaceAll("billion", "trillion")
        .replaceAll("milliard", "billion")
    } else ""
    numToScale
  }

  def getScaleName(num: Long): String = {
    val sScale = Array("quintillion", "quadrillion", "trillion", "billion", "million", "thousand", "hundred")

    num.toString.length match {
      case length if length >= 19 => s"${getNum(num / 1000000000000000000L)} ${sScale(0)} ${getNum(num % 1000000000000000000L)}"
      case length if length >= 15 => s"${getNum(num / 100000000000000L)} ${sScale(1)} ${getNum(num % 100000000000000L)}"
      case length if length >= 13 => s"${getNum(num / 1000000000000L)} ${sScale(2)} ${getNum(num % 1000000000000L)}"
      case length if length >= 10 => s"${getNum(num / 1000000000)} ${sScale(3)} ${getNum(num % 1000000000)}"
      case length if length >= 7 => s"${getNum(num / 1000000)} ${sScale(4)} ${getNum(num % 1000000)}"
      case length if length >= 4 => s"${getNum(num / 1000)} ${sScale(5)} ${getNum(num % 1000)}"
      case length if length >= 3 => s"${getNum(num / 100)} ${sScale(6)} ${getNum(num % 100)}"
      case _ => ""
    }
  }
}