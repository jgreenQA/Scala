import scala.collection.mutable.ArrayBuffer
import scala.io.Source.fromFile
import scala.io.StdIn.readLine

object BrokenKeyboard {
  def main(args: Array[String]): Unit = {
    val keys = ArrayBuffer[String]()
    for (_ <- 1 to Integer.parseInt(readLine("Enter amount: "))) keys += readLine("Enter keys: ")
    for (key <- keys; word <- getWords(keys)) println(s"$key = $word")
  }

  def getWords(keys: ArrayBuffer[String]): ArrayBuffer[String] = {
    val lines = (for (line <- fromFile("words.txt", "utf-8").getLines()) yield line).toList
    var validWords = ArrayBuffer[String]()

    for (key <- keys) {
      var word = ""
      for (line <- lines) {
        if (key.distinct.sortWith(_<_) contains line.distinct.sortWith(_<_)) {
          if (line.length > word.length) {
            word = line
          }
        }
      }
      validWords += word
    }
    validWords
  }
}