package com.sip.chapter4

import scala.io.Source

/**
  * Created by RP on 11/30/15.
  */
object MapEx {
  def main(args: Array[String]) {
    gizmosDiscount
    countWordsImperative
    countWordsDeclerative
  }

  /**
    * Set up a map of prices for a number of gizmos that you covet.
    * Then produce a second map with the same keys and the prices at a 10 percent discount.
    */
  def gizmosDiscount(): Unit = {
    val gizmos = Map(("gizmo1", 20.0), ("gizmo2", 30.0), ("gizmo3", 40.0), ("gizmo4", 50.0), ("gizmo5", 60.0), ("gizmo6", 70.0))
    val newGizmos = gizmos map {case (k, v) => (k, v - (v/10))}
    println(newGizmos.mkString(","))
  }

  /**
    * Write a program that reads words from a file. Use a mutable map to count how often each word appears.
    * To read the words, simply use a java.util.Scanner:
    * val in = new java.util.Scanner(new java.io.File("myfile.txt"))
    * while (in.hasNext()) process in.next()
    * Or look at Chapter 9 for a Scalaesque way.
    * At the end, print out all words and their counts.
    */
  def countWordsImperative() = {
    val in = new java.util.Scanner(new java.io.File("myfile.txt"))
    val dictionary = collection.mutable.Map[String, Int]()
    while (in.hasNext()) {
      for(x <- in.next().split(" ")) {
        val count = dictionary.getOrElse(x, 0)
        dictionary(x) = count + 1
      }
    }
    println(dictionary.mkString(","))
  }

  /**
    * One liner for word count
    * Source.fromFile("myfile.txt").getLines().flatMap(_.split(" ")) gives the Iterator of words
    * .toList converting from iterator to list
    * .groupBy((x) => x) gives the Map[String, List[String]]
    * .mapValues(_.length) map the values (List[String]) to its length
    *
    */
  def countWordsDeclerative() = {
    val words = Source.fromFile("myfile.txt").getLines().flatMap(_.split(" ")).toList.groupBy((x) => x).mapValues(_.length)
    println(words.mkString(", "));
  }
}
