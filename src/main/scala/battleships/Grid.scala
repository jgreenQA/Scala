package battleships

import battleships.Ship.Ship

class Grid(s: Int) {
  val grid = Array.ofDim[Ship](s, s)
  val size = s

  var lastx: Int = -1
  var lasty: Int = -1

  def printGrid(): Unit = {
    var s: Ship = null
    System.out.println()
    for (i <- 0 to size) {
      if (i == 0) {
        print("  ")
        for (k <- 0 to size) {
          print(s"$k ")
        }
        println()
      }

      for (j <- 0 to size) {
        s = grid(i)(j)
        if (j == 0) print(s"$i ")
        if (i == lasty && j == lastx) print("X ")
        if (s == null)                print("~ ")
        if (s == Ship.PATROLBOAT)     print("P ")
        if (s == Ship.BATTLESHIP)     print("B ")
        if (s == Ship.SUBMARINE)      print("S ")
        if (s == Ship.DESTROYER)      print("D ")
        if (s == Ship.CARRIER)        print("C ")
      }
      println()
    }
    println()
  }

  def getSize: Int = size

  def placeShip(s: Ship, x: Int, y: Int, direction: String): Boolean = {
    if (grid(y)(x) == null) {
      if (direction.toLowerCase == "left")  for (i <- 0 to s.getSize) grid(y)(x - i) = s
      if (direction.toLowerCase == "right") for (i <- 0 to s.getSize) grid(y)(x + i) = s
      if (direction.toLowerCase == "up")    for (i <- 0 to s.getSize) grid(y + i)(x) = s
      if (direction.toLowerCase == "down")  for (i <- 0 to s.getSize) grid(y - i)(x) = s
      true
    }
    false
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