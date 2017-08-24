package creditcard

object CreditCard {
  def main(args: Array[String]): Unit = {
    println(isValid("49927398716"))
    println(addCheck("4992739871"))
  }

  def isValid(cardNo: String): Boolean = {
    val check: Int = cardNo.last.toString.toInt
    val cardNoWithoutCheck = cardNo.dropRight(1).toString.map(_.asDigit).toList

    val sum = cardNoWithoutCheck.reverseMap(no => if (cardNoWithoutCheck.indexOf(no) % 2 != 0) sumDigits(no * 2) else no).sum
    (sum + check) % 10 == 0
  }

  def sumDigits(num: Int): Int = {
    num.toString.map(_.asDigit).toList.sum
  }

  def addCheck(cardNo: String): String = {
    val cardNoToInts = cardNo.toString.map(_.asDigit).toList
    val sum = cardNoToInts.reverseMap(no => if (cardNoToInts.indexOf(no) % 2 != 0) sumDigits(no * 2) else no).sum
    cardNo.concat((10 - (sum % 10)).toString)
  }
}