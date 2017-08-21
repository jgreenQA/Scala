package garage

import scala.collection.mutable.ListBuffer

class Garage() {
  private val vehicles = ListBuffer[Vehicle]()
  private val employees = ListBuffer[Employee]()
  private var isOpen = false

  def addVehicle(vehicle: Vehicle): Boolean = {
    if (isOpen) vehicles += vehicle
    isOpen
  }

  def removeVehicle(vehicle: Vehicle): Boolean = {
    if (isOpen && vehicles.contains(vehicle)) vehicles -= vehicle
    isOpen && vehicles.contains(vehicle)
  }

  def removeVehicleByID(id: Int): Boolean = {
    if (isOpen && vehicles.size < id) vehicles.drop(id)
    isOpen && vehicles.size < id
  }

  def getVehicleByID(id: Int): Vehicle = vehicles(id)

  def open: Unit = isOpen = true

  def close: Unit = isOpen = false

  def calcBills: Int = {
    var sum = 0
    vehicles.foreach(sum += _.getBill)
    sum
  }

  def fixVehicle(vehicle: Vehicle): Double = {
    var cost: Double = 0
    if (vehicles.contains(vehicle)) {
      cost = vehicle.getTotalCost
      vehicle.setFixed()
    }
    cost
  }

  def printContents(): Unit = vehicles.foreach(println)

  def addEmployee(employee: Employee): Unit = employees += employee

  def getEmployeeByID(id: Int): Employee = employees(id)
}