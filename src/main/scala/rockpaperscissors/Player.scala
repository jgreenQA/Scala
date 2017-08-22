package rockpaperscissors

import rockpaperscissors.Move.Move

class Player(nameIn: String) {
  val name: String = nameIn
  var lastMove: Move = Move.ROCK
  var currMove: Move = _

  def getName: String = name

  def setMove(move: Move): Unit = {
    lastMove = currMove
    currMove = move
  }

  def getCurrMove: Move = currMove

  def getLastMove: Move = lastMove
}