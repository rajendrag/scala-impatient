package com.sip.chapter3

import java.awt.datatransfer.{DataFlavor, SystemFlavorMap}
import java.util.TimeZone

import scala.collection.mutable.ArrayBuffer
import scala.util.{Sorting, Random}

/**
  * Created by rp on 19/11/15.
  */
object ArraysEx {

  def main (args: Array[String]) {
    createArray(10)
    swapAdjacent
    testList
    swapAdjecentYield
    classifyArray
    computeAvg
    reverseSort
    sortTimeZones
    convertJavaListToScalaBuffer
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
    //approach 1
    for(i <- 0 until a.length if(i % 2 == 1)) {
      val temp = a(i)
      a(i) = a(i-1)
      a(i-1) = temp
    }
    println("Output Array:"+a.mkString(", "))
    //approach 2, but this gives the new array
    val x = a.grouped(2).flatMap(_.reverse).toArray
    println("Corrected array:" + a.mkString(",")+"<==>"+x.mkString(","))
  }

  //Repeat the preceding assignment, but produce a new array with the swapped values. Use for/yield
  def swapAdjecentYield() = {
    val a = Array(1,2,3,4,5)
    println("Inpur Array:"+a.mkString(","))
    val k = for(i <- 0 until a.length) yield {
      if(i % 2 == 0)
        if(i == a.length -1)
          a(i)
        else
          a(i+1)
      else
        a(i-1)
    }
    println("Outpu Array:"+k.mkString(","))
  }

  /**4. Given an array of integers, produce a new array that contains all positive
  values of the original array, in their original order, followed by all values that
  are zero or negative, in their original order.
  */
  def classifyArray(): Unit = {
    val a = Array(4,8,-3,5,-2,0,6, 8, 9, -1,-2,3,4)
    var negCount = a.count(_ <= 0)
    var negTracker = 0;
    val res = new Array[Int](a.length)
    for(i <- a.length-1 to 0 by -1) {
      if(a(i) > 0) {
        res(i - negCount) = a(i)
      } else {
        res(a.length - negTracker - 1) = a(i)
        negCount -= 1
        negTracker += 1
      }
    }
    println("Input:"+a.mkString(",")+" Output:"+ res.mkString(","))
  }
  /**
    * 5. How do you compute the average of an Array[Double] ?
    */
  def computeAvg(): Unit = {
    val a = Array(5.7, 4, 5, 7.8, 9)
    println("Avg of :"+a.mkString(",")+" =>" + (a.sum/a.length))
  }

  /**
    * 6. How do you rearrange the elements of an Array[Int] so that they appear in
    * reverse sorted order? How do you do the same with an ArrayBuffer[Int] ?
    */
  def reverseSort(): Unit = {
    val a = Array(4,8,-3,5,-2,0,6, 8, 9, -1,-2,3,4)
    val b = a.sortWith(_ >= _)
    println("Sorted In reverse : "+ b.mkString(","))

    val y = new ArrayBuffer[Int]()
    y ++= List(4,8,-3,5,-2,0,6, 8, 9, -1,-2,3,4)
    val z = a.sortWith(_ >= _)
    println("Sorted In reverse : "+ z.mkString(","))
  }

  /**
    *  Make a collection of all time zones returned by java.util.TimeZone.getAvailableIDs
    *  that are in America. Strip off the "America/" prefix and sort the result.
    */
  def sortTimeZones() = {
    val timeZones: Array[String] = TimeZone.getAvailableIDs
    val sorted = timeZones.filter(_ startsWith("America/")).sorted
    println("Sorted timezones :"+sorted.mkString(","))
  }


  def convertJavaListToScalaBuffer() = {
    val flavors = SystemFlavorMap.getDefaultFlavorMap().asInstanceOf[SystemFlavorMap]
    import scala.collection.JavaConversions._
    val arrayBuffer = flavors.getNativesForFlavor(DataFlavor.imageFlavor)
    println(arrayBuffer)
  }

  def f(x:Int) = if(x>2) Some(x) else None

  def testList(): Unit = {
    val l = List(1,2,3,4)
    val map: List[Option[Int]] = l.map(x => f(x))

    println(map.mkString(","))
    val map1: List[Int] = l.flatMap(x => f(x))
    println(map1.mkString(","))
  }
}
