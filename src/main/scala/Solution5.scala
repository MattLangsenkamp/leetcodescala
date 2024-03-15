import scala.collection.mutable
object Solution5:
  def longestPalindrome(s: String): String =
    def go(
        s: String,
        ind: Int,
        bestSoFar: String
    ): String =

      // ind is the start of the double
      def oddDrone(s: String, ind: Int): String =
        var leftInd = ind - 1
        var rightInd = ind + 1
        var isDrone = true
        var nS = mutable.StringBuilder()
        nS = nS.append(s.charAt(ind))
        while ((rightInd < s.length()) && (leftInd >= 0) && isDrone)
          val left = s.charAt(leftInd)
          val right = s.charAt(rightInd)
          if (left == right)
            nS = nS.insert(0, left).append(right)
          else isDrone = false
          leftInd -= 1
          rightInd += 1
        nS.toString()
      // ind is the middle of the triple
      def evenDrone(s: String, ind: Int): String =
        var leftInd = ind
        var rightInd = ind + 1
        var isDrone = true
        var nS = mutable.StringBuilder()
        while ((rightInd < s.length()) && (leftInd >= 0) && isDrone)
          val left = s.charAt(leftInd)
          val right = s.charAt(rightInd)
          if (left == right)
            nS = nS.insert(0, left).append(right)
          else isDrone = false
          leftInd -= 1
          rightInd += 1
        nS.toString()
      if (s.length() > ind)
        val curChar = s.charAt(ind)
        val nBestSoFar = if (ind + 1 < s.length())
          val nextChar = s.charAt(ind + 1)
          if (nextChar == curChar)
            val nDrone = evenDrone(s, ind)
            if (nDrone.length > bestSoFar.length) nDrone else bestSoFar
          else bestSoFar
        else bestSoFar
        val nBestSoFar2 = if ((ind + 1 < s.length()) && (ind - 1 >= 0))
          val prevChar = s.charAt(ind - 1)
          val nextChar = s.charAt(ind + 1)
          if (prevChar == nextChar)
            println(f"droning? $ind")
            val nDrone = oddDrone(s, ind)
            if (nDrone.length > nBestSoFar.length) nDrone else nBestSoFar
          else nBestSoFar
        else nBestSoFar
        val nBestSoFar3 =
          if nBestSoFar2.length() < 1 then s.charAt(ind).toString()
          else nBestSoFar2
        go(s, ind + 1, nBestSoFar3)
      else bestSoFar
    go(s, 0, "")
