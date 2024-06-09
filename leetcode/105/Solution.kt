class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {

    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        return helper(0, 0, inorder.size - 1, preorder, inorder)
    }

    fun helper(preStart: Int, inStart: Int, inEnd: Int, preorder: IntArray, inorder: IntArray): TreeNode? {
        if (preStart >= preorder.size || inStart > inEnd) return null
        // preorder[preStart] == ROOT
        val root = TreeNode(preorder[preStart])
        val rootOnInorder = inorder.indexOf(root.`val`)

        root.left = helper(preStart + 1, inStart, rootOnInorder - 1, preorder, inorder)
        root.right = helper(preStart + rootOnInorder - inStart + 1, rootOnInorder + 1, inEnd, preorder, inorder)

        return root
    }
}