package com.sip.chapter4

/**
  * Created by RP on 11/30/15.
  */
object MapEx {
  def main(args: Array[String]) {
    gizmosDiscount
  }

  /**
    * Set up a map of prices for a number of gizmos that you covet.
    * Then produce a second map with the same keys and the prices at a 10 percent discount.
    */
  def gizmosDiscount(): Unit = {
    val gizmos = Map(("gizmo1", 20.0), ("gizmo2", 30.0), ("gizmo3", 40.0), ("gizmo4", 50.0), ("gizmo5", 60.0), ("gizmo6", 70.0))
    val newGizmos = gizmos map {case (k, v) => (k, v - (v/10))}
    printf(newGizmos.mkString(","))
  }
}
