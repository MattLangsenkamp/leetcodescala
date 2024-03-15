import munit.FunSuite
class Solution6Test extends FunSuite {
  test("case q") {
    val zigzagged = Solution6.convert("PAYPALISHIRING", 4)
    assertEquals("PINALSIGYAHRPI", zigzagged)
  }

}
