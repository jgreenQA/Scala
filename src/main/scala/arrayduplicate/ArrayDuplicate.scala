package arrayduplicate

object ArrayDuplicate {
  def main(args: Array[String]): Unit = {
    println(getDuplicate(List(1,2,3,3,4)))
  }

  def getDuplicate(list: List[Int]): Int = {
    (for (ele <- list if list.indexOf(ele) != list.lastIndexOf(ele)) yield ele).distinct.head
  }
}