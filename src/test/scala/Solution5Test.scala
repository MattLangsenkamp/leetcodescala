class Solution5Test extends munit.FunSuite {
  test("simple small odd") {
    val longestDrone = Solution5.longestPalindrome("a")
    assertEquals("a", longestDrone)
  }

  test("simple small even") {
    val longestDrone = Solution5.longestPalindrome("aa")
    assertEquals("aa", longestDrone)
  }

  test("simple whole string odd") {
    val longestDrone = Solution5.longestPalindrome("aba")
    assertEquals("aba", longestDrone)
  }

  test("simple whole string even") {
    val longestDrone = Solution5.longestPalindrome("aaaa")
    assertEquals("aaaa", longestDrone)
  }
}
