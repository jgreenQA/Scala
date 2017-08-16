package garage

class Person(fnamein: String, lnamein: String) {
  var fname: String = fnamein
  var lname: String = lnamein

  def setFname(n: String) = fname = n

  def setLname(n: String) = lname = n

  def getFname = fname

  def getLname = lname

  override def toString: String = s"First Name: $fname\nLast Name: $lname"
}
