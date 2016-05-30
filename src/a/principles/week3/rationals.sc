class Rational(x: Int, y: Int) {
  require(y != 0, "denominator must be non-zero")

  def this(x: Int) = this(x, 1)

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  def numer = x
  def denom = y

  def +(that: Rational) =
    new Rational(
      this.numer * that.denom + that.numer * this.denom,
      this.denom * that.denom)

  def unary_- = new Rational(-numer, denom)

  def -(that: Rational) = this + -that

  def <(that: Rational) = this.numer * that.denom < that.numer * this.denom

  def max(that: Rational) = if (this < that) that else this

  override def toString = {
    val g = gcd(numer, denom)
    numer / g + "/" + denom / g
  }
}

val x = new Rational(1, 2)
val y = new Rational(5, 7)
val z = new Rational(3, 2)
//val strange = new Rational(1, 0)
val a = new Rational(3)

-x

x + y

x - y - z

x < y

y max z
