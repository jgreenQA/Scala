package battleships

class Player(n: String) {
  val name: String = n
  var grid: Grid

  def printGrid(): Unit = g.printGrid

  def getGrid: Grid = grid

  def makeNewGrid(size: Int): Unit = g = new Grid(size)

  def getName: String = name

  def makeShotAt(p: Player, x: Int, y: Int): Boolean = p.getGrid.checkShot(x, y)

  def hasLost: Boolean = g.hasLost

  def getTotalShipsRemaining: Int = patrolBoatsRemaining + battleshipsRemaining + submarinesRemaining + destroyersRemaining + carriersRemaining

  def getPatrolBoatsRemaining: Int = patrolBoatsRemaining

  def getBattleshipsRemaining: Int = battleshipsRemaining

  def getSubmarinesRemaining: Int = submarinesRemaining

  def getDestroyersRemaining: Int = destroyersRemaining

  def getCarriersRemaining: Int = carriersRemaining
}