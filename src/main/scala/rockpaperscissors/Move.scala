package rockpaperscissors

object Move {
  sealed abstract class Move(val name: String, val wins: List[String], val loses: List[String]) {
    def getName: String = name

    def getWins: List[String] = wins

    def getLoses: List[String] = loses

    def beats(oppMove: Move): Boolean = {
      oppMove.getName match {
        case m if this.getWins contains m => true
        case m if this.getLoses contains m => false
        case _ => false
      }
    }

    override def toString: String = name
  }

  case object ROCK      extends Move("rock", List("scissors", "lizard"), List("paper", "spock"))
  case object PAPER     extends Move("paper", List("rock", "spock"), List("scissors", "lizard"))
  case object SCISSORS  extends Move("scissors", List("paper", "lizard"), List("rock", "spock"))
  case object LIZARD    extends Move("lizard", List("paper", "spock"), List("rock", "scissors"))
  case object SPOCK     extends Move("spock", List("scissors", "rock"), List("lizard", "paper"))
}