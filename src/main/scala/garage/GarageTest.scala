package garage

import scala.util.Random

object GarageTest {
  def main(args: Array[String]): Unit = {
    val g = new Garage()

    g.addEmployee(new Employee("John", "Smith", Random.nextInt(5) + 1))
    g.addEmployee(new Employee("Fred", "Jones", Random.nextInt(5) + 1))
    g.addEmployee(new Employee("Mike", "Deere", Random.nextInt(5) + 1))
    g.addEmployee(new Employee("Sian", "Davis", Random.nextInt(5) + 1))

    g.open

    println(g.addVehicle(new Car("Toyota", "Yaris")))
    println(g.getVehicleByID(0).getMake)
  }
}