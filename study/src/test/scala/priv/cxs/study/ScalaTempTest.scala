package priv.cxs.study

import scala.collection.generic.CanBuildFrom
import scala.collection.immutable.List
import scala.collection.mutable

/**
 * @author cuixiaoshuang
 * @date 2019-09-29
 **/
class ScalaTempTest extends org.scalatest.FunSuite {

  test("debug List map") {
    implicit val myBuilder: CanBuildFrom[List[String], Int, String] = new CanBuildFrom[List[String], Int, String] {
      val builder: mutable.Builder[Int, String] = {
        new mutable.Builder[Int, String] {
          var res = ""

          override def +=(elem: Int): this.type = {
            res += elem + ","
            this
          }

          override def clear(): Unit = {}

          override def result(): String = {
            res
          }
        }
      }

      override def apply(from: List[String]): mutable.Builder[Int, String] = builder

      override def apply(): mutable.Builder[Int, String] = builder
    }

    val ints = List("1", "2")
      .map(x => x.length)

    println(ints)
  }
}
