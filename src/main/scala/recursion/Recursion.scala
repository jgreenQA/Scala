package recursion

object Recursion {
  def main(args: Array[String]): Unit = {
    println(sumTo(4))

    println(factorial(4))

    println(countZeros(List(1,0,1,0)))

    println(getMin(List(1,2,3,4)))

    printList(List(1,2,3,4))

    println(sumDigits(123))
  }

  def sumTo(n: Int): Int = {
    if (n == 0) 0
    else n + sumTo(n - 1)
  }

  def factorial(n: Int): Int = {
    if (n == 0) 1
    else n * factorial(n - 1)
  }

  def countZeros(list: List[Int], amount: Int = 0): Int = list match {
    case Nil     => amount
    case 0 :: li => countZeros(li, amount + 1)
    case _ :: li => countZeros(li, amount)
  }

  def getMin(list: List[Int]): Int = list match {
    case Nil      => 0
    case x :: Nil => x
    case x :: li  => math.min(x, getMin(li))
  }

  def printList(list: List[Int]): Unit = list match {
    case x :: Nil => print(s"$x\n")
    case x :: li  => {
      print(s"$x, ")
      printList(li)
    }
  }

  def sumDigits(num: Int, total: Int = 0): Int = num.toString.map(_.asDigit).toList match {
    case Nil      => total
    case x :: Nil => total + x
    case x :: li  => sumDigits(li.mkString.toInt, total + x)
  }
}