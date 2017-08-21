package garage

class Person(fnamein: String, lnamein: String) {
  var fname: String = fnamein
  var lname: String = lnamein

  def setFname(fnamein: String) = fname = fnamein

  def setLname(lnamein: String) = lname = lnamein

  def getFname = fname

  def getLname = lname

  override def toString: String = s"First Name: $fname\nLast Name: $lname"
}
