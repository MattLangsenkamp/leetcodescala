object Solution20240312:

  case class ListNode(x: Int = 0, var next: ListNode = null)

  def removeZeroSumSublists(head: ListNode): ListNode = {
    // head and current cannot be null
    def removeSequence(
        head: ListNode,
        current: ListNode,
        acc: Int,
        nodeMap: Map[Int, ListNode]
    ): Option[ListNode] =
      val nAcc = current.x + acc
      if nAcc == 0 then Some(current.next)
      else
        nodeMap.get(nAcc) match
          case None =>
            if current.next != null then
              removeSequence(
                head,
                current.next,
                nAcc,
                nodeMap + (nAcc -> current)
              )
            else None
          case Some(node) =>
            node.next = current.next
            Some(head)

    def go(head: ListNode): ListNode =
      removeSequence(
        head,
        head,
        0,
        Map.empty[Int, ListNode]
      ) match
        case None => head
        case Some(value) =>
          if value != null then go(value)
          else null
    go(head)
  }
