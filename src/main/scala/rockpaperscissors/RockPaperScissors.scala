package rockpaperscissors

import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn.readLine
import scala.util.Random

object RockPaperScissors {
  def main(args: Array[String]): Unit = {
    val rounds: Int = 3
    val playersAmount = Integer.parseInt(readLine("Enter amount of players: "))
    val playerName = readLine("Enter your name: ")
    var players = ArrayBuffer[Player]()
    players += new Player(playerName)

    for (i <- 1 until playersAmount) players += new Player(s"AI$i")

    for (i <- 1 to rounds if players.length > 1) {
      for (player <- players) chooseMove(player)

      players.foreach(p => println(s"${p.getName} chose: ${p.getCurrMove}"))

      players = determineWinner(players)

      players.foreach(p => println(s"${p.getName}"))

      if (players.length == 1) println(s"${players.head.getName} wins!")
    }
  }

  def chooseMove(player: Player): Unit = {
    val moves = Array('r', 'p', 's')

    var moveChar = ' '
    if (player.getName.startsWith("AI")) moveChar = Random.shuffle(moves.toList).head
    else moveChar = readLine("\n(R)ock, (P)aper or (S)cissors?\nEnter move: ").toLowerCase.charAt(0)

    moveChar match {
      case 'r' => player.setMove(Move.ROCK)
      case 'p' => player.setMove(Move.PAPER)
      case 's' => player.setMove(Move.SCISSORS)
      case _   => None
    }
  }

  def determineWinner(players: ArrayBuffer[Player]): ArrayBuffer[Player] = {
    var winningPlayers = ArrayBuffer[Player]()

    for (comparisonPlayer <- players; currentPlayer <- players) {
      var comparison = comparisonPlayer.getCurrMove

      if (comparison.getWins == currentPlayer.getCurrMove) winningPlayers += comparisonPlayer
    }
    winningPlayers
  }
}