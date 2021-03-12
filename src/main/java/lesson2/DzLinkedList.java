package lesson2;

public class DzLinkedList<E> {
    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        public Node(Node<E> prev, E item, Node<E> next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    int size;
    Node<E> firstNode;
    Node<E> lastNode;

    public void add(E element) {
        final Node<E> last = lastNode;
        final Node<E> newNode = new Node<>(last, element, null);
        lastNode = newNode;
        if (last == null) {
            firstNode = newNode;
        } else {
            last.next = newNode;
        }
        size++;
    }

    public void remove(E element) {
        for (Node<E> node = firstNode; node != null; node = node.next) {
            if (element.equals(node.item)) {
                if (node.prev == null) {
                    firstNode = node.next;

                } else {
                    node.prev.next = node.next;
                    node.prev = null;
                }
                if (node.next == null) {
                    lastNode = node.prev;
                } else {
                    node.next.prev = node.prev;
                    node.next = null;
                }
                node.item = null;
                size--;
            }
        }
    }

    public int indexOf(E element){
        int index = 0;
        if (element ==null){
            for (Node<E> node = firstNode; node != null; node=node.next) {
                if (node.item==null){
                    return index;
                }
                index++;
            }
        }else {
            for (Node<E> node = firstNode; node != null; node= node.next){
                if (element.equals(node.item)){
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    public void clear () {
        for (Node<E> node=firstNode;node!=null; ){
            Node<E> next = node.next;
            node.item = null;
            node.next=null;
            node.prev = null;
            node = next;
        }
        firstNode =null;
        lastNode = null;
        size=0;
    }
    public boolean contains(E element){
        return indexOf(element)>=0;
    }
    public E set (int index, E element){
        Node<E> node = findNode(index);
        E prevItem = node.item;
        node.item= element;
        return prevItem;
    }

    public E get(int i){
        return findNode(i).item;
    }

    private Node<E> findNode (int index){
        if (index<(size/2)){
            Node<E> node = firstNode;
            for (int i = 0; i < index; i++) {
                node=node.next;
            }
            return node;
        }else {
            Node<E> node =lastNode;
            for (int i=size-1; i>index; i--) {
                node=node.prev;
            }
            return node;
        }
    }
}
