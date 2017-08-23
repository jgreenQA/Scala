package rockpaperscissors

import rockpaperscissors.Move.Move

import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn.readLine
import scala.util.Random

object RockPaperScissors {
  def main(args: Array[String]): Unit = {
    val rounds: Int = 3
    val playersAmount = Integer.parseInt(readLine("Enter amount of players: "))
    val playerName = readLine("Enter your name: ")
    var currRound = 1
    var players = ArrayBuffer[Player]()

    if (playerName.isEmpty) {
      for (i <- 1 to playersAmount) players += new Player(s"AI$i")
    } else {
      players += new Player(playerName)
      for (i <- 1 until playersAmount) players += new Player(s"AI$i")
    }

    while (players.length > 1 || currRound <= rounds) { //for (i <- 1 to rounds if players.length > 1) {
      println(s"\nRound $currRound:")

      chooseMoves(players)

      players.foreach(p => println(s"${p.getName} chose: ${p.getCurrMove}"))

      players = determineWinner(players)

      //println(s"\nAmount of players: ${players.length}")

      if (players.length == 1) {
        println(s"\n${players.head.getName} wins!")
      } else if (players.length == playersAmount) {
        println("\nDraw!")
      } else {
        println("\nWinners:")
        players.foreach(player => print(s"${player.getName}, "))
        println()
        currRound += 1
      }
    }
  }

  def chooseMoves(players: ArrayBuffer[Player]): Unit = {
    val moves = Array('r', 'p', 's', 'l', 'k')

    players.foreach(p => println(p.getLastMove))

    for (player <- players) {
      var moveChar = ' '
      if (player.getName.startsWith("AI") && players.length > 2) moveChar = Random.shuffle(moves.toList).head
      else if (player.getName.startsWith("AI") && players.length == 2) moveChar = Random.shuffle(players.head.getLastMove.getLoses).head.charAt(0)
      else moveChar = readLine("(R)ock, (P)aper, (S)cissors, (L)izard or Spoc(K)?\nEnter move: ").toLowerCase.charAt(0)

      moveChar match {
        case 'r' => player.setMove(Move.ROCK)
        case 'p' => player.setMove(Move.PAPER)
        case 's' => player.setMove(Move.SCISSORS)
        case 'l' => player.setMove(Move.LIZARD)
        case 'k' => player.setMove(Move.SPOCK)
        case _ => None
      }
    }
  }

  def determineWinner(players: ArrayBuffer[Player]): ArrayBuffer[Player] = {
    var winningPlayers = ArrayBuffer[Player]()
    var playedMoves = ArrayBuffer[Move]()

    for (currentPlayer <- players) playedMoves += currentPlayer.getCurrMove

    if (playedMoves.distinct.length != 2) {
      winningPlayers = players
    } else {
      for (comparisonPlayer <- players; currentPlayer <- players) {
        //println(s"\nComp = ${comparisonPlayer.getName} : ${comparisonPlayer.getCurrMove}")
        //println(s"Curr = ${currentPlayer.getName} : ${currentPlayer.getCurrMove}")
        //println(comparisonPlayer.getCurrMove.beats(currentPlayer.getCurrMove))
        if (comparisonPlayer.getCurrMove beats currentPlayer.getCurrMove) {
          winningPlayers += comparisonPlayer
          //println(s"Adding ${comparisonPlayer.getName}")
        }
      }
    }
    //println("\nAll Winners")
    //winningPlayers.foreach(p => println(p.getName))

    //println("\nDistinct Winners")
    //winningPlayers.distinct.foreach(p => println(p.getName))

    winningPlayers.distinct
  }
}