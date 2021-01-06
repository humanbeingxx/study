package priv.cxs.study

import scala.math._

/**
 * @author cuixiaoshuang
 * @date 2019-08-09
 **/
object ScalaBasic {

  def main(args: Array[String]): Unit = {
    val num = {
      1 + 2 + 3 + 4
    }

    println(num)

    for (i <- 1 to 3; j <- 1 to 4) {
      println("i = " + i + ", j = " + j)
    }

    val x = 1

    val result: Double = {
      if (x >= 0) {
        sqrt(1)
      } else {
        throw new IllegalArgumentException("x should not be negtive")
      }
    }

    countDown(10)
  }

  def countDown(n: Int): Unit = {
    var i = n
    while (i >= 0) {
      println(i)
      i -= 1
    }
  }
}
