package com.example.exercises

/*
  head = first element of the list
  tail = remainder of the list
  isEmpty = is this list empty
  add(int) => new list with this element added
  toString => a string representation of the list
 */
abstract class MyList {
  def head: Int
  def tail: MyList
  def isEmpty: Boolean
  def add(element: Int): MyList
  def printElements: String
  def append(element: Int): MyList
  def deleteFirst(element: Int): MyList

  override def toString: String = "[" + printElements + "]"
}

object Empty extends MyList {
  override def head: Int = throw new NoSuchElementException

  override def tail: MyList = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add(element: Int): MyList = new Cons(element, Empty)

  override def printElements: String = ""

  def append(element: Int): MyList = new Cons(element, Empty)

  def deleteFirst(element: Int): MyList = this
}

class Cons(h: Int, t: MyList) extends MyList {
  override def head: Int = h

  override def tail: MyList = t

  override def isEmpty: Boolean = false

  override def add(element: Int): MyList = new Cons(element, this)

  override def printElements: String =
    if (t.isEmpty) "" + h
    else h + " " + t.printElements

  def append(element: Int): MyList = new Cons(h, t.append(element))

  def deleteFirst(element: Int): MyList = {
    if (element == h) t
    else new Cons(h, t.deleteFirst(element))
  }
}

object ListTest extends App {
  val list = new Cons(1, new Cons(2, new Cons(3, new Cons(2, Empty))))
  val newList = list.add(4).append(5)
  println(newList)
  println(newList.deleteFirst(2))
}