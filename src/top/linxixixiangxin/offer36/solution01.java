package top.linxixixiangxin.offer36;

public class solution01 {
    public static void main(String[] args) {
        Node a1 = new Node(1);
        Node a3 = new Node(3);
        Node a2 = new Node(2);
        Node a5 = new Node(5);
        Node a4 = new Node(4);
        a4.left = a2;a4.right = a5;
        a2.left = a1;a2.right = a3;
        Node res = new Solution36_01().treeToDoublyList(a4);
    }
}
class Node{
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
    //For debug
    @Override
    public String toString() {
        return this.val+"";
    }
}
class Solution36_01 {
    /**
     * 二叉搜索树的中序遍历为 *递增序列*
     * 将 二叉搜索树 转换成一个“排序的循环双向链表，其中包含三个要素
     * 1，排序链表:节点应从小到大排序，因此应使用中序遍历从小打到访问树的集结点
     * 2.双向链表：在构建相邻节点关系时保证 pre.right = cur cur.left = pre
     * 3.循环链表：设链表头节点head和尾节点tail则应构建head.left = tail 和 tail.right = head
     */
    //前驱节点和当前节点
    Node pre, head;
    public Node treeToDoublyList(Node root) {
        //特例处理
        if(root == null) return null;
        //转双向链表
        dfs(root);
        //构建循环链表 head指向头 pre指向尾
        head.left = pre;
        pre.right = head;
        return head;
    }
    void dfs(Node cur) {
        //访问到叶子节点 不再继续向下访问
        if(cur == null) return;
        //继续遍历！左侧 ！
        dfs(cur.left);
        //如果前面的节点不为空  则前一个节点的右侧为当前节点 修改双向节点引用
        if(pre != null) pre.right = cur;
        //如果为空 代表正在访问头节点 头节点左侧暂不赋值 则头节点为当前节点 此处的头节点指得是链表的头节点
        else head = cur;
        //当前节点的左侧为之前的节点 第一次赋值的时候会赋值为null
        cur.left = pre;
        //之前的节点 保存cur 节点cur是后继节点的pre
        pre = cur;
        //递归！右侧节点！
        dfs(cur.right);
    }
}