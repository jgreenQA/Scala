package hangman

import scala.collection.mutable.ListBuffer
import scala.io.Source.fromFile
import scala.io.StdIn.readLine
import scala.util.Random

object Hangman {
  def main(args: Array[String]): Unit = {
    var guessesAmount = 6
    var guesses = ListBuffer[Char]()
    val word = getWord
    var gameOver = false

    println(formatWord(word, guesses))
    while (!gameOver) {
      guesses += readLine("Enter guess: ").charAt(0)
      if (!(word contains guesses.last)) guessesAmount -= 1
      gameOver = drawGame(word, guessesAmount, guesses)
    }
  }

  def getWord: String = {
    val lines = (for (line <- fromFile("words.txt", "utf-8").getLines()) yield line).toList
    Random.shuffle(lines).head
  }

  def formatWord(word: String, guesses: ListBuffer[Char]): String = {
    var formattedWord = ""
    for (char <- word.toLowerCase) if (!(guesses contains char)) formattedWord += "_" else formattedWord += char
    formattedWord
  }

  def drawGallows(guessesLeft: Int): Unit = {
    var top =           "\n-----"
    var pole =          "\n|\n|\n|\n|\n|\n|"
    var poleWithRope =  "\n|  | \n|\n|\n|\n|\n|"
    var poleWithMan =   "\n|  | \n|  O \n| /|\\\n|  /\\\n|\n|"
    var bottom =        "\n-----"
    var legs =          "\n | |"


    guessesLeft match {
      case 0 => print(top)
        print(poleWithMan)
        print(bottom)
        print(legs)
      case 1 => print(top)
        print(poleWithRope)
        print(bottom)
        print(legs)
      case 2 => print(top)
        print(pole)
        print(bottom)
        print(legs)
      case 3 => print(pole)
        print(bottom)
        print(legs)
      case 4 => print(bottom)
        print(legs)
      case 5 => print(legs)
      case _ => print()
    }
  }

  def drawGame(word: String, guessesAmount: Int, guesses: ListBuffer[Char]): Boolean = {
    drawGallows(guessesAmount)
    print(s"\n\nGuesses: ")
    guesses.foreach(guess => print(s"$guess,"))
    println(s"\nRemaining Incorrect Guesses: $guessesAmount")
    println(formatWord(word, guesses))

    if (!formatWord(word, guesses).contains("_")) {
      println(s"You won!")
      true
    } else if (guessesAmount == 0) {
      println(s"Life is cruel. You are dead. ${word.toUpperCase} killed you")
      true
    } else false
  }
}