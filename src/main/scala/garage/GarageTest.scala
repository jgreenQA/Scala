package garage

import scala.util.Random

object GarageTest {
  def main(args: Array[String]): Unit = {
    val garage = new Garage()

    val myCar = new Car("Toyota", "Yaris")

    garage.addEmployee(new Employee("John", "Smith", Random.nextInt(5) + 1))
    garage.addEmployee(new Employee("Fred", "Jones", Random.nextInt(5) + 1))
    garage.addEmployee(new Employee("Mike", "Deere", Random.nextInt(5) + 1))
    garage.addEmployee(new Employee("Sian", "Davis", Random.nextInt(5) + 1))

    garage.open

    println(garage.addVehicle(myCar))
    println(garage.getVehicleByID(0).getMake)

    println(garage.fixVehicle(myCar))
  }
}