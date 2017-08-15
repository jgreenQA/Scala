object GarageTest {
  def main(args: Array[String]): Unit = {
    val g = new Garage()
    g.open()
    println(g.addVehicle(new Car("Toyota", "Yaris")))
    println(g.getVehicleByID(0).getMake())
  }
}