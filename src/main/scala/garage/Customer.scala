import garage.Person

class Customer(fnamein: String, lnamein: String) extends Person(fnamein, lnamein) {
  super.setFname(fnamein)
  super.setLname(lnamein)

  override def toString: String = super.toString
}
