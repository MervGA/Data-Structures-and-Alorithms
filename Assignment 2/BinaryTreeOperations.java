public class BinaryTreeOperations {

    public Node createNewNode(int x){
        Node n = new Node();
        n.value = x;
        n.leftnode = null;
        n.rightnode = null;
        return n;
    }

    public Node add(Node node, int y){
        if(node==null){
            return createNewNode(y);
        }
        else if(y<node.value){
            node.leftnode=add(node.leftnode,y);
        }
        else if(y>node.value){
            node.rightnode= add(node.rightnode,y);
        }
        return node;
    }

    public Node del(Node root, int val) {
        if (root == null) {
            return null;
        } else if (val > root.value) {
            root.rightnode = del(root.rightnode, val);
        } else if (val < root.value) {
            root.leftnode = del(root.leftnode, val);
        } else {
            if (root.rightnode == null || root.leftnode == null) {
                Node temporary = null;
                temporary = root.rightnode == null ? root.leftnode : root.rightnode;
                if (temporary == null) {
                    return null;
                } else {
                    return temporary;
                }
            } else {
                int succ = successor(root, val);
                root.value = succ;
                root.rightnode = del(root.rightnode, val);
            }
        }
        return root;
    }


    public int findMinimum(Node root){
        while(root.leftnode!=null){
            root=root.leftnode;
        }
        return root.value;
    }

    public int findMax(Node root){
        while(root.rightnode!=null){
            root=root.rightnode;
        }
        return root.value;
    }

    public Node search(Node root, int val){
        if(root==null){
            return null;
        }
        else if(root.value==val) {
            return root;
        }
        else if(val<root.value) {
            return search(root.leftnode, val);
        }
        else if(val>root.value)
            return search(root.rightnode,val);
        else{
            return null;
        }
    }

    public int successor(Node root, int val){

        Node focus = search(root,val);
        if(focus ==null){
            System.out.println("Element not found!");
            return 0;
        }
        if(focus.rightnode != null){
            return findMinimum(focus.rightnode);
        }
        else{
            Node successor = null;
            Node parent =root;
            while(parent != focus){
                if(focus.value<parent.value){
                    successor = parent;
                    parent = parent.leftnode;
                }
                else{
                    parent = parent.rightnode;
                }

            }
            return successor.value;
        }
    }

    public int predecessor(Node root, int val) {
        Node focus = search(root, val);
        if (focus == null) {
            System.out.println("Element not found!");
            return 0;
        }
        if (focus.leftnode != null) {
            return findMax(focus.leftnode);
        } else {
            Node predecessor = null;
            Node parent = root;
            while (parent != focus) {
                if (focus.value > parent.value) {
                    predecessor = parent;
                    parent = parent.rightnode;
                } else {
                    parent = parent.leftnode;
                }
            }
            System.out.println("The predecessor is: ");
            return predecessor.value;
        }
    }
}
