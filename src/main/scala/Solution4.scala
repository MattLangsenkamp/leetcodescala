import java.lang.Math.ceil

object Solution4:
  def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double =

    def mergeUntil(
        nums1: Array[Int],
        nums2: Array[Int],
        until: Int
    ): (Int, Int) =
      var ind1 = 0
      var ind2 = 0
      var combinedInd = 0
      var prev = 0
      var cur = 0
      def update(nCur: Int) =
        prev = cur
        cur = nCur
        combinedInd += 1
      while (combinedInd < until) {
        if ind1 == nums1.length then
          update(nums2(ind2))
          ind2 += 1
        else if ind2 == nums2.length then
          update(nums1(ind1))
          ind1 += 1
        else if nums1(ind1) < nums2(ind2) then
          update(nums1(ind1))
          ind1 += 1
        else
          update(nums2(ind2))
          ind2 += 1
      }
      (prev, cur)

    val totalLength = nums1.length + nums2.length
    if totalLength == 0 then 0
    else if totalLength % 2 == 0 then
      val medianInd = totalLength / 2
      val (m1, m2) = mergeUntil(nums1, nums2, medianInd + 1)
      (m1.toDouble + m2.toDouble) / 2
    else
      val medianInd = ceil(totalLength / 2.0).toInt
      val (_, m) = mergeUntil(nums1, nums2, medianInd)
      m
