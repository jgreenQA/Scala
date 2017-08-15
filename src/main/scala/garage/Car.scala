class Car(makein: String, modelin: String) extends Vehicle(makein, modelin) {
  super.setMake(makein)
  super.setModel(modelin)
}