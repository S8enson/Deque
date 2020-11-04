/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deque;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Sam
 */
public class DoublyLinkedDeque<E> implements DequeADT<E> {

    public Node<E> front;
    public Node<E> rear;
    int numElements;

    public DoublyLinkedDeque() {
        numElements = 0;
    }

    public DoublyLinkedDeque(Collection<? extends E> c) {
        this();
        for (E e : c) {
            enqueueRear(e);
        }
    }

    @Override
    public void enqueueRear(E element) {
        Node<E> newNode = new Node(element);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            newNode.previous = rear;
            rear = newNode;
        }
        numElements++;
    }

    @Override
    public void enqueueFront(E element) {
        Node<E> newNode = new Node(element);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            front.previous = newNode;
            newNode.next = front;
            front = newNode;
        }
        numElements++;
    }

    @Override
    public E dequeueRear() {
        if (isEmpty()) {
            throw new IllegalStateException("Attempted to dequeue empty list");
        } else if (numElements == 1) {
            Node<E> temp = rear;
            front = null;
            rear = null;
            return temp.element;
        } else {
            Node<E> temp = rear;
            rear = rear.previous;
            temp.previous = null;
            rear.next = null;
            //rear.next = null;
            numElements--;

            return temp.element;
        }
    }

    @Override
    public E dequeueFront() {
        if (isEmpty()) {
            throw new IllegalStateException("Attempted to dequeue empty list");
        } else if (numElements == 1) {
            Node<E> temp = front;
            front = null;
            rear = null;
            return temp.element;
        } else {
            Node<E> temp = front;
            front = front.next;
            temp.next = null;
            front.previous = null;
            //front.previous = null;
            numElements--;

            return temp.element;
        }
    }

    @Override
    public E first() {
        return front.element;
    }

    @Override
    public E last() {
        return rear.element;
    }

    @Override
    public boolean isEmpty() {
        return numElements == 0;
    }

    @Override
    public int size() {
        return numElements;
    }

    @Override
    public void clear() {
        front = null;

        rear = front;

        numElements = 0;

    }

    @Override
    public Iterator<E> iterator() {
        return new LinkIterator();
    }

    public Iterator<E> iteratorDesc() {
        return new LinkIteratorDesc();
    }

    public String toString() {
        Iterator it = this.iterator();
        String str = "-";
        while (it.hasNext()) {
            str = str + it.next() + "-";

        }

        return str;
    }

    protected class Node<E> {

        public E element;
        public Node<E> next;
        public Node<E> previous;

        public Node(E element) {
            this.element = element;
            next = null;
            previous = null;
        }
    }

    private class LinkIterator implements Iterator<E> {

        private Node temp;

        public LinkIterator() {
            temp = front;
        }

        @Override
        public boolean hasNext() {

            return temp != null;
        }

        @Override
        public E next() {
            if (temp == null) {
                throw new NoSuchElementException();
            }

            E element = (E) temp.element;
            temp = temp.next;
            return element;
        }

    }

    private class LinkIteratorDesc implements Iterator<E> {

        private Node temp;

        public LinkIteratorDesc() {
            temp = rear;
        }

        @Override
        public boolean hasNext() {
            return temp != null;
        }

        @Override
        public E next() {
            if (temp == null) {
                throw new NoSuchElementException();
            }

            E element = (E) temp.element;
            temp = temp.previous;
            return element;
        }

    }

}
