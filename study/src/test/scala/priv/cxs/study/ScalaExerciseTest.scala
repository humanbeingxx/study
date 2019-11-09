package priv.cxs.study

import java.io.File

import scala.collection.mutable
import scala.io.Source

/**
  * @author cuixiaoshuang
  * @date 2019-08-30
  **/
class ScalaExerciseTest extends org.scalatest.FunSuite {

  test("exercise 1, Hello multiplication") {
    var m: Long = 1
    "Hello".foreach(c => {
      m *= c.toLong
    })
    println(m)
  }

  test("exercise 2, test xn") {
    assert(xn(2, 10) == 1024)
    assert(xn(2, 1) == 2)
    assert(xn(2, 0) == 1)
  }

  def xn(x: Int, n: Int): Long = {
    if (n == 0) {
      1
    } else {
      xnRec(x, n, x)
    }
  }

  def xnRec(x: Int, n: Int, current: Long): Long = {
    if (n == 1) {
      current
    } else if (n / 2 == 0) {
      xnRec(x, n / 2, current * current)
    } else {
      xnRec(x, n - 1, current * x)
    }
  }

  test("exercise 3, Separate elements") {
    val array = Array(1, 2, 3, 0, -1, -5, -3, 0, 2, 3)

    val newArray = array.filter(_ > 0) ++ array.filter(_ <= 0)

    println(newArray.mkString(","))
  }

  test("exercise 4, Exchange position") {
    val array = Array(1, 2, 3, 4)
    val newArray = for (i <- array.indices)
      yield if (i % 2 == 0 && i == array.length - 1) array(i) else if (i % 2 == 0) array(i + 1) else array(i - 1)
    println(newArray.mkString(","))
  }

  test("exercise5, find max & min") {
    val array = Array(1, 2, 3, 4, 5)
    println((array.max, array.min))
  }

  test("exercise6, main construct") {
    class TestMainConstruct(var age: Int) {
      if (age < 0) {
        age = 0
      }


      override def toString = s"TestMainConstruct($age)"
    }

    println(new TestMainConstruct(-1))
  }

  test("exercise7, RGB corners") {
    object RGB extends Enumeration {
      val BLACK = Value(0x000000)
      val YELLOW = Value(0x0000ff)
      // 青色
      val CYAN = Value(0x110000)
      // 品红
      val FUCHSIN = Value(0x001100)
      val BLUE = Value(0xffff00)
      val GREEN = Value(0xff00ff)
      val RED = Value(0x00ffff)
      val WHITE = Value(0xffffff)
    }
  }

  test("exercise8, find class num") {
    val target = new File("target/classes")

    def folds(file: File): Iterator[File] = {
      val childrenDir = file.listFiles.filter(_.isDirectory)
      childrenDir.toIterator ++ childrenDir.toIterator.flatMap(folds)
    }

    val files = folds(target)

    files.flatMap(f => {
      f.listFiles.filter(_.isFile)
    }).filter(_.getName.endsWith(".class")).foreach(println)
  }

  test("exercise9, find over 12") {
    Source.fromFile("/Users/cxs/temp/test_file").getLines().filter(_.length > 5).foreach(println)
  }

  test("exercise10, find non-fload") {
    val word = """\b([\w.]+)\b""".r
    val float = """^\d+\.\d+$""".r
    Source.fromFile("/Users/cxs/temp/test_file").getLines().foreach(l => {
      for (word(w) <- word.findAllIn(l)) {
        print(w)
        if (float.findFirstIn(w).isEmpty) {
          println("(is not float)")
        } else {
          println("(is float)")
        }
      }
    })
  }

  test("exercise11, my money") {
    class MyMoney(val dollar: Int, val cent: Int) {
      def +(other: MyMoney): MyMoney = {
        var dollar = this.dollar + other.dollar
        var cent = this.cent + other.cent
        if (cent >= 100) {
          cent = cent % 100
          dollar += 1
        }
        new MyMoney(dollar, cent)
      }

      def -(other: MyMoney): MyMoney = {
        val sub = this.dollar * 100 + this.cent - other.dollar * 100 - other.cent
        new MyMoney(sub / 100, sub % 100)
      }

      override def toString = s"MyMoney($dollar, $cent)"

      def canEqual(other: Any): Boolean = other.isInstanceOf[MyMoney]

      override def equals(other: Any): Boolean = other match {
        case that: MyMoney =>
          (that canEqual this) &&
            dollar == that.dollar &&
            cent == that.cent
        case _ => false
      }

      override def hashCode(): Int = {
        val state = Seq(dollar, cent)
        state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
      }
    }

    val money1 = new MyMoney(1, 10)
    val money2 = new MyMoney(2, 30)

    println(money1)
    println(money2)
    println(money1 + money2)
    println(money1 - money2)
    println(money2 - money1)
    println(money1 == money1)
    println(money1 == money2)
    println(money1 == new MyMoney(1, 10))
  }

  test("exercise12, create html table") {
    class MyTable {
      val skeletonBefore = "<html><table><tr>"
      val skeletonAfter = "</tr></table></html>"

      var content = ""

      def build(): String = {
        skeletonBefore + content + skeletonAfter
      }

      def |(data: String): MyTable = {
        content += "<td>" + data + "</td>"
        this
      }

      def ||(data: String): MyTable = {
        content += "</tr><tr><td>" + data + "</td>"
        this
      }
    }

    val table = new MyTable | "data1.1" || "data2.1" | "data2.2" || "data3.1"
    println(table.build())
  }

  test("exercise13, BigSequence") {
    class BigSequence(var value: Long) {

      def apply(pos: Int): Long = {
        if (pos > 64) {
          0
        } else {
          value & (0x00000001 << pos)
        }
      }

      def update(pos: Int, setValue: Boolean): Unit = {
        if (setValue) {
          value = value | (0x00000001 << pos)
        } else {
          value = value & (0xFFFFFFFE << pos)
        }
      }
    }

    val sequence = new BigSequence(0xFFFFFFFF)

    printLong(sequence(1))
    printLong(sequence(2))
    printLong(sequence(3))
    printLong(sequence(4))

    def printLong(l: Long): Unit = {
      for (i <- (0L to 63L).reverse) {
        if ((l & (1 << i)) == (1 << i)) {
          print("1")
        } else {
          print("0")
        }
      }
      println()
    }
  }

  test("exercise14, RichFile unapplySeq") {
    val path = "/home/cxs/test.txt"

    path match {
      case RichFile(u1) => println("1 names"); println(u1)
      case RichFile(u1, u2) => println("2 names"); println(u1); println(u2)
      case RichFile(u1, u2, u3) => println("3 names"); println(u1); println(u2); println(u3)
      case RichFile(u1, u2, u3, u4) => println("4 names"); println(u1); println(u2); println(u3); println(u4)
      case _ => println("too many names")
    }
  }

  test("exercise15, values") {
    def values(func: Int => Int, low: Int, high: Int): Seq[(Int, Int)] = {
      for (i <- low to high) yield (i, func(i))
    }

    println(values(x => x * x, -5, 5))
  }

  test("exercise16, leftReduce max") {
    val ints = Array(5, 43, 3, 2, 1)
    println(ints.reduceLeft((a, b) => if (a >= b) a else b))
    println(ints.reduceLeft(_ max _))
  }

  test("exercise17, factorial") {
    def fact(n: Int): Long = {
      if (n < 1) 0 else (1 to n).reduceLeft(_ * _)
    }

    println(fact(4))
    println(fact(0))

    def fact2(n: Int): Long = {
      (1 to n).foldLeft(1)(_ * _)
    }

    println(fact2(4))
    println(fact2(0))
  }

  test("exercise17, adjustToPair") {
    def adjustToPair(func: (Int, Int) => Int): ((Int, Int)) => Int = {
      p: (Int, Int) => func(p._1, p._2)
    }

    println(adjustToPair(_ + _)((1, 2)))
    println(adjustToPair(_ / _)((4, 2)))

    Array((1, 2), (3, 4), (5, 6)).map(adjustToPair(_ * _)(_)).foreach(println)
  }

  test("exercise18, corresponds") {
    val strs = Array("a", "abc", "abcde", "abcdefg")
    val ints = Array(1, 3, 5, 7)
    println(strs.corresponds(ints)(_.length == _))

    val ints2 = Array(1, 3, 5, 7, 9)
    println(strs.corresponds(ints2)(_.length == _))

    val strs2 = Array("a", "abc", "abcde")
    println(strs2.corresponds(ints)(_.length == _))
  }

  test("exercise19, count char") {
    def count(str: String): collection.mutable.Map[Char, List[Int]] = {
      val map = str.zipWithIndex.groupBy(_._1).mapValues(seq => seq.map(_._2).toList.sortWith((a, b) => a >= b))
      collection.mutable.Map(map.toSeq: _*)
    }

    val charToList = count("aabbccdd")
    println(charToList)
  }

  test("exercise20, kick 0") {
    val list1 = mutable.LinkedList(1, 0, 0, 2, 3, 4, 0, 0, 5)
    val list2 = mutable.LinkedList(1, 0)
    val list3 = mutable.LinkedList(1)
    //BUG
    val list4 = mutable.LinkedList(0)
    val list5 = new mutable.LinkedList[Int]

    def kick0(list: mutable.LinkedList[Int]) = {
      var cur = list
      while (cur != Nil && cur.next != Nil) {
        if (cur.next.elem == 0) {
          cur.next = cur.next.next
        } else {
          cur = cur.next
        }
      }
    }

    kick0(list1)
    println(list1)

    kick0(list2)
    println(list2)

    kick0(list3)
    println(list3)

    kick0(list4)
    println(list4)

    kick0(list5)
    println(list5)
  }

  test("exercise21, flatMap names") {
    val names = Array("Fred", "Tom", "Harry")
    val mapping = Map("Tom" -> 1, "Harry" -> 2, "Jack" -> 3)

    val ints = names.map(mapping.get).filter(_.isDefined).map(_.get)
    println(ints.mkString(","))
  }

  test("exercise22, implement mkStr") {
    def mkStr(sep: String, seq: Seq[Int]): String = {
      seq.map(_.toString).reduceLeft(_ + sep + _)
    }

    println(mkStr("#", Array(1, 2, 3)))
  }

  test("exercise23, test :\\ /:") {
    val ints = List(1, 2, 3, 4, 5)

    val list = ints.foldLeft(List[Int]())((a, b) => b :: a)

    println(list)
  }

  test("exercise24, zip and tupled") {
    val a = Array(1, 2, 3, 4)
    val b = Array(-1, -2, -3, -4)

    val plus: (Int, Int) => Int = _ + _

    (a zip b).map(plus.tupled).foreach(println)
  }

  test("exercise25, split int array") {
    def split(arr: Array[Int], colNum: Int): Array[Array[Int]] = {
      arr.grouped(colNum).toArray
    }

    val array = split(Array(1, 2, 3, 4, 5, 6), 3)

    array.foreach(e => println(e.mkString(",")))
  }

  test("exercise26, some kind of B tree") {
    val tree = List(List(1, 2), 3, List(4))

    def sum(tree: List[Any], result: Int = 0): Int = {
      tree match {
        case List(i: Int) => result + i
        case List(l: List[Any]) => sum(l, result)
        case List(i: Int, res@_*) => sum(res.toList, result + i)
        case List(l: List[Any], res@_*) => sum(res.toList, result + sum(l))
      }
    }

    println(sum(tree))
  }

  test("exercise27, another style of tree") {
    sealed abstract class Tree
    case class Leaf(value: Int) extends Tree
    case class Node(sub: Tree*) extends Tree

    def sumTree(tree: Tree, result: Int = 0): Int = {
      tree match {
        case leaf: Leaf => result + leaf.value
        case Node(leaf: Leaf, left@_*) => result + leaf.value + left.map(sumTree(_, result)).sum
        case Node(node: Node, left@_*) => sumTree(node, result) + left.map(sumTree(_, result)).sum
      }
    }

    println(sumTree(Node(Node(Leaf(1), Leaf(2)), Leaf(3), Node(Leaf(4)))))
    println(sumTree(Node(Leaf(1), Leaf(2), Leaf(3))))
  }

  test("exercise28, compose") {
    def A(value: Double) = if (value >= 0) Some(math.sqrt(value)) else None

    def B(value: Double) = if (value != 1) Some(1 / (value - 1)) else None

    def compose(f1: Double => Option[Double], f2: Double => Option[Double]): Double => Option[Double] = {
      d => {
        val f2Res = f2(d)
        if (f2Res.isEmpty) None else f1(f2Res.get)
      }
    }

    val C = compose(A, B)

    println(C(0))
    println(C(1))
    println(C(2))
  }

  test("exercise29, swap Pair") {
    class Pair1[S, T](val left: S, val right: T) {
      def swap(): Pair1[T, S] = {
        new Pair1(right, left)
      }
    }

    println(new Pair1(1, "a").swap().left)

    class Pair2[T](var left: T, var right: T) {
      def swap(): Unit = {
        val temp = left
        left = right
        right = temp
      }
    }

    val pair2 = new Pair2("a", "b")
    pair2.swap()
    println(pair2.left)
  }

  test("exercise30, swap function") {
    class Pair[S, T](val left: S, val right: T)

    def swap[S, T](pair: Pair[S, T]): Pair[T, S] = {
      new Pair(pair.right, pair.left)
    }

    println(swap(new Pair(1, "a")).left)
  }

  test("exercise31, find middle") {
    def middle[T](iter: Iterable[T]): T = {
      val list = iter.toList
      list(list.size / 2)
    }

    println(middle(Array(1, 2, 3, 4, 5, 6)))
  }

  test("exercise32, test List covariant") {
    class Person
    class Female extends Person

    def takeFirst(list: List[Person]): Female = {
      list.head match {
        case l: Female => l
        case _ => null
      }
    }

    takeFirst(List(new Female(), new Female()))
  }

  test("exercise33, mutable Pair") {
    class Pair[S, T](var first: S, var second: T) {
      def swap()(implicit ev: S =:= T): Unit = {
        val temp = first
        first = second.asInstanceOf[S]
        second = temp
      }
    }

    val p1 = new Pair("a", "b")
    val p2 = new Pair("a", 2)

    p1.swap()
    println(p1.second)

    //    p2.swap()
  }

  test("exercise34, Bug moving") {
    class Bug {
      private var direction = 1
      private var location = 0

      def move(pace: Int): this.type = {
        location += direction * pace
        this
      }

      def turn(): this.type = {
        direction *= -1
        this
      }

      def show(): this.type = {
        println(location)
        this
      }
    }

    val bug = new Bug
    bug.move(1).move(2).move(3).show().turn().move(4).show()
  }

  test("exercise35, find Number") {
    def search(array: Array[Int], value: Int): Int Either Int = {
      var low = 0
      var high = array.length - 1
      var mid = (low + high) / 2
      var found = false

      while (low <= high && !found) {
        mid = (low + high) / 2
        if (array(mid) == value) {
          found = true
        } else if (array(mid) > value) {
          high = mid - 1
        } else {
          low = mid + 1
        }
      }
      Either.cond(found, mid, mid)
    }

    println(search(Array(1, 2, 3, 4, 5, 6, 7, 8, 9), 5))
    println(search(Array(1, 2, 3, 4, 60, 70, 80, 90), 5))
  }

  test("exercise36, closable") {
    def closeQuiet(obj: {def close(): Unit; def operate(): Unit}): Unit = {
      try {
        obj.operate()
      } finally {
        obj.close()
      }
    }

    class Base

    closeQuiet(new Base {
      def operate(): Unit = {
        println("operating")
      }

      def close(): Unit = {
        println("closing")
      }
    })
  }

  test("exercise37, printValues") {
    def printValues(f: Int => Int, from: Int, to: Int): Unit = {
      for (i <- from to to) {
        println(f(i))
      }
    }

    printValues(x => x * x, 1, 10)
  }

  test("exercise38, principe of -> ") {
    val pair = "a" -> 1
  }
}

