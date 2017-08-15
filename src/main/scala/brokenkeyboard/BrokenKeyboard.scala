import scala.collection.mutable.ArrayBuffer
import scala.io.Source.fromFile
import scala.io.StdIn.{readLine,readInt}

object BrokenKeyboard {
  def main(args: Array[String]): Unit = {
    val keys = ArrayBuffer[String]()
    for (_<- 1 to Integer.parseInt(readLine("Enter amount: "))) keys += readLine("Enter keys: ")
    getWords(keys).foreach(println)
  }

  def getWords(keys: ArrayBuffer[String]): ArrayBuffer[String] = {
    val lines = (for (line <- fromFile("words.txt", "utf-8").getLines()) yield line).toList
    var validWords = ArrayBuffer[String]()

    for (b <- keys) {
      var word = ""
      for (a <- lines) if (b.sortWith(_<_) contains a.distinct.sortWith(_<_)) if (a.length > word.length) word = a
      validWords += word
    }
    validWords
  }
}