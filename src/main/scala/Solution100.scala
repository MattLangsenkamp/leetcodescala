case class TreeNode(
    var value: Int = 0,
    var left: TreeNode = null,
    var right: TreeNode = null
)

object Solution100:

  def isSameTree(p: TreeNode, q: TreeNode): Boolean =

    val value = p.value == q.value
    val leftValue = (Option(p.left), Option(q.left)) match
      case (Some(pl), Some(ql)) => isSameTree(pl, ql)
      case (None, None)         => false
      case _                    => false

    val rightValue = (Option(p.right), Option(q.right)) match
      case (Some(pr), Some(qr)) => isSameTree(pr, qr)
      case (None, None)         => true
      case _                    => false

    value && leftValue && rightValue

  def isSameTree2(p: TreeNode, q: TreeNode): Boolean =
    (Option(p), Option(q)) match
      case (Some(pt), Some(qt)) =>
        p.value == q.value &&
        isSameTree(pt.left, qt.left) &&
        isSameTree(pt.left, qt.left)
      case (None, None) => true
      case _            => false
