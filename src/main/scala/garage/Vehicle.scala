class Vehicle(makein: String, modelin: String) {
  var make: String = makein
  var model: String = modelin
  var bills = 0

  def setBill(p: Int): Unit = bills = p

  def setMake(m: String): Unit = make = m

  def setModel(m: String): Unit = model = m

  def getBill: Int = bills

  def getMake: String = make

  def getModel: String = model

  override def toString: String = s"Make: $make\nModel: $model\nBill: $bills"
}