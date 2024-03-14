object Solution5:
  def longestPalindrome(s: String): String =
    def microDrones(
        s: String,
        ind: Int,
        prefixMap: Map[String, Int]
    ): Map[String, Int] = ???
    def growDrone(s: String, ind: Int): String = ???
    val mds = microDrones(s, 0, Map.empty[String, Int])
    mds.toVector.map(growDrone).maxBy(_.length())
