class Node{
    int left, right, bookedCnt, lazy;
    Node leftNode, rightNode;
    Node(int bookedCnt, int left, int right){
        this.bookedCnt = bookedCnt;
        this.left = left;
        this.right = right;
    }
    Node(){}
}
class MyCalendarTwo {
 Node root;
    public MyCalendarTwo() {
       root = new Node(0, 0,(int)1e9 - 1); 
    }
    
    public boolean book(int startTime, int endTime) {
        boolean cond = query(root,startTime, endTime - 1);
        if(cond) updateTree(root,0,(int)1e9, startTime, endTime - 1);
        return cond;
    }
    private boolean query(Node node, int left, int right){
        if(node == null) return true;
        if(node.left > right || node.right < left) return true;
        if(node.lazy == 2){return false;}
        if(node.left >= left && node.right <= right){
            return node.bookedCnt < 2;
        }
        push(node);
        return query(node.leftNode, left, right) && query(node.rightNode, left, right);
    }
    private void push(Node node){
        int l = node.left, h = node.right;
        int mid = (h - l) / 2 + l;
        if(node.leftNode == null){
            node.leftNode = new Node(0, l, mid);
        }
        if (node.rightNode == null){
            node.rightNode = new Node(0, mid + 1, h);
        }
        node.leftNode.bookedCnt += node.lazy;
        node.rightNode.bookedCnt += node.lazy;
        node.leftNode.lazy += node.lazy;
        node.rightNode.lazy += node.lazy;
        node.lazy = 0;
    }
    private void updateTree(Node node, int l, int h, int left, int right){
        if(node.left > right || node.right < left) return;
        if(node.left >= left && node.right <= right){
            node.bookedCnt++;
            node.lazy++;
            return;
        }
        push(node);
        int mid = (h - l) / 2 + l;
        updateTree(node.leftNode, l, mid, left, right);
        updateTree(node.rightNode, mid + 1, h, left, right);
        node.bookedCnt = Math.max(node.leftNode.bookedCnt, node.rightNode.bookedCnt);
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */