object Basic {
  def main(args: Array[String]) : Unit = {
    println("Hello, world!")

    val s = "Hello World"
    println(s)

    println(returnString())

    typeInference(1.23)
    typeInference("Hello")
    typeInference(123)
    typeInference(true)

    println(endOfString("Hello", 3))

    println(sum(2, 4, true))

    printSquare("H", 3)

  }

  def returnString() : String = {
    "Hello World"
  }

  def typeInference(x: Any) : Unit = {
    println(x)
  }

  def endOfString(s: String, i: Int) : String = {
    s.substring(i-1)
  }

  def sum(x: Int, y: Int, b: Boolean) : Int = {
    if (b || (x == 0 || y == 0)) x + y else x * y
  }

  def printSquare(s: String, i: Int) : Unit = {
    for (a <- 1 to i) {
      if (a == i) print("\n")
      print(s)
    }
  }
}