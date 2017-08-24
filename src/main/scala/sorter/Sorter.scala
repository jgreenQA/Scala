package sorter

object Sorter {
  def main[T](args: Array[String]): Unit = {
    val intItems = List(10, 5, 8, 1, 7)
    sort(intItems).foreach(println)

    val strItems = List("b", "c", "a", "e", "d")
    sort(strItems).foreach(println)
  }

  def sort[T](items: List[T])(implicit ordering: Ordering[T]): List[T] = {
    items.sorted(ordering)
  }
}