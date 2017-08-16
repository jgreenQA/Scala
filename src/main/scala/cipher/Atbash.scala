package cipher

object Atbash {
  def main(args: Array[String]): Unit = {
    println(cipher("wizard"))
  }

  def cipher(s: String): String = {
    val a = ('a' to 'z').toList
    s.toLowerCase.toList.map(x => if (a.contains(x)) a((a.length - 1) - a.indexOf(x)) else x).mkString
  }
}