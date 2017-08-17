import com.sun.xml.internal.ws.dump.LoggingDumpTube.Position

object Basic {
  def main(args: Array[String]): Unit = {
    /*println("Hello, world!")

    val s = "Hello World!"
    println(s)

    println(returnString())

    typeInference(1.23)
    typeInference("Hello")
    typeInference(123)
    typeInference(true)

    println(endOfString("Hello", 3))

    println(sum(2, 4, true))

    printMultiple("Hi", 3)

    printSquare("H", 5)

    fizzBuzz("Fizz", "Buzz", 20)

    fizzBuzzRecursion("Fizz", "Buzz", 20)

    printSquareRecursion("H", 4, 4)

    printMultipleRecursion("Hi", 4)

    println(sumPM(2, 3, true))

    println(swap(List(1, 2)))*/

    getIDs().foreach(println)
  }

  def returnString(): String = "Hello World!"

  def typeInference(variable: Any): Unit = println(variable)

  def endOfString(string: String, position: Int): String = string.substring(position - 1)

  def sum(num1: Int, num2: Int, bool: Boolean): Int = {
    if (bool || (num1 == 0 || num2 == 0)) num1 + num2 else num1 * num2
  }

  def printMultiple(string: String, amount: Int): Unit = for (_ <- 1 to amount) println(string)

  def printSquare(string: String, amount: Int): Unit = {
    for (counter <- 0 until amount * amount) {
      if (counter % amount == 0) print("\n")
      print(string)
    }
  }

  def fizzBuzz(string1: String, string2: String, max: Int): Unit = {
    for (number <- 1 to max) {
      if (number % 15 == 0) println(string1 + string2)
      if (number % 3 == 0) println(string1)
      if (number % 5 == 0) println(string2)
      else println(number)
    }
  }

  def fizzBuzzRecursion(string1: String, string2: String, number: Int): Unit = {
    if (number != 0) {
      if (number % 15 == 0) println(string1 + string2)
      if (number % 3 == 0) println(string1)
      if (number % 5 == 0) println(string2)
      else println(number)
      fizzBuzzRecursion("Fizz", "Buzz", number - 1)
    }
  }

  def printSquareRecursion(string: String, counter: Int, amount: Int): Unit = {
    if (counter != 0) {
      println(s"$string" * amount)
      printSquareRecursion(string, counter - 1, amount)
    }
  }

  def printMultipleRecursion(string: String, amount: Int): Unit = {
    if (amount != 0) {
      println(string)
      printMultipleRecursion(string, amount - 1)
    }
  }

  def sumPM(num1: Int, num2: Int, bool: Boolean): Int = {
    bool match {
      case _ if bool || (num1 == 0 || num2 == 0) => num1 + num2
      case _ => num1 * num2
    }
  }

  def swap(x: List[Int]): List[Int] = x.reverse

  def getIDs(): Array[String] = {
    java.util.TimeZone.getAvailableIDs.flatMap{_.split("/").filter(_.length > 1).toList.distinct}
  }
}