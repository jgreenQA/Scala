import scala.collection.mutable.ListBuffer

class Garage {
  private val vehicles = ListBuffer[Vehicle]()
  private val employees = ListBuffer[Employee]()
  private var isOpen = false

  def addVehicle(v: Vehicle): Boolean = {
    if (isOpen) vehicles += v
    isOpen
  }

  def removeVehicle(v: Vehicle): Boolean = {
    if (isOpen && vehicles.contains(v)) vehicles -= v
    isOpen && vehicles.contains(v)
  }

  def getVehicleByID(id: Int): Vehicle = vehicles(id)

  def open(): Unit = isOpen = true

  def close(): Unit = isOpen = false

  def calcBills(): Int = {
    var sum = 0
    vehicles.foreach(sum += _.getBill())
    sum
  }

  def fixVehicle(v: Vehicle, p: Int): Unit = if (vehicles.contains(v)) v.setBill(p)

  def printContents(): Unit = vehicles.foreach(println)



  def addEmployee(e: Employee): Unit = employees += e

  def getEmployeeByID(id: Int): Employee = employees(id)
}