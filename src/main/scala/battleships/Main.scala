package battleships

import scala.io.StdIn.readLine
import scala.util.Random

object Main {
  def main(args: Array[String]): Unit = {
    val SIZE: Int = 10
    var playerHasLost: Boolean = false
    var winner: String = ""

    println("-- SETUP --\n")

    val p1 = new Player(readLine("Enter your name: "), SIZE)
    val p2 = new Player("Computer", SIZE)

    p1PlaceShips(p1)
    p2PlaceShips(p2, SIZE)

    while (!playerHasLost) {
      p1.printGrid()

      println(s"${p1.getName}'s turn!")
      playerHasLost = p1TakeTurn(p1, p2)

      println(s"${p2.getName}'s turn!")
      playerHasLost = p2TakeTurn(p1, p2, SIZE)
    }

    if (p1.hasLost) winner = p2.getName
    else if (p2.hasLost) winner = p1.getName
    println(s"\nGame Over!\n$winner wins!")
  }

  def p1PlaceShips(p1: Player): Unit = {
    while (p1.getTotalShipsRemaining != 0) {
      p1.printGrid()
      println(s"\n(P)atrol Boats: ${p1.getPatrolBoatsRemaining}\n(B)attleships: ${p1.getBattleshipsRemaining}" +
        s"\n(S)ubmarines: ${p1.getSubmarinesRemaining}\n(D)estroyers: ${p1.getDestroyersRemaining}" +
        s"\n(C)arriers: ${p1.getCarriersRemaining}")

      val ship = readLine("Enter the ship you want to place: ")
      val x = Integer.parseInt(readLine("x: "))
      val y = Integer.parseInt(readLine("y: "))
      val direction = readLine("direction: ")

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

  def p1TakeTurn(p1: Player, p2: Player): Boolean = {
    var playerHasAnotherShot = true

    while (playerHasAnotherShot) {
      println("Enter your coordinates: ")
      val x = Integer.parseInt(readLine("x: "))
      val y = Integer.parseInt(readLine("y: "))
      if (p1.makeShotAt(p2, x, y)) println("\nHit!")
      else {
        println("\nMiss!")
        playerHasAnotherShot = false
      }
    }
    p2.hasLost
  }

  def p2TakeTurn(p1: Player, p2: Player, size: Int): Boolean = {
    var playerHasAnotherShot = true

    while (playerHasAnotherShot) {
      val x = Random.nextInt(size)
      val y = Random.nextInt(size)
      println(s"${p2.getName} chose:\nx: $x\ny: $y")
      if (p2.makeShotAt(p1, x, y)) println("\nHit!")
      else {
        println("\nMiss!")
        playerHasAnotherShot = false
      }
    }
    p1.hasLost
  }
}