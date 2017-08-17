package battleships

class Player(n: String) {
  val name: String = n
  var grid: Grid

  var patrolBoatsRemaining: Int = Ship.PATROLBOAT.getAmount
  var battleshipsRemaining: Int = Ship.BATTLESHIP.getAmount
  var submarinesRemaining: Int = Ship.SUBMARINE.getAmount
  var destroyersRemaining: Int = Ship.DESTROYER.getAmount
  var carriersRemaining: Int = Ship.CARRIER.getAmount

  def printGrid(): Unit = grid.printGrid

  def getGrid: Grid = grid

  def makeNewGrid(size: Int): Unit = grid = new Grid(size)

  def getName: String = name

  def makeShotAt(p: Player, x: Int, y: Int): Boolean = p.getGrid.checkShot(x, y)

  def placeShip(s: String, x: Int, y: Int, direction: String): Boolean = {
    var shipName = ""
    if (s.toUpperCase == "P") shipName = "patrol boat"
    if (s.toUpperCase == "B") shipName = "battleship"
    if (s.toUpperCase == "S") shipName = "submarine"
    if (s.toUpperCase == "D") shipName = "destroyer"
    if (s.toUpperCase == "C") shipName = "carrier"

    if (shipName == "patrol boat") {
      if ((patrolBoatsRemaining == 0) || x + Ship.PATROLBOAT.getSize > grid.getSize || y + Ship.PATROLBOAT.getSize > grid.getSize || x - Ship.PATROLBOAT.getSize < 0 || y - Ship.PATROLBOAT.getSize < 0) return false
      else {
        patrolBoatsRemaining -= 1
        grid.placeShip(Ship.PATROLBOAT, x, y, direction)
      }
    }
    else if (shipName == "battleship") {
      if ((battleshipsRemaining == 0) || x + Ship.BATTLESHIP.getSize > grid.getSize || y + Ship.BATTLESHIP.getSize > grid.getSize || x - Ship.BATTLESHIP.getSize < 0 || y - Ship.BATTLESHIP.getSize < 0) return false
      else {
        battleshipsRemaining -= 1
        grid.placeShip(Ship.BATTLESHIP, x, y, direction)
      }
    }
    else if (shipName == "submarine") {
      if ((submarinesRemaining == 0) || x + Ship.SUBMARINE.getSize > grid.getSize || y + Ship.SUBMARINE.getSize > grid.getSize || x - Ship.SUBMARINE.getSize < 0 || y - Ship.SUBMARINE.getSize < 0) return false
      else {
        submarinesRemaining -= 1
        grid.placeShip(Ship.SUBMARINE, x, y, direction)
      }
    }
    else if (shipName == "destroyer") {
      if ((destroyersRemaining == 0) || x + Ship.DESTROYER.getSize > grid.getSize || y + Ship.DESTROYER.getSize > grid.getSize || x - Ship.DESTROYER.getSize < 0 || y - Ship.DESTROYER.getSize < 0) return false
      else {
        destroyersRemaining -= 1
        grid.placeShip(Ship.DESTROYER, x, y, direction)
      }
    }
    else if (shipName == "carrier") {
      if ((carriersRemaining == 0) || x + Ship.CARRIER.getSize > grid.getSize || y + Ship.CARRIER.getSize > grid.getSize || x - Ship.CARRIER.getSize < 0 || y - Ship.CARRIER.getSize < 0) return false
      else {
        carriersRemaining -= 1
        grid.placeShip(Ship.CARRIER, x, y, direction)
      }
    }
    else return false
  }

  def hasLost: Boolean = grid.hasLost

  def getTotalShipsRemaining: Int = patrolBoatsRemaining + battleshipsRemaining + submarinesRemaining + destroyersRemaining + carriersRemaining

  def getPatrolBoatsRemaining: Int = patrolBoatsRemaining

  def getBattleshipsRemaining: Int = battleshipsRemaining

  def getSubmarinesRemaining: Int = submarinesRemaining

  def getDestroyersRemaining: Int = destroyersRemaining

  def getCarriersRemaining: Int = carriersRemaining
}