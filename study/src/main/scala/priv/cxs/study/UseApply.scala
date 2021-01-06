package priv.cxs.study

/**
 * @author cuixiaoshuang
 * @date 2019-08-12
 **/
class UseApply private(var value: String = "", var id: Int = 0) {

}

object UseApply {
  var name: String = ""
  var age: Int = 0

  def apply(value: String): UseApply = {
    new UseApply(value)
  }

  def unapplySeq(arg: String): Option[Seq[UseApply]] = {
    Option.apply(for (s <- arg.split(" ")) yield UseApply(s))
  }
}
