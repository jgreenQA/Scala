package battleships

import battleships.Ship.Ship

class Grid(sizeIn: Int) {
  val grid = Array.ofDim[Ship](sizeIn, sizeIn)
  val size = sizeIn

  var lastx: Int = -1
  var lasty: Int = -1

  def printGrid(): Unit = {
    var ship: Ship = null
    System.out.println()
    for (i <- 0 until size) {
      if (i == 0) {
        print("  ")
        for (k <- 0 until size) {
          print(s"$k ")
        }
        println()
      }

      for (j <- 0 until size) {
        ship = grid(i)(j)
        if (j == 0)                      print(s"$i ")
        if (i == lasty && j == lastx)    print("X ")
        else printShip(ship)
      }
      println()
    }
    println()
  }

  def printShip(ship: Ship): Unit = {
    if      (ship == Ship.PATROLBOAT)     print("P ")
    else if (ship == Ship.BATTLESHIP)     print("B ")
    else if (ship == Ship.SUBMARINE)      print("S ")
    else if (ship == Ship.DESTROYER)      print("D ")
    else if (ship == Ship.CARRIER)        print("C ")
    else                                  print("~ ")
  }

  def getSize: Int = size

  def placeShip(ship: Ship, x: Int, y: Int, direction: String): Boolean = {
    if (grid(y)(x) == null) {
      if (direction.toLowerCase == "left")  for (i <- 0 to ship.getSize) grid(y)(x - i) = ship
      if (direction.toLowerCase == "right") for (i <- 0 to ship.getSize) grid(y)(x + i) = ship
      if (direction.toLowerCase == "up")    for (i <- 0 to ship.getSize) grid(y + i)(x) = ship
      if (direction.toLowerCase == "down")  for (i <- 0 to ship.getSize) grid(y - i)(x) = ship
      true
    }
    else false
  }

  def checkShot(x: Int, y: Int): Boolean = {
    this.lastx = x; this.lasty = y
    if (grid(y)(x) != null) {
      grid(y)(x) = null
      true
    }
    else false
  }

  def hasLost: Boolean = {
    for (i <- 0 to grid.length; j <- 0 to grid.length) {
      if (grid(i)(j) != null) {
        false
      }
    }
    true
  }
}