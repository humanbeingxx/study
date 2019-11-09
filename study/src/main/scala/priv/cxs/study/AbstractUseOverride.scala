package priv.cxs.study

/**
  * @author cuixiaoshuang
  * @date 2019-08-12
  **/
abstract class AbstractUseOverride() {

  val valValue = 1
  val valValueAbs: Int

  var varValue = 1
  var varValueAbs: Int

  def defValue: Int
}

class UseOverride extends AbstractUseOverride {

  //right
  // override val valValue = 2

  // wrong
  // override def valValue = 2

  // wrong
  // override var valValue = 2

  //right
  override val valValueAbs = 2

  // wrong
  // override def valValueAbs = 2

  // wrong
  // override var valValueAbs = 2

  // wrong
  // override val varValue = 2

  // wrong
  // override var varValue = 2

  // wrong
  // override def varValue = 2

  //wrong
  // override val varValueAbs = 2

  // right
  override var varValueAbs = 2

  // wrong
  // override def varValueAbs = 2

  override val defValue: Int = 2

  // right
  //  override var defValue = 2

  // right
  //  override def defValue: Int = 2
}