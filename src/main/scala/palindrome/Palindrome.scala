package palindrome

object Palindrome {
  def main(args: Array[String]): Unit = {
    println(isPalindrome("hannah"))
  }

  def isPalindrome(str: String): Boolean = {
    str.splitAt(str.length / 2)._1 == str.splitAt(str.length / 2)._2.reverse
  }
}