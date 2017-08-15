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

    getIDs()
  }

  def returnString(): String = "Hello World!"

  def typeInference(x: Any): Unit = println(x)

  def endOfString(s: String, i: Int): String = s.substring(i - 1)

  def sum(x: Int, y: Int, b: Boolean): Int = {
    if (b || (x == 0 || y == 0)) x + y else x * y
  }

  def printMultiple(s: String, i: Int): Unit = for (_ <- 1 to i) println(s)

  def printSquare(s: String, i: Int): Unit = {
    for (a <- 0 until i * i) {
      if (a % i == 0) print("\n")
      print(s)
    }
  }

  def fizzBuzz(x: String, y: String, i: Int): Unit = {
    for (a <- 1 to i) {
      if (a % 15 == 0) println(x + y)
      if (a % 3 == 0) println(x)
      if (a % 5 == 0) println(y)
      else println(a)
    }
  }

  def fizzBuzzRecursion(x: String, y: String, i: Int): Unit = {
    if (i != 0) {
      if (i % 15 == 0) println(x + y)
      if (i % 3 == 0) println(x)
      if (i % 5 == 0) println(y)
      else println(i)
      fizzBuzzRecursion("Fizz", "Buzz", i - 1)
    }
  }

  def printSquareRecursion(s: String, i: Int, j: Int): Unit = {
    if (i != 0) {
      println(s"$s" * j)
      printSquareRecursion(s, i - 1, j)
    }
  }

  def printMultipleRecursion(s: String, i: Int): Unit = {
    if (i != 0) {
      println(s)
      printMultipleRecursion(s, i - 1)
    }
  }

  def sumPM(x: Int, y: Int, b: Boolean): Int = {
    b match {
      case _ if b || (x == 0 || y == 0) => x + y
      case _ => x * y
    }
  }

  def swap(x: List[Int]): List[Int] = x.reverse

  def getIDs(): Array[String] = {
    java.util.TimeZone.getAvailableIDs.flatMap{_.split("/").filter(_.length > 1).toList}

    //List(java.util.TimeZone.getAvailableIDs.foreach(s => s.split("/")))

    //for (s <- java.util.TimeZone.getAvailableIDs) println(s.split("/"))

    //java.util.TimeZone.getAvailableIDs.filter(_.split("/")).toList
  }
}