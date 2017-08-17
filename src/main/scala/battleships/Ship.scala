package battleships

object Ship {
  sealed abstract class Ship(val name: String, val amount: Int, val size: Int) {
    def getName: String = name

    def getAmount: Int = amount

    def getSize: Int = size

    override def toString = name
  }

  case object PATROLBOAT extends Ship("patrol boat", 2, 2)
  case object BATTLESHIP extends Ship("battleship", 2, 3)
  case object SUBMARINE  extends Ship("submarine", 1, 3)
  case object DESTROYER  extends Ship("destroyer", 1, 4)
  case object CARRIER    extends Ship("carrier", 1, 5)

  val ships: Set[Ship] = sealedInstancesOf[Ship]
}