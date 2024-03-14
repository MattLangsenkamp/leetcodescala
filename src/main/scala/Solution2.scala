case class ListNode(x: Int = 0, var next: ListNode = null)

object Solution2:
  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode =
    def go(l1: ListNode, l2: ListNode, carry: Int): ListNode =
      (Option(l1), Option(l2)) match
        case (Some(l1_), Some(l2_)) =>
          val localSum = carry + l1_.x + l2_.x
          val nX = localSum % 10
          val nCarry = if localSum > 9 then 1 else 0
          ListNode(nX, go(l1_.next, l2_.next, nCarry))
        case (None, Some(l2_)) =>
          val localSum = carry + l2_.x
          val nX = localSum % 10
          val nCarry = if localSum > 9 then 1 else 0
          ListNode(nX, go(null, l2_.next, nCarry))
        case (Some(l1_), None) =>
          val localSum = carry + l1_.x
          val nX = localSum % 10
          val nCarry = if localSum > 9 then 1 else 0
          ListNode(nX, go(l1_.next, null, nCarry))
        case (None, None) =>
          if carry != 0 then ListNode(carry, null)
          else null
    go(l1, l2, 0)
