package priv.cxs.study.nlp.maxmatch

import scala.collection.mutable

/**
 * @author cuixiaoshuang
 * @date 2019-11-21
 **/
object MyDict {

  val dict: mutable.Set[String] = new mutable.HashSet[String]()

  {
    dict.add("计算机")
    dict.add("计算机科学")
    dict.add("计算机技术")
    dict.add("科学")
    dict.add("真的")
    dict.add("意思")
    dict.add("有意思")
    dict.add("有点意思")
  }
}
