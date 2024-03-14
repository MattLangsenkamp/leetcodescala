object Solution1:
  def twoSum(nums: Array[Int], target: Int): Array[Int] =

    val s = nums.zipWithIndex.foldLeft(Map.empty[Int, List[Int]]) {
      case (m, (cur, ind)) =>
        m + (cur -> (ind :: (m.getOrElse(cur, List.empty[Int]))))
    }
    val (num, index) =
      nums.zipWithIndex
        .find((curNum, curIndex) =>
          s.get(target - curNum) match
            case None => false
            case Some(solIndex) =>
              if solIndex.filter(_ != curIndex).length > 0 then true
              else false
        )
        .get

    Array(
      index,
      s.get(target - num).map(solIndex => solIndex.find(_ != index).get).get
    )
