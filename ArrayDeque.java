/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deque;

import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author Sam
 */
public class ArrayDeque<E> implements DequeADT<E> {

    private final int INITIAL_CAPACITY = 5;
    private E[] elements;
    int front;
    int rear;
    int numElements;
    private int capacity = INITIAL_CAPACITY;

    public ArrayDeque() {
        elements = (E[]) new Object[capacity];
        front = 0;
        rear = 0;
        numElements = 0;

    }

    public ArrayDeque(int size) {
        elements = (E[]) new Object[size];
        front = 0;
        rear = 0;
        capacity = size;
    }

    public ArrayDeque(Collection<? extends E> c) {
        this(c.size());
        
        for(E e : c){
            enqueueRear(e);
        }

    }

    @Override
    public void enqueueRear(E element) {
        if (numElements >= capacity) {
            expand();
        }
        if (isEmpty()) {
            elements[rear] = element;
        } else {
            rear = (rear + 1 + capacity) % capacity;
            elements[rear] = element;
        }
        numElements++;

    }

    @Override
    public void enqueueFront(E element) {
        if (numElements >= capacity) {
            expand();
        }
        if (isEmpty()) {
            elements[front] = element;
        } else {
            front = (front - 1 + capacity) % capacity;
            elements[front] = element;
        }
        numElements++;
    }

    @Override
    public E dequeueRear() throws NullPointerException{
        if (isEmpty()) {
            throw new NullPointerException("Attempted to dequeue empty array");
            
            
        } else {
            E element = elements[rear];
            elements[rear] = null;
            rear = (rear - 1 + capacity) % capacity;
            numElements--;
            if(isEmpty()){
            front = 0;
            rear = 0;
            }
            return element;
        }
    }

    @Override
    public E dequeueFront() throws NullPointerException{
        
        if (isEmpty()) {
            throw new NullPointerException("Attempted to dequeue empty array");
        } else {
            E element = elements[front];
            elements[front] = null;
            front = (front + 1 + capacity) % capacity;
            numElements--;
                        if(isEmpty()){
            front = 0;
            rear = 0;
            }
            return element;
        }
    }

    @Override
    public E first() {
        return elements[front];
    }

    @Override
    public E last() {
        return elements[rear];
    }

    @Override
    public boolean isEmpty() {
        return numElements==0;
    }

    @Override
    public int size() {
        return numElements;
    }

    @Override
    public void clear() {
        
        E[] newArray = (E[]) new Object[INITIAL_CAPACITY];
        elements = newArray;
        front = 0;
        rear = 0;
        numElements = 0;
        capacity = INITIAL_CAPACITY;

    }

    @Override
    public Iterator<E> iterator() {
        return new DequeIterator();
    }
    
    public Iterator<E> iteratorDesc() {
        return new DequeIteratorDesc();
    }

    public void expand() {
        E[] largerArray = (E[]) new Object[capacity*2];
        // copy the elements array to the largerArray
        
        int i = front;
        int j =0;
        while(j<numElements){
        largerArray[j] = elements[i];
        i=(i+1)%capacity;
        j++;
                
        }


        elements = largerArray;
        front = 0;
        rear = numElements - 1;
        capacity *= 2;
    }
    
    public String toString(){
        String str = new String("[");
        int i = front;
        int j =0;
        while(j<numElements){
        str = str +elements[i];
        i=(i+1)%capacity;
        j++;
        
        if(j != numElements){
        str = str +", ";
        }
                
        }
        str = str +"]";
    return str;
    }

    private class DequeIterator implements Iterator<E> {

        private int index;

        public DequeIterator() {
            index = front;
        }

        public boolean hasNext() {
            index = index%capacity;
            return elements[index] != null;
        }
        
        

        public E next() {
            index = index%capacity;
            return elements[index++];
        }

    }
    
    
    private class DequeIteratorDesc implements Iterator<E> {

        private int index;

        public DequeIteratorDesc() {
            index = rear;
        }

        public boolean hasNext() {
            index = index%capacity;
            return elements[index] != null;
        }
        
        

        public E next() {
            index = index%capacity;
            return elements[index--];
        }

    }

}
