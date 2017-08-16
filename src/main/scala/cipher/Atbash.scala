package cipher

object Atbash {
  def main(args: Array[String]): Unit = {
    println(cipher("foobar"))
  }

  def cipher(s: String): String = {
    val alpha = ('a' to 'z').toList
    s.toList.map(x => alpha((alpha.length - 1) - alpha.indexOf(x))).mkString
  }
}
