import java.io.File;
import java.util.Scanner;

/**
 * Created by oem on 2/14/18.
 */
public class Tree<E extends Comparable<E> > {
    private Node<E> root;
    private int size = 0;

    public boolean search(E data){

        Node<E> tempRoot = root;
        return helperSearch(data,tempRoot);


    }

    private boolean helperSearch(E data, Node<E> tempRoot) {
        if(tempRoot == null)
            return false;
        else{
        if(tempRoot.data.compareTo(data) == 0){
            return true;
        }

        else if(tempRoot.data.compareTo(data) <0){
            return helperSearch(data,tempRoot.right);

        }
        else {
            return helperSearch(data,tempRoot.left);

        }

    }
    }

    public boolean add(E data){
            if(this.search(data) != true) {
                Node<E> tempNode = root;
                root = helperAdd(tempNode, data);
                size++;
                return true;
            }
            return false;

    }
    public void fillInFile(String fileName){

        try{
            File file = new File(fileName);
            Scanner iter = new Scanner(file);
            while(iter.hasNext()){
                this.add((E)iter.next());


            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }

    private Node<E> helperAdd(Node<E> tempNode,E data) {
        if(tempNode == null){
            tempNode = new Node<E>(data);
            return tempNode;

        }
        else{
            if(data.compareTo(tempNode.data) >0){
                tempNode.right= helperAdd(tempNode.right,data);
                return tempNode;

            }
            else{
                tempNode.left = helperAdd(tempNode.left,data);
                return tempNode;

            }

        }
    }
    public void preOrderTraverse(){
        System.out.println("*************** PreOrder Traverse ***************");
        preOrderHelper(root);

    }
    private void  preOrderHelper(Node<E> data){
        if(data != null){
            System.out.println(data.data);
            preOrderHelper(data.left);
            preOrderHelper(data.right);

        }


    }
    public void inOrderTraverse(){
        System.out.println("*************** inOrder Traverse ***************");
        inOrderHelper(root);

    }
    private void  inOrderHelper(Node<E> data){
        if(data != null){

            inOrderHelper(data.left);
            System.out.println(data.data);
            inOrderHelper(data.right);

        }


    }
    private boolean isLeaf(Node<E> node){
        return ((node != null) & (node.left == null) & (node.right == null));

    }
    public int getHeight(E data){
        if(this.search(data) == false){
            return -1;
        }
        else{
            Node<E> temp = root;
            int height = 0;
            return getHeightHelper(temp,height,data);

        }


    }

    private int getHeightHelper(Node<E> temp, int height,E data) {
        if(temp.data.compareTo(data) == 0){
            return height;
        }
        else{
            if(temp.data.compareTo(data) <0){
                return getHeightHelper(temp.right,height+1,data);

            }
            else{
                return getHeightHelper(temp.left,height+1,data);

            }

        }
    }

    /**
     * tamamlanacak
     * @param data
     */
    public void delete(E data){
        Node<E> temp = root;
       root = helperDelete(data,root); // saglikli degil



    }

    private Node<E> helperDelete(E data, Node<E> temp) {
        if(temp.data.compareTo(data) == 0){
            if(this.isLeaf(temp)){
                temp.data = null;
            }
            else{
                if(temp.left != null){
                    if(temp.left.right == null){
                        temp.data = temp.left.data;
                        temp.left = null;
                        return temp;

                    }else{
                        Node<E> temp2 = temp.left;
                        while(temp2.right.right != null)
                            temp2 = temp2.right;
                        temp.data = temp2.right.data;
                        temp2.right = null;
                        return temp;


                    }
                    //sol tarafın en sagası gidicek
                }else{
                    temp = temp.right;
                    return temp;


                }
            }

        }else if(temp.data.compareTo(data) <0){
             temp.right = helperDelete(data,temp.right);
             return temp;


        }
        else{
             temp.left = helperDelete(data,temp.left);
            return temp;
        }
        return null;
    }

    public void postOrderTraversa(){
        System.out.println("*************** postOrder Traverse ***************");
        helperPostOrder(root);
    }

    private void helperPostOrder(Node<E> root) {



        if(root != null) {
            helperPostOrder(root.left);
            helperPostOrder(root.right);
            System.out.println(root.data);
        }
    }

    public void levelOrder(){

        System.out.println("*************** LevelOrder Traverse ***************");
        Node<E> temp =root;
        for(int i=0;i< size;i++)
        helperLevelOrder(temp,i);

    }
    private Node<E> getParent(E data){
        Node<E> temp = root;
        return  helperParent(root,data);
    }

    private Node<E> helperParent(Node<E> root,E data) {
        if((root.left.data == data) | (root.right.data == data)){
            return root;

        }
        else if(root.data.compareTo(data) <0){
            return helperParent(root.right,data);
        }
        else
            return helperParent(root.left,data);

    }

    private void helperLevelOrder(Node<E> temp, int i) {
        if(temp != null){

            if(i == getHeight(temp.data)){
                for(int k=0;k<i;k++)
                    System.out.print(" ");
                    System.out.print(temp.data+"\n");
                }



            helperLevelOrder(temp.left,i);
            helperLevelOrder(temp.right,i);


        }
    }


    @Override
    public String toString() {
        String temp = root.data.toString()+"\n"+root.left.data.toString();
        return temp;
    }

    private static class Node<E>{

        private E data;
        private Node<E> left;
        private Node<E> right;


        public Node(E data){

            this.data = data;
            this.left = null;
            this.right = null;

        }

    }
}
