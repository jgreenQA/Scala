package garage

class Bike(makein: String, modelin: String) extends Vehicle(makein, modelin) {
  super.setMake(makein)
  super.setModel(modelin)

  override def toString: String = super.toString
}