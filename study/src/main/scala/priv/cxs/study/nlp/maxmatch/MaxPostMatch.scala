package priv.cxs.study.nlp.maxmatch

/**
 * @author cuixiaoshuang
 * @date 2019-11-21
 **/
object MaxPostMatch {

  def cut(origin: String, maxWordLen: Int): List[String] = {
    var segments = List[String]()

    var currentStr = origin

    while (currentStr.length > 0) {
      val slice = getNextMaxSlice(currentStr, maxWordLen)
      val (segment, index) = searchWord(slice)
      segments = segment :: segments
      currentStr = currentStr.substring(0, currentStr.length - index)
    }
    segments
  }

  private def getNextMaxSlice(origin: String, maxWordLen: Int): String = {
    if (origin.length < maxWordLen) {
      origin
    } else {
      origin.substring(origin.length - maxWordLen, origin.length)
    }
  }

  private def searchWord(slice: String): (String, Int) = {
    for (index <- 0 until slice.length) {
      val currentSegment = slice.substring(index, slice.length)
      if (MyDict.dict.contains(currentSegment)) {
        return (currentSegment, slice.length - index)
      }
    }
    (slice.substring(slice.length - 1, slice.length), 1)
  }
}
