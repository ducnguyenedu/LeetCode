/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null) return null
        val valP = p?.`val` ?: -1
        val valQ = q?.`val` ?: -1
        return when {
            valP > root.`val` && valQ > root.`val` ->
                lowestCommonAncestor(root.right, p, q)

            valP < root.`val` && valQ < root.`val` ->
                lowestCommonAncestor(root.left, p, q)

            else -> root
        }
    }
}

class TreeNode(var `val`: Int = 0) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}