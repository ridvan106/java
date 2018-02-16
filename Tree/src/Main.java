public class Main {

    public static void main(String[] args) {

        Tree<String> tree = new Tree<String>();
        tree.fillInFile("list.txt");
       /* tree.preOrderTraverse();
        tree.inOrderTraverse();
        tree.postOrderTraversa();*/
       tree.delete("sleepy");
       tree.add("sleepy");
        tree.levelOrder();
        //tree.preOrderTraverse();
    }
}
