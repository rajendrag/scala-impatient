import math._
import BigInt.probablePrime
import scala.util.Random

object chapter1 {

  val x = "crazy"*3
  //x: String = crazycrazycrazy

  val three:Double = 3;
  println(three - pow(sqrt(3), 2))

  10 max 2

  BigInt(2) pow 1024

  probablePrime(100, Random)

  probablePrime(100, Random).toString(36)

  val s = "String"
  s.head
  s(0)
  s.last
  s(s.length - 1)

  s.take(2)

  s.drop(2)

  s.takeRight(2)

  s.dropRight(2)
}


