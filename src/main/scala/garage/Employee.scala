package garage

class Employee(fnamein: String, lnamein: String, timein: Int) extends Person(fnamein, lnamein) {
  super.setFname(fnamein)
  super.setLname(lnamein)
  var time = timein

  def getTime: Int = time

  override def toString: String = super.toString
}