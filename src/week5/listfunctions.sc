
val nums = List(1, -4, 5, 0, -6, 2)
val fruits = List("apple", "orange", "banana")

def func(x: Int) = x > 0
nums filter func
nums filterNot func
nums partition func

nums takeWhile func
nums dropWhile func
nums span func

val data = List("a", "a", "a", "b", "b", "c", "a")

def pack[T](xs: List[T]): List[List[T]] = xs match {
  case Nil => Nil
  case x :: xs1 =>
    val (first, rest) = xs span (y => y == x)
    first :: pack(rest)
}

pack(data)

def encode[T](xs: List[T]): List[(T, Int)] =
  pack(xs) map (ys => (ys.head, ys.length))

encode(data)

