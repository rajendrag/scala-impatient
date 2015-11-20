package com.sip.chapter3

import scala.util.Random

/**
  * Created by rp on 19/11/15.
  */
object ArraysEx {

  def main (args: Array[String]) {
    createArray(10)
    swapAdjacent()
  }

  // Write a code snippet that sets a to an array of n random integers between 0 (inclusive) and n (exclusive).
  def createArray(n:Int) = {
    val a:Array[Int] = new Array[Int](n)
    for(x <- 0 until n) {
      a(x) = Random.nextInt(n)
    }
    println(a.mkString(", "))
  }

  //Write a loop that swaps adjacent elements of an array of integers. For example, Array(1, 2, 3, 4, 5) becomes Array(2, 1, 4, 3, 5).
  def swapAdjacent() = {
    val a = Array(1,2,3,4,5)
    println("Inpur Array:"+a.mkString(","))
    for(i <- 0 until a.length if(i % 2 == 1)) {
      val temp = a(i)
      a(i) = a(i-1)
      a(i-1) = temp
    }
    println("Output Array:"+a.mkString(", "))
  }

}
