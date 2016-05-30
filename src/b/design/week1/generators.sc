import b.design.week1._

val integers = new Generator[Int] {
  def generate = scala.util.Random.nextInt()
}

val booleans = integers map (_ >= 0)

def leafs: Generator[Leaf] = for {
  x <- integers
} yield Leaf(x)

def nodes: Generator[Node] = for {
  l <- trees
  r <- trees
} yield Node(l, r)

def trees: Generator[Tree] = for {
  isLeaf <- booleans
  tree <- if (isLeaf) leafs else nodes
} yield tree

trees.generate



def single[T](x:T) = new Generator[T] {
  def generate = x
}

def pairs[T, U](t:Generator[T], u: Generator[U]): Generator[(T, U)] = for {
  x <- t
  y <- u
} yield (x, y)

def emptyLists = single(Nil)

def nonEmptyLists = for {
  head <- integers
  tail <- lists
} yield head::tail

def lists: Generator[List[Int]] = for {
  cutoff <- booleans
  list <- if (cutoff) emptyLists else nonEmptyLists
} yield list


def test[T](r: Generator[T], times:Int = 100)(test: T=>Boolean): Unit ={
  for (_ <- 0 until times) {
    val value = r.generate
    assert(test(value), "Test failed for: " + value)
  }
  println("Test passed")
}

test(pairs(lists, lists)) {
  case (xs, ys) => (xs ++ ys).length > xs.length
}
