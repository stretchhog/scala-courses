package b.design.week1

/**
  * Created by timvancann on 30-5-16.
  */
trait Tree

case class Node(left: Tree, right: Tree) extends Tree

case class Leaf(x: Int) extends Tree
