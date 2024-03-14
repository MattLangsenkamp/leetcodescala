import java.lang.Math.max
import scala.annotation.tailrec

object Solution3:

  def lengthOfLongestSubstring(s: String): Int =
    @tailrec
    def go(
        maxL: Int,
        startInd: Int,
        curInd: Int,
        indMap: Map[Char, Int],
        s: String
    ): Int =
      // println(f"$maxL, $startInd, $curInd")
      if s.length() == curInd then max(curInd - startInd, maxL)
      else if indMap.contains(s.charAt(curInd)) then
        val curChar = s.charAt(curInd)
        go(
          max(curInd - startInd, maxL),
          indMap(curChar) + 1,
          curInd + 1,
          indMap.updated(curChar, curInd),
          s
        )
      else
        val curChar = s.charAt(curInd)
        go(maxL, startInd, curInd + 1, indMap + (curChar -> curInd), s)
    go(0, 0, 0, Map.empty[Char, Int], s)
