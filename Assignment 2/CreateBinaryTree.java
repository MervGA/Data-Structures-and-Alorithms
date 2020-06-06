public class CreateBinaryTree {

    public Node createBinaryTree(){
        BinaryTreeOperations ob = new BinaryTreeOperations();
        Node tree = null;
        tree=ob.add(tree,10);
        tree=ob.add(tree,5);
        tree=ob.add(tree,19);
        tree=ob.add(tree,1);
        tree=ob.add(tree,17);
        tree=ob.add(tree,6);
        tree=ob.add(tree,27);
        return tree;
    }
}
