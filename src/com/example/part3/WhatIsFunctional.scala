package com.example.part3

object WhatIsFunctional extends App {

  println(concatenate("Cuong ", "Ngo"))

  println(complexFunction(3)(5))
  println(complexFunction2(3)(5))

  def concatenate : (String, String) => String = (a: String, b: String) => a + b

  def complexFunction : Int => Function1[Int, Int] = new Function[Int, Function1[Int, Int]] {
    override def apply(v1: Int): Int => Int = new Function[Int, Int] {
      override def apply(v2: Int): Int = v1 + v2
    }
  }

  def complexFunction2 : Int => Int => Int = x => y => x + y
}
