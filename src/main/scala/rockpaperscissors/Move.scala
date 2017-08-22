package rockpaperscissors

object Move {
  sealed abstract class Move(val name: String, val wins: Move, val loses: Move) {
    def getName: String = name

    def getWins: Move = wins

    def getLoses: Move = loses

    override def toString: String = name
  }

  case object ROCK      extends Move("rock", Move.SCISSORS, Move.PAPER)
  case object PAPER     extends Move("paper", Move.ROCK, Move.SCISSORS)
  case object SCISSORS  extends Move("scissors", Move.PAPER, Move.ROCK)
}
