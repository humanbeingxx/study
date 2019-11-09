package priv.cxs.study

/**
  * @author cuixiaoshuang
  * @date 2019-08-26
  **/
class RichFile {

}

object RichFile {
  def unapplySeq(path:String):Option[Seq[String]] = {
    Option.apply(path.split("/").filter(s => s != ""))
  }
}