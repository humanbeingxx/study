package priv.cxs.study

/**
  * @author cuixiaoshuang
  * @date 2019-10-10
  **/
class ScalaAlgorithm extends org.scalatest.FunSuite {

  def bubbleSort[T](values: Array[T])(implicit ord: Ordering[T]): Unit = {
    for (i <- 0 until values.length - 1) {
      for (j <- 0 until values.length - 1 - i) {
        if (ord.compare(values(j), values(j + 1)) > 0) {
          val tmp = values(j)
          values(j) = values(j + 1)
          values(j + 1) = tmp
        }
      }
    }

    println(values.mkString(","))
  }

  test("test bubbleSort") {
    bubbleSort(Array(3, 1, 5, 7, 9, 2, 4, 6, 8))
    bubbleSort(Array(1))
    bubbleSort(Array(2, 1))
  }

  def quickSort[T](values: List[T])(implicit ord: Ordering[T]): List[T] = {

    values match {
      case Nil => Nil
      case List() => List()
      case head :: tail => {
        val (left, _ :: right) = values.partition(ord.compare(_, head) < 0)
        quickSort(left) ++ (head :: quickSort(right))
      }
    }
  }

  test("test quickSort") {
    println(quickSort(List(5, 3, 1, 2, 4, 6)))
  }
}
