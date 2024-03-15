import java.lang.Math.max
import scala.annotation.tailrec

object Solution6:
  def convert(s: String, numRows: Int): String =
    type Grid = Array[Array[Char]]

    val numCols = s.length()
    @tailrec
    def go(
        s: String,
        row: Int,
        col: Int,
        down: Boolean,
        ind: Int,
        grid: Grid
    ): Grid =
      if (ind < s.length())
        grid(row)(col) = s.charAt(ind)
        val (nRow, nCol, nDown) = (row, down) match
          case _ if numRows == 1               => (0, col + 1, true)
          case (r, false) if r == 0            => (row + 1, col, true)
          case (r, false)                      => (row - 1, col + 1, false)
          case (r, true) if r == (numRows - 1) => (row - 1, col + 1, false)
          case (r, true)                       => (row + 1, col, true)
        go(s, nRow, nCol, nDown, ind + 1, grid)
      else grid

    val grid = go(
      s,
      0,
      0,
      true,
      0,
      Array
        .fill(numRows, numCols)('!')
    )

    grid.map(row => row.filter(_ != '!').mkString("")).mkString
