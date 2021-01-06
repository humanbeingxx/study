package priv.cxs.study

import scala.collection.mutable

/**
 * @author cuixiaoshuang
 * @date 2019-08-09
 **/
class ScalaOtherTest extends org.scalatest.FunSuite {

  test("test map zip") {
    val map1 = Map("key1" -> ("value1.1", "value1,2"), "key2" -> ("value2.1", "value2,2"))
    val map2 = Map("key1" -> ("value1.3", "value1,4"), "key3" -> ("value3.1", "value3,2"))
    val zip = map1.zip(map2)
    println(zip)

    val join: mutable.HashMap[String, (String, String, String, String)] = mutable.HashMap()

    for (key <- map1.keySet ++ map2.keySet) {
      if (map1.contains(key) && map2.contains(key)) {
        join.put(key, (map1(key)._1, map1(key)._2, map2(key)._1, map2(key)._2))
      } else if (map1.contains(key)) {
        join.put(key, (map1(key)._1, map1(key)._2, "", ""))
      } else {
        join.put(key, ("", "", map2(key)._1, map2(key)._2))
      }
    }
    println(join)
  }
}
