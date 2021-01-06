package priv.cxs.study

import scala.collection.mutable.ArrayBuffer

/**
 * @author cuixiaoshuang
 * @date 2019-08-10
 **/
class OuterClass {

  class InnerClass

  val array = new ArrayBuffer[InnerClass]()

  def append(): InnerClass = {
    val inner = new InnerClass
    array += inner
    inner
  }

}
