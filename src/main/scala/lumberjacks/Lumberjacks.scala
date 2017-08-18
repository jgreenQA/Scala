package lumberjacks

import scala.io.StdIn.readLine
import scala.util.Random

object Lumberjacks {
  def main(args: Array[String]): Unit = {
    val piles: Array[Array[Int]] = initPiles(Integer.parseInt(readLine("Enter size: ")))
    var logsToPlace = Integer.parseInt(readLine("Enter log amount: "))
    println(s"\nBefore:")
    printPiles(piles)

    fillPiles(piles, logsToPlace)

    println(s"\nAfter:")
    printPiles(piles)
  }

  def initPiles(size: Int): Array[Array[Int]] = {
    val piles = Array.ofDim[Int](size, size)
    for (pileX <- piles.indices; pileY <- piles.indices) piles(pileX)(pileY) = Random.nextInt(8) + 1
    piles
  }

  def fillPiles(piles: Array[Array[Int]], logs: Int): Unit = {
    var logsToPlace = logs

    while (logsToPlace > 0) {
      val leastLogs = piles.flatten.min
      for (pileX <- piles.indices; pileY <- piles.indices) {
        if (piles(pileX)(pileY) == leastLogs && logsToPlace > 0) {
          piles(pileX)(pileY) += 1
          logsToPlace -= 1
        }
      }
    }
  }

  def printPiles(piles: Array[Array[Int]]): Unit = {
    for (pileX <- piles.indices; pileY <- piles.indices) {
      print(s"${piles(pileX)(pileY)} ")
      if (pileY == piles.length - 1) print("\n")
    }
  }
}