import java.io.File;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by Rıdvan Demirci on 2/9/18.
 */
public class LinkList<E> implements Iterable<E> {
    private Node<E> root;
    private Node<E> last;
    private int size = 0;


    /**
     * linklistin sonuna ekler
     * @param veri eklenecek olan veri
     */
    public void add(E veri){


        if(size == 0){
            root = new Node<E>(veri);
            last = root;

        }
        else {
            Node <E> temp = root;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node<E>(veri);
            last = temp.next;
        }

        size ++;
    }

    /**
     *
     * @param veri aranan
     * @return true  or false
      */
    public boolean search(E veri){
        Iterator<E> temp = this.iterator();
        while(temp.hasNext()){
            if(temp.next().equals(veri)){
                return true;
            }


        }
        if(temp.next().equals(veri)){
            return true;
        }
        return false;

    }

    /**
     * @throws IndexOutOfBoundsException index <0 or index >= size
     * @param index indis num start zero
     * @return true or false
     */


    public E get(int index){
        if(index <0 || index>=size)
            throw new IndexOutOfBoundsException();
        Node<E> temp = root;
        for(int i = 0;i<index;i++)
            temp = temp.next;

        return temp.data;
    }

    /**
     * @throws IndexOutOfBoundsException
     * @param index
     * @param data
     */
    public void set(int index , E data){
        if(index <0 || index>=size)
            throw new IndexOutOfBoundsException();
        Node<E> temp = root;
        for(int i =0;i<index;i++)
            temp = temp.next;

        temp.data = data;

    }


    /**
     * Verilen file dan verileri okur
     * @param fileName
     */
    public void fillInFile(String fileName){
        File dosya = new File(fileName);
        try{
            Scanner datas = new Scanner(dosya);
            while(datas.hasNext()){
                this.add((E)datas.next());

            }
        }
        catch (Exception e){
            System.out.println("file okuma hatasi"+e.getMessage());

        }


    }

    /**
     * ilk elemanı siler Queue mantığı için kullanılabilir
     */
    private void removeFirst(){

        root = root.next;
    }

    /**
     *
     * @param veri silinen data
     * @return true or false
     */
    public boolean remove(E veri){
        if(!this.search(veri)){
            return false;
        }

        this.size --;
        Node<E> temp = root;
        while (temp.next != null){
            if(temp.next.data.equals(veri)){
                temp.next = temp.next.next;
                return true;
            }
            temp = temp.next;

        }
        if(root.data.equals(veri)){
            this.removeFirst();
        }
        else if(last.data.equals(veri)){
            this.removeLast();

        }


        return true;
    }

    /**
     *
     * @return dataları alt alta yazar
     */
    @Override
    public String toString(){
        StringBuilder returnedString = new StringBuilder();
        Node<E> temp = root;
        System.out.println(size);
        while(temp != null) {
            returnedString.append(temp.data+"\n");
            temp = temp.next;
        }
        return returnedString.toString();
    }

    /**
     * en son ekleneni siler stack icin kullanılabilir
     */
    private void removeLast(){
        Node<E> temp = root;
        while(temp.next.next != null){
            temp = temp.next;

        }
        System.out.println(temp.data);

    }

    /**
     * iterator yapısı HasNext ,Next,
     * @return
     */
    @Override
    public Iterator<E> iterator() {

        Iterator<E> temp = new Iterator<E>() {
            Node<E> tempRoot = root;
            @Override
            public boolean hasNext() {
                return (tempRoot.next != null);
            }

            @Override
            public E next() {
                E datalar = tempRoot.data;
                tempRoot = tempRoot.next;
                return datalar;
            }
        };
        return temp;

    }

    /**
     * node yapısı
     * @param <E>
     */
    private static class Node<E>{
        private E data;
        private Node next;
        public Node(E veri){
            data = veri;
            next =null;
        }




    }
}
