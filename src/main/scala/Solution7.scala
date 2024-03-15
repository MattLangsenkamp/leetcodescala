object Solution7 {
  def reverse(x: Int): Int =
    val lookupTable = Map[Int, Int](
      0 -> 2,
      1 -> 1,
      2 -> 4,
      3 -> 7,
      4 -> 4,
      5 -> 8,
      6 -> 3,
      7 -> 6,
      8 -> 4,
      9 -> 7
    )
    val origS = x.toString()

    def go(s: String): String =
      val origCharArray = Array.fill(10)('0')
      s.toCharArray().copyToArray(origCharArray)
      val revCharArray = origCharArray.reverse
      var lookOut = false
      var tarnished = false
      for (i <- (0 until s.length())) {
        if (i == 0 && revCharArray(i).toString.toInt > 2) tarnished = true
        else if (i == 0 && revCharArray(i).toString.toInt == 2)
          println("lookin")
          lookOut = true
        else if (lookOut && lookupTable(i) < revCharArray(i).toString.toInt)
          println("tarnished")
          tarnished = true
        else if (lookOut && lookupTable(i) == revCharArray(i).toString.toInt)
          println("still lookin")
          lookOut = true
        else lookOut = false
      }

      if tarnished then "0"
      else revCharArray.mkString("")
    if origS.startsWith("-") then ("-" + go(origS.replace("-", ""))).toInt
    else go(origS).toInt
}
