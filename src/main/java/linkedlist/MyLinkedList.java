package linkedlist;

import java.util.Objects;

public class MyLinkedList<T> {

    private Node<T> head;

    public void add(final T record) {
        if (Objects.isNull(head)) {
            head = new Node<>();
            head.setData(record);
            return;
        }
        Node<T> node = head;
        while (node.getNext() != null) {
            node = node.getNext();
        }
        final Node<T> newNode = new Node<>();
        newNode.setData(record);
        newNode.setPrevious(node);
        node.setNext(newNode);
    }

    public void remove(final T record) {
        if (Objects.isNull(head)) {
            return;
        }
        Node<T> node = head;
        while (Objects.nonNull(node)) {
            if (node.getData().equals(record)) {
                if (Objects.nonNull(node.getPrevious())) {
                    node.getPrevious().setNext(node.getNext());
                } else {
                    head = null;
                }
                return;
            }
            node = node.getNext();
        }
    }

    public void reverse() {
        Node<T> node = head;
        if (Objects.isNull(head.getNext())) {
            return;
        }
        while (Objects.nonNull(node.getNext())) {
            final Node<T> next = node.getNext();
            final Node<T> previous = node.getPrevious();
            node.setPrevious(next);
            node.setNext(previous);
            node = next;
        }
        node.setNext(node.getPrevious());
        node.setPrevious(null);
        head = node;
    }

    public void print() {
        Node<T> node = head;
        while (Objects.nonNull(node)) {
            System.out.println(node.getData());
            node = node.getNext();
        }
    }

}
