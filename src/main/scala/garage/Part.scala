package garage

class Part(p: Double, b: Boolean, t: Int) {
  var price = p
  var broken = b
  var time = t

  def getPrice: Double = price

  def setPrice(p: Double): Unit = price = p

  def getFixCost: Double = if (broken) price else 0

  def isBroken: Boolean = broken

  def setBroken(b: Boolean): Unit = broken = b

  def getTime: Int = time

  override def toString: String = s"Broken: $broken\nPrice: $price\nTime: $time"
}
