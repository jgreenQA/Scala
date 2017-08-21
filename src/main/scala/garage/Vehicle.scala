package garage

import scala.collection.mutable.ListBuffer
import scala.util.Random

class Vehicle(makein: String, modelin: String) {
  private val parts = ListBuffer[Part]()
  setParts()
  println(parts)
  var make: String = makein
  var model: String = modelin
  var bills = 0

  def setBill(billsIn: Int): Unit = bills = billsIn

  def setMake(makein: String): Unit = make = makein

  def setModel(modelin: String): Unit = model = modelin

  def getBill: Int = bills

  def getMake: String = make

  def getModel: String = model

  def getTotalCost: Double = {
    var sum: Double = 0
    for (p <- parts if p.isBroken) sum += p.getFixCost
    sum
  }

  def setFixed(): Unit = {
    for (p <- parts if p.isBroken) p.setBroken(false)
  }

  private def setParts(): Unit = for (_ <- 0 until 10) parts += new Part(Random.nextDouble() * 1000, Random.nextBoolean(), Random.nextInt(5) + 1)

  override def toString: String = s"Make: $make\nModel: $model\nBill: $bills"
}