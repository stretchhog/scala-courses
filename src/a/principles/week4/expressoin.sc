import a.principles.week4._

def show(e: Expr): String = e match {
  case Number(x) => x.toString
  case Sum(l, r) => show(l) + " + " + show(r)
}

show(Sum(Number(1), Number(44)))
