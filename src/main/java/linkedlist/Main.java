package linkedlist;

public class Main {

    public static void main(String[] args) {
        final MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("Hello world");
        myLinkedList.add("Hello one more time");
        myLinkedList.add("Hello one more time2");
        myLinkedList.add("Hello last time");
        myLinkedList.reverse();
        myLinkedList.remove("Hello one more time2");
        myLinkedList.print();
    }

}
