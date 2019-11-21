package priv.cxs.study.nlp.maxmatch

/**
  * @author cuixiaoshuang
  * @date 2019-11-21
  **/
object MaxPreMatch {

  def cut(origin: String, maxWordLen: Int): List[String] = {
    var segments = List[String]()

    var currentStr = origin

    while (currentStr.length > 0) {
      val slice = getNextMaxSlice(currentStr, maxWordLen)
      val (segment, index) = searchWord(slice)
      segments = segments :+ segment
      currentStr = currentStr.substring(index, currentStr.length)
    }
    segments
  }

  private def getNextMaxSlice(origin: String, maxWordLen: Int): String = {
    if (origin.length < maxWordLen) {
      origin
    } else {
      origin.substring(0, maxWordLen)
    }
  }

  private def searchWord(slice: String): (String, Int) = {
    for (index <- 0 until slice.length) {
      val currentSegment = slice.substring(0, slice.length - index)
      if (MyDict.dict.contains(currentSegment)) {
        return (currentSegment, slice.length - index)
      }
    }
    (slice.substring(0, 1), 1)
  }
}
