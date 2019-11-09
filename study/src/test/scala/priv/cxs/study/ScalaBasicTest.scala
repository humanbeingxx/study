package priv.cxs.study

import scala.collection.immutable.{HashMap, TreeMap}
import scala.collection.{Map, immutable}
import scala.reflect.runtime.universe._
import scala.sys.process._
import scala.util.parsing.combinator.RegexParsers

/**
  * @author cuixiaoshuang
  * @date 2019-08-09
  **/
class ScalaBasicTest extends org.scalatest.FunSuite {

  test("if ok") {
    println("is ok")
  }

  test("test reverse") {
    val map = Map("key1" -> "value", "key2" -> "value", "key3" -> "value", "key4" -> "value")
    val reversed = for ((k, v) <- map) yield (v, k)
    println(reversed)
  }

  test("test TreeMap") {
    var treeMap = TreeMap("key3" -> "value", "key2" -> "value", "key1" -> "value", "key4" -> "value")
    val map = treeMap.mapValues(v => v + "_new")
    println(map)
  }

  test("test inner class") {
    val outer1 = new OuterClass
    val outer2 = new OuterClass

    val inner1 = new outer1.InnerClass
    val inner2 = new outer2.InnerClass

    //    outer1.array += inner2
  }

  test("test apply") {

    //    val test1 = new UseApply("1")
    //    println(test1.value)

    //    val test2 = UseApply("2")

    //    val UseApply(u) = ("test", 1)
    //    println(u.value)
    //    println(u.id)

    //    val UseApply(u1, u2,u3) = "test1 test2 test3"

    check("test1")
    check("test1 test2")
    check("test1 test2 test3")
    check("test1 test2 test3 test4")

    def check(arg: String): Unit = {
      arg match {
        case UseApply(u1) => println("1 names"); println(u1)
        case UseApply(u1, u2) => println("2 names"); println(u1); println(u2)
        case UseApply(u1, u2, u3) => println("3 names"); println(u1); println(u2); println(u3)
        case _ => println("too many names")
      }
    }
  }

  test("test use enum") {
    println(UseEnum.TYPE1.id)
    println(UseEnum.TYPE2.id)
    println(UseEnum.TYPE3.id)

    println(UseEnum.TYPE1.toString)
    println(UseEnum.TYPE2.toString)
    println(UseEnum.TYPE3.toString)

    val type1 = UseEnum.TYPE1
    println(type1.getClass)
    val type1_1 = UseEnum.TYPE1
    assert(type1 == type1_1)
    assert(UseEnum(1) == UseEnum.withName("type1"))
  }

  test("test null instance of") {
    val value: String = null
    assert(!value.isInstanceOf[String])
    assert(!value.isInstanceOf[Unit])
  }

  test("test type match") {
    var value: Any = "abc"
    value match {
      case s: String => println(s.reverse)
      case i: Int => println(i * -1)
    }
    value = 123
    value match {
      case s: String => println(s.reverse)
      case i: Int => println(i * -1)
    }
  }

  test("test override field") {
    val useOverride = new UseOverride()
    println(useOverride.valValue)
  }

  test("test init order") {
    class InitOrder {
      val length: Int = 10
      val array: Array[Int] = new Array[Int](length)
    }

    class SubInitOrder extends InitOrder {
      override val length: Int = 1
    }

    val sub = new SubInitOrder
    println(sub.array.length)
  }

  test("test process control") {
    val result = "ls -h ." #| "grep xml" !!

    result.split("\n").map(v => "=> " + v).foreach(println)
  }

  test("test regex") {
    val data = "18 male 1.8,20 female 1.66,29 male 2.1"

    val re = """([0-9]+)\s+(\w+)\s+([0-9]\.[0-9]+)(,|$)""".r

    for (re(age, gender, height, _) <- re.findAllIn(data)) {
      println("age = " + age)
      println("gender = " + gender)
      println("height = " + height)
    }
  }

  test("test \\b") {
    val word = """\b([\w.]+?)\b""".r
    for (word(w) <- word.findAllIn("123.123 123.123")) {
      println(w)
    }
  }

  test("test multi trait") {
    trait Logged {
      def log(msg: String): Unit = {}
    }

    trait ConsoleLogged extends Logged {
      override def log(msg: String): Unit = {
        println(msg)
      }
    }

    trait TimeLogged extends Logged {
      override def log(msg: String): Unit = {
        super.log(msg + " @" + System.currentTimeMillis())
      }
    }

    trait ShortLogged extends Logged {
      override def log(msg: String): Unit = {
        super.log(msg.substring(0, 10))
      }
    }

    (new Object with ConsoleLogged with TimeLogged with ShortLogged).log("this is a test")
    (new Object with ConsoleLogged with ShortLogged with TimeLogged).log("this is a test")

  }

  test("test init trait field, bad case") {

    trait WithField {
      def field: String

      println(field.reverse)
    }

    class MyObjectWithField extends WithField {
      override val field: String = "use val"
    }

    class MyObjectWithDef extends WithField {
      override def field: String = "use def"
    }

    //    new MyObjectWithField
    //    new MyObjectWithDef

    new {
      val field = "pre define"
    } with WithField {
      //      val field = "abc"
    }

    trait WithLazyField {
      val field: String
      lazy val reversed: String = field.reverse
    }

    val o = new {} with WithLazyField {
      override val field: String = "lazy"
    }
    println(o.reversed)
  }

  test("test operators") {
    val i = 10.unary_-
    println(i)

    val x = -10 + 10 toString

    val y = -10 + 10.toString

    println(x)
    println(y)
  }

  test("test : ") {
    val A = List(1, 2, 3)
    val B = List(4, 5, 6)
    val AmmB = A :: B
    println(AmmB)
    println(AmmB.eq(A) + "," + AmmB.eq(B))

    val AmpB = A :+ B
    println(AmpB)
    println(AmpB.eq(A) + "," + AmpB.eq(B))

    val ApmB = A +: B
    println(ApmB)
    println(ApmB.eq(A) + "," + ApmB.eq(B))

    val AmmmB = A ::: B
    println(AmmmB)
    println(AmmmB.eq(A) + "," + AmmmB.eq(B))

    println("A" :: "B" :: Nil)

    println("A" +: "B" :: Nil)
    println(("A" +: "B") :: Nil)
    println("A" +: ("B" :: Nil))
    println(Nil.::("A" +: "B"))
    println((Nil.::("B")).+:("A"))
  }

  test("test >:") {
    class MyClass(val name: String) {

      def +(b: MyClass): MyClass = {
        new MyClass(this.name + ":" + b.name)
      }

      def +:(b: MyClass): MyClass = {
        new MyClass(this.name + ":" + b.name)
      }
    }

    println((new MyClass("a") + new MyClass("b")).name)
    println((new MyClass("a") +: new MyClass("b")).name)
  }


  test("test indexOf") {
    def until(condition: => Boolean)(block: => Unit): Unit = {
      if (!condition) {
        block
        until(condition)(block)
      }
    }

    def indexOf(str: String, c: Char): Int = {
      var i = 0
      until(i == str.length) {
        if (str(i) == c) return i
        i += 1
      }
      println(i)
      i
    }

    println(indexOf("abc", 'b'))
  }

  test("test diff set") {
    val a = Set(1, 2, 3, 4)
    val b = Set(3, 4, 5, 6)

    println(a -- b)
    println(b -- a)
  }

  test("test ++ ++:") {
    println((Array(1, 2, 3) ++ Set(4, 5, 6)).getClass)
    println((Array(1, 2, 3) ++: Set(4, 5, 6)).getClass)
  }

  test("test collect") {
    "abcdefg".collect { case 'a' => 1; case 'g' => 9 }.foreach(println)
  }

  test("test pattern ::") {
    val pattern: List[Int] => Int = {
      case scala.::(x, scala.::(y, z)) => y
      //      case x :: y :: z => y
      case _ => 0
    }

    println(pattern(List(1, 2, 3, 4)))
    println(pattern(List(1, 2, 3)))
    println(pattern(List(1, 2)))
  }

  test("test zip") {
    println(List(1, 2, 3).zipAll(List(-1, -2), -99, 99))
    println(List(1, 2).zipAll(List(-1, -2, -3), -99, 99))
    println(List('c', 'b', 'a').zipWithIndex.max)
  }

  test("test view") {
    val powers = (0 until 10).view.map { i =>
      println(i); scala.math.pow(10, i)
    }

    println(powers.getClass)
    println(powers(3))
  }

  test("test par") {
    List(1, 2, 3, 4, 5, 6, 7, 8, 9).par.foreach(println)
    val ints = for (i <- (0 to 100).par) yield -i
    ints.foreach(println)
  }

  test("test case class") {
    abstract class Amount
    case class Dollar(value: Double) extends Amount
    case class Currency(value: Double, unit: String) extends Amount

    val dollar: Amount = Dollar(1.0)
    val currency: Amount = Currency(100.0, "cent")

    dollar match {
      case Dollar(v) => println("dollar = " + v)
      case Currency(v, u) => println(u + " = " + v)
      case _ => "unknown"
    }

    currency match {
      case Dollar(v) => println("dollar = " + v)
      case Currency(v, u) => println(u + " = " + v)
      case _ => "unknown"
    }

    val ints = List(1, 2, 3, 4, 5)

    ints match {
      case a :: b :: c => println(a); println(b); println(c)
      case _ => println()
    }
  }

  test("test match with @") {
    sealed abstract class SuperClass
    case class SubClass1(v1: String) extends SuperClass
    case class SubClass2(v1: String, v2: String, sub1: SubClass1*) extends SuperClass

    val sc2 = SubClass2("v2.1", "v2.2", SubClass1("name1.1"), SubClass1("name1.2"), SubClass1("name1.3"), SubClass1("name1.4"))
    sc2 match {
      case SubClass2(_, _, SubClass1(name), _, rest@_*) => println(name); println(rest)
    }
  }

  test("test manifest") {
    def mani[T: Manifest](first: T, second: T): Unit = {
      val array = new Array[T](2)
      array(0) = first
      array(1) = second
      println(array.mkString(","))
    }

    mani(1, 2)
  }

  test("test generic lower upper") {
    class Pair[T <: Comparable[T]](val first: T, val second: T) {
      def bigger: T = if (first.compareTo(second) >= 0) first else second
    }

    new Pair("a", "b")

    class Pair2[T](val first: T, val second: T) {
      def replaceFirst[R >: T](newFirst: R): Pair2[R] = new Pair2[R](newFirst, second)
    }

    new Pair2(List(1), List(2)).replaceFirst(Seq(3))
  }

  test("test view bounday, deprecated") {
    class Pair[T](val first: T, val second: T)(implicit cmp: T => Ordered[T]) {
      def bigger: T = if (first >= second) first else second

      def smaller(implicit ordered: Ordering[T]): T =
        if (ordered.compare(first, second) < 0) first else second
    }

    new Pair(1, 2).bigger
    new Pair(1, 2).smaller
    new Pair("1", "2").bigger
    new Pair("1", "2").smaller

    println(new Pair(new Pair(1, 2), new Pair(3, 4)).bigger.first)
    println(new Pair(new Pair(1, 2), new Pair(3, 4)).smaller.first)

    implicit def conv(p: Pair[Int]): Ordered[Pair[Int]] = new Ordered[Pair[Int]] {
      override def compare(that: Pair[Int]): Int = p.first.compareTo(that.first)
    }

    class Pair2[T: Ordering](val first: T, val second: T) {
      def bigger(implicit ordering: Ordering[T]): T =
        if (ordering.compare(first, second) >= 0) first else second

      def smaller(implicit ordered: Ordering[T]): T =
        if (ordered.compare(first, second) < 0) first else second
    }

    implicit def conv2(p: Pair2[Int]): Ordered[Pair2[Int]] = new Ordered[Pair2[Int]] {
      override def compare(that: Pair2[Int]): Int = p.first.compareTo(that.first)
    }

    println(new Pair2(new Pair2(1, 2), new Pair2(3, 4)).bigger.first)
    println(new Pair2(new Pair2(1, 2), new Pair2(3, 4)).smaller.first)
  }

  test("test covariant") {
    class Person(val name: String = "")
    class Male(override val name: String = "") extends Person

    class Pair1[-T](t: T*)
    class Pair2[+T](t: T*)

    def name1(m: Pair1[Male]): Unit = {

    }

    def name2(m: Pair2[Person]): Unit = {

    }

    val pair1 = new Pair1(new Person("a"))
    val pair2 = new Pair2(new Male("a"))
    name1(pair1)
    name2(pair2)

    class Pair3[T](val first: T, val second: T) {
      def replaceFirst(newFirst: T) = new Pair3[T](newFirst, second)
    }
  }

  test("test covariant +") {
    class Base
    class Sub extends Base
    class SubSub extends Sub

    class MyList[+T](v: T*) {
      def add[U >: T](v: U): Unit = {}
    }

    val listBase: List[Base] = List(new Base, new Base)
    val listSub: List[Base] = List(new Sub, new Sub)

    def show(v: List[Base]): Unit = {
      v.foreach(println)
    }

    def showMine(v: MyList[Base]): Unit = {
      println(v)
    }

    show(listBase)
    show(listSub)

    val mylistBase: MyList[Base] = new MyList(new Base, new Base)
    val mylistSub: MyList[Sub] = new MyList(new Sub, new Sub)

    showMine(mylistBase)
    showMine(mylistSub)
  }

  test("test List add with >:") {
    class Base
    class Sub extends Base
    class SubSub extends Sub

    def trans[T >: Sub](l: List[T]): List[T] = l

    val list1: List[Base] = trans(List(new Base, new Base))
    val list2: List[Base] = trans(List(new Sub, new Sub))
    val list3: List[Any] = trans(List(1, 2))
  }

  test("test covariant -") {
    class Base
    class Sub extends Base

    class MyList[-T](v: T*) {
      def add(t: T): Unit = {
        println(t)
      }
    }

    val bl = new MyList(new Base, new Base)
    val sl = new MyList(new Sub, new Sub)

    def add(myList: MyList[Sub], v: Sub): Unit = {
      myList.add(v)
    }

    add(sl, new Sub)
    add(bl, new Sub)
  }

  test("test covariant of function1") {
    class Person
    class Male extends Person
    class Female extends Person

    class Friend[T]

    def friends(males: Array[Male], find: Function1[Male, Female]): Array[Female] = {
      for (m <- males) yield find(m)
    }

    def operate(p: Person): Female = {
      new Female()
    }

    friends(Array(new Male(), new Male()), operate)
  }

  test("test expr parser") {
    class ExprParser extends RegexParsers {
      private val number = "[0-9]+".r

      def expr: Parser[Any] = term ~ opt(("+" | "-") ~ expr)

      def term: Parser[Any] = factor ~ rep("*" ~ factor)

      def factor: Parser[Any] = number | "(" ~ expr ~ ")"
    }

    val parser = new ExprParser
    val result = parser.parseAll(parser.expr, "1+2+3*4")
    if (!result.isEmpty) println(result.get)
  }

  test("test singleton type") {
    println(RichFile.getClass)
    println(typeOf[RichFile])
    println(typeOf[RichFile.type])

    val f1 = new RichFile
    val f2 = new RichFile

    println(typeOf[f1.type])
    println(typeOf[f2.type])

    val f1Type: f1.type = f1
    val f2Type: f2.type = f2

    println(f1Type)
    println(f2Type)

    println(typeOf[f1.type] == typeOf[RichFile])
    println(typeOf[f1.type] == typeOf[f2.type])

    class Base {
      def func1: this.type = this
    }

    class Extend extends Base {
      def func2: Extend = this
    }

    val extend = new Extend
    extend.func1.func2
  }

  test("test structure type") {
    class Base(val value: Int = 0)

    val l = new Array[Base {def show(): Unit}](3)

    l(0) = new Base(1) {
      def show(): Unit = println(value)
    }

    l(1) = new Base(2) {
      def show(): Unit = println(value)
    }

    l(2) = new Base(3) {
      def show(): Unit = println(value)
    }

    l.foreach(e => e.show())
  }

  test("test boundary and implicit") {
    class Element(val value: Int)

    class Pair[T: Ordering](val first: T, val second: T) {
      def bigger(implicit ordering: Ordering[T]): T = {
        if (ordering.compare(first, second) >= 0) first else second
      }
    }

    println(new Pair(1, 2).bigger)
    println(new Pair("1", "2").bigger)

    implicit object ElementOrdering extends Ordering[Element] {
      override def compare(x: Element, y: Element): Int = x.value.compareTo(y.value)
    }

    val elementPair = new Pair(new Element(1), new Element(2))
    println(elementPair.bigger.value)
  }

  test("test List match") {
    val list = List(0, 1)
    val result = list match {
      case List(0) => "0"
      //      case List(0, 1) => "0, 1"
      case 0 :: 1 :: Nil => "0, 1, Nil"
      case List(0, _*) => "0 ..."
      case 0 :: tail => "0 and " + tail.mkString(",")
      case _ => "else"
    }
    println(result)
  }

  test("test flatmap") {
    val list = List(List(1, 2, 3), List(4, 5, 6))
    println(list.flatMap(l => l.iterator))
    println(list.flatMap(l => for (e <- l) yield -1 * e))
  }

  test("test <- option") {
    val option = Option.apply("123")
    for (v <- option) println(v)
  }

  test("test use implicit for overload") {
    implicit object StringType
    implicit object IntType

    class My {
      def show(l: List[String])(implicit s: StringType.type): Unit = {
        l.foreach(println)
      }

      def show(l: List[Int])(implicit i: IntType.type): Unit = {
        l.foreach(e => println("%05d".format(e)))
      }
    }

    (new My).show(List(1, 2, 3))
    (new My).show(List("1", "2", "3"))
  }

  test("test my json template") {
    import util.parsing.json._

    object MyInterpolators {

      implicit class myJsonContext(val s: StringContext) {
        def json(any: Any*): JSONObject = {
          JSONObject(immutable.Map("test" -> ""))
        }
      }

    }

    import MyInterpolators._

    val name = "Tank"
    val age = 22

    val jsonObject = json"name:$name, age:$age"
    println(jsonObject)

  }

  test("test add encrypt to String") {
    implicit class StringEncrypt(val s: String) {
      println("create StringEncrypt")

      def encrypt(): String = {
        val zip = (for (i <- 0 until s.length if i % 2 == 0) yield s(i))
          .zipAll(
            for (i <- 0 until s.length if i % 2 == 1) yield s(i), "", ""
          )
        zip.flatMap(e => Seq(e._2, e._1)).mkString
      }
    }

    println("abcde".encrypt())
  }

  test("test curried function") {
    def curry(v1: String, v2: String, v3: String): Unit = {
      println(v1 + v2 + v3)
    }

    val curried = (curry _).curried
    val curriedA = curried("A")
    val curriedAB = curried("A")("B")

    curried("a")("b")("c")
    curriedA("b")("c")
    curriedAB("c")
  }

  test("test partial function lift") {
    val func: PartialFunction[String, String] = {
      case "duang" => "bingo"
    }

    val lift:String => Option[String] = func.lift

    val maybeString = lift.apply("dang")

    println(maybeString.isDefined)

    val opt:String => Option[String] = (s:String) => {
      if (s == "dang") {
        Some("bingo")
      } else {
        None
      }
    }

    println(opt.apply("duang").isDefined)

    val unlift = scala.Function.unlift(opt)

    println(unlift.apply("dang"))
  }

  test("test execute external command") {
    import sys.process._

    val hdfs = "hdfs dfs -du -h /users/datahouse"!!

    val split = hdfs.split("\n")

    println(split.size)

    split.foreach(e => {
      val strings = e.split("\\s+")

      val unit = strings(1)
      val amount = strings(0)

      if (unit != "G" || amount.toDouble > 5) {
        println("invalid data : " + e)
      }
    })
  }

  test("test for two iter") {
    val arr1 = Array(1,2,3)
    val arr2 = Array('a','b','c')

    val tuples = for (k <- arr2; v <- arr1) yield (k, v)
    tuples.foreach(println)
  }
}
