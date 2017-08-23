package tetrahedral

object Tetrahedral {
  def main(args: Array[String]): Unit = {
    println(getBase(19600))
  }

  def getBase(balls: Long): Long = {
    var tetNum: Long = 0
    var i = 0

    while (tetNum != balls) {
      i += 1
      tetNum = getTetNum(i)
    }
    balls - getTetNum(i-1)
  }

  def getTetNum(num: Int): Long = {
    ((num * (num + 1) * (num + 2)) / 6).toLong
  }
}