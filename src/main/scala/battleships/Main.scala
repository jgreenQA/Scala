package battleships

import scala.io.StdIn.readLine
import scala.util.Random

object Main {
  def main(args: Array[String]): Unit = {
    val SIZE: Int = 10
    var playerHasLost: Boolean = false
    var playerHasAnotherShot: Boolean = false
    var x: Int = 0
    var y: Int = 0
    var winner: String = ""

    println("-- SETUP --\n")

    val p1 = new Player(readLine("Enter your name: "))
    val p2 = new Player("Computer")

    p1.makeNewGrid(SIZE)
    p2.makeNewGrid(SIZE)

    p1PlaceShips(p1)
    p2PlaceShips(p2, SIZE)

    while (!playerHasLost) {
      p1.printGrid()
      playerHasAnotherShot = true
      println(s"${p1.getName}'s turn!")

      while (playerHasAnotherShot) {
        println("Enter your coordinates: ")
        x = Integer.parseInt(readLine("x: "))
        y = Integer.parseInt(readLine("y: "))
        if (p1.makeShotAt(p2, x, y)) println("\nHit!")
        else {
          System.out.println("\nMiss!")
          playerHasAnotherShot = false
        }
        playerHasLost = p2.hasLost
      }

      playerHasAnotherShot = true
      println(s"${p2.getName}'s turn!")

      while (playerHasAnotherShot) {
        x = Random.nextInt(SIZE)
        y = Random.nextInt(SIZE)
        println(s"${p2.getName} chose:\nx: $x\ny: $y")
        if (p2.makeShotAt(p1, x, y)) println("\nHit!")
        else {
          System.out.println("\nMiss!")
          playerHasAnotherShot = false
        }
      }

      if (p1.hasLost) {
        winner = p2.getName
        playerHasLost = true
      }
      else if (p2.hasLost) {
        winner = p2.getName
        playerHasLost = true
      }
      println(s"\nGame Over!\n$winner wins!")
    }
  }

  def p1PlaceShips(p1: Player): Unit = {
    while (p1.getTotalShipsRemaining != 0) {
      p1.printGrid()
      println(s"\nPatrol Boats: $p1.getPatrolBoatsRemaining\nBattleships: $p1.getBattleshipsRemaining" +
        s"\nSubmarines: $p1.getSubmarinesRemaining\nDestroyers: $p1.getDestroyersRemaining" +
        s"\nCarriers: $p1.getCarriersRemaining")

      val ship        = readLine("Enter the ship you want to place: ")
      val x           = Integer.parseInt(readLine("x: "))
      val y           = Integer.parseInt(readLine("y: "))
      val direction   = readLine("direction: ")

      if (!p1.placeShip(ship, x, y, direction)) println("Cannot place ship")
    }
  }

  def p2PlaceShips(p2: Player, size: Int): Unit = {
    while (p2.getTotalShipsRemaining != 0) {
      p2.placeShip("patrol boat", Random.nextInt(size), Random.nextInt(size), "right")
      p2.placeShip("patrol boat", Random.nextInt(size), Random.nextInt(size), "up")
      p2.placeShip("battleship", Random.nextInt(size), Random.nextInt(size), "left")
      p2.placeShip("battleship", Random.nextInt(size), Random.nextInt(size), "down")
      p2.placeShip("submarine", Random.nextInt(size), Random.nextInt(size), "left")
      p2.placeShip("destroyer", Random.nextInt(size), Random.nextInt(size), "down")
      p2.placeShip("carrier", Random.nextInt(size), Random.nextInt(size), "right")
    }
  }
}