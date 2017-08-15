class Vehicle(makein: String, modelin: String) {
  var make = makein
  var model = modelin
  var bills = 0

  def setBill(p: Int): Unit = bills = p

  def setMake(m: String): Unit = make = m

  def setModel(m: String): Unit = model = m

  def getBill(): Int = bills

  def getMake(): String = make

  def getModel(): String = model
}