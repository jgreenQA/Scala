package garage

class Part(priceIn: Double, brokenIn: Boolean, timeIn: Int) {
  var price = priceIn
  var broken = brokenIn
  var time = timeIn

  def getPrice: Double = price

  def setPrice(priceIn: Double): Unit = price = priceIn

  def getFixCost: Double = if (broken) price else 0

  def isBroken: Boolean = broken

  def setBroken(brokenIn: Boolean): Unit = broken = brokenIn

  def getTime: Int = time

  override def toString: String = s"Broken: $broken\nPrice: $price\nTime: $time"
}
