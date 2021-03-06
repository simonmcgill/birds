import java.util.Arrays;

class SinglyLinkedList<E> {

    private static class Node {
        private Bird element;
        private Node next;

        public Node(Bird element, Node next) {
            this.element = element;
            this.next = next;
        }

        public Bird getElement() {
            return this.element;
        }

        public Node getNext() {
            return this.next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node head = null;
    private Node tail = null;
    private int size = 0;

    public SinglyLinkedList() {
    }

    public void printAll() {

        Node current = this.head;

        for (int i = 0; i < this.size; i++) {
            System.out.print("Bird : ");
            System.out.print(current.getElement().getName());
            System.out.print("\nCount : ");
            System.out.println(current.getElement().getCount());

            current = current.next;

        }
    }

    public int getSize() {
        return this.size;
    }

    public void setFirst(Node newHead) {
        this.head = newHead;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public Bird first() {
        if (isEmpty())
            return null;
        return head.getElement();
    }

    public Bird last() {
        if (isEmpty())
            return null;
        return tail.getElement();
    }

    public void addFirst(Bird element) {
        this.head = new Node(element, this.head);

        if (size == 0) {
            this.tail = this.head;
        }
        size++;
    }

    public void addLast(Bird element) {
        Node newest = new Node(element, null);

        if (isEmpty())
            this.head = newest;
        else
            this.tail.setNext(newest);

        this.tail = newest;
        size++;
    }

    public Bird removeFirst() {
        if (isEmpty())
            return null;

        Bird answer = head.getElement();
        this.head = this.head.getNext();
        size--;

        if (size == 0)
            this.tail = null;

        return answer;
    }

    public void removeByName(String name) {
        Node current = this.head;

        for (int i = 0; i < this.size; i++) {
            System.out.println(i);

            if (current.getNext().getElement().getName().equals(name)) {

                if (current.getNext().getNext() == null) {
                    current.setNext(null);
                    this.tail = current;
                    this.size--;
                    break;

                } else {

                    current.setNext(current.getNext().getNext());
                    this.size--;
                    break;
                }

            }

            current = current.next;
        }

    }

    public boolean isIn(Bird bird) {

        boolean result = false;

        Node current = this.head;

        for (int i = 0; i < this.size; i++) {

            String currentName = current.getElement().getName();

            if (currentName.equals(bird.getName())) {
                result = true;

            }

            current = current.next;

        }

        return result;
    }

    public void incrementOne(Bird bird) {

        Node current = this.head;

        for (int i = 0; i < this.size; i++) {
            String currentName = current.getElement().getName();

            if (currentName.equals(bird.getName())) {
                current.getElement().incrementCount();
            }

            current = current.next;

        }
    }

    // TODO : reimplement, time complexity ok but alot of memory and can be sorted
    // in place
    // instead
    public void sort() {
        Bird[] birds = new Bird[this.size];
        int storedSize = this.size;
        Node current = this.head;

        for (int i = 0; i < this.size; i++) {

            birds[i] = current.getElement();

            current = current.next;
        }

        Arrays.sort(birds);

        for (int i = 0; i < storedSize; i++) {
            this.removeFirst();

        }

        for (int i = 0; i < storedSize; i++) {

            this.addLast(birds[i]);

        }
    }

}