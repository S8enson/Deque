/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deque;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Sam
 */
public class Main {

    public static void main(String[] args) {

        ArrayDeque<String> array = new ArrayDeque();
        System.out.println("ARRAY DEQUE TESTING\n\n");

        System.out.println("Enqueue to FRONT (F) and REAR (R)");

        array.enqueueFront("F");
        array.enqueueRear("R");
        System.out.println("Deque is: " + array.toString());

        System.out.println("CLEARING the Deque:");
        array.clear();
        System.out.println("Deque is: " + array.toString());

        System.out.println("Enqueue to REAR A, B, C, D");
        array.enqueueRear("A");
        array.enqueueRear("B");
        array.enqueueRear("C");
        array.enqueueRear("D");
        System.out.println("Deque is: " + array.toString());

        System.out.println("FRONT element is: " + array.first() + ", REAR element is: " + array.last());

        System.out.println("Enqueue to FRONT E, F, G, H");
        array.enqueueFront("E");
        array.enqueueFront("F");
        array.enqueueFront("G");
        array.enqueueFront("H");
        System.out.println("Deque is: " + array.toString());

        System.out.println("Number of elements in Deque: " + array.size());

        System.out.println("FRONT element is: " + array.first() + ", REAR element is: " + array.last());

        System.out.println("Dequeue TWO elements from FRONT: " + array.dequeueFront() + ", " + array.dequeueFront());
        System.out.println("Dequeue TWO elements from REAR: " + array.dequeueRear() + ", " + array.dequeueRear());

        System.out.println("Number of elements in Deque: " + array.size());

        System.out.println("FRONT element is: " + array.first() + ", REAR element is: " + array.last());

        // test iterator loop dequeue from rear until empty
        Iterator<String> it = array.iterator();
        System.out.print("Testing ITERATOR: ");
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println("");

        System.out.println("LOOP and Dequeue from REAR until empty: ");
        it = array.iterator();
        while (it.hasNext()) {
            System.out.print(array.dequeueRear() + " ");
        }

        System.out.println("Deque is: " + array.toString());

        ArrayDeque<Integer> arrayInt = new ArrayDeque();

        arrayInt.enqueueRear(1);
        arrayInt.enqueueRear(2);
        arrayInt.enqueueRear(3);

        arrayInt.enqueueFront(4);
        System.out.println("Deque is: " + arrayInt.toString());

        System.out.println("LOOP and Dequeue from FRONT until empty: ");

        Iterator<Integer> it2 = arrayInt.iteratorDesc();
        while (it2.hasNext()) {
            System.out.print(arrayInt.dequeueFront() + " ");
        }
        System.out.println("\n");
        System.out.println("Deque is: " + arrayInt.toString());

        //System.out.println("This should cause an EXCEPTION (ON PURPOSE)!! Dequeue from REAR EXCEPTION!!: " + arrayInt.dequeueRear());
        System.out.println("Testing expand");
        for (int i = 0; i < 10; i++) {
            arrayInt.enqueueRear(i);
        }
        System.out.println("Deque is: " + arrayInt.toString());

        //test starting with collection
        ArrayList<Integer> aList = new ArrayList();
        for (int i = 0; i < 10; i++) {
            aList.add(i);
        }
        System.out.println("Creating Deque from Collection:");
        ArrayDeque<Integer> arrayCol = new ArrayDeque(aList);
        System.out.println("Deque is: " + arrayCol.toString());

        System.out.println("\n\nDOUBLY LINKED DEQUE TESTING\n\n");

        DoublyLinkedDeque<String> link = new DoublyLinkedDeque();

        System.out.println("Enqueue to FRONT (F) and REAR (R)");

        link.enqueueFront("F");
        link.enqueueRear("R");
        System.out.println("Deque is: " + link.toString());

        System.out.println("CLEARING the Deque:");
        link.clear();
        System.out.println("Deque is: " + link.toString());

        System.out.println("Enqueue to REAR A, B, C, D");
        link.enqueueRear("A");
        link.enqueueRear("B");
        link.enqueueRear("C");
        link.enqueueRear("D");
        System.out.println("Deque is: " + link.toString());

        System.out.println("FRONT element is: " + link.first() + ", REAR element is: " + link.last());

        System.out.println("Enqueue to FRONT E, F, G, H");
        link.enqueueFront("E");
        link.enqueueFront("F");
        link.enqueueFront("G");
        link.enqueueFront("H");
        System.out.println("Deque is: " + link.toString());

        System.out.println("Number of elements in Deque: " + link.size());

        System.out.println("FRONT element is: " + link.first() + ", REAR element is: " + link.last());

        System.out.println("Dequeue TWO elements from FRONT: " + link.dequeueFront() + ", " + link.dequeueFront());
        System.out.println("Dequeue TWO elements from REAR: " + link.dequeueRear() + ", " + link.dequeueRear());

        System.out.println("Number of elements in Deque: " + link.size());

        System.out.println("FRONT element is: " + link.first() + ", REAR element is: " + link.last());

        // test iterator loop dequeue from rear until empty
        Iterator<String> it3 = link.iterator();
        System.out.print("Testing ITERATOR: ");
        while (it3.hasNext()) {
            System.out.print(it3.next() + " ");
        }
        System.out.println("");

        System.out.println("LOOP and Dequeue from REAR until empty: ");
        Iterator<String> it4 = link.iteratorDesc();
        while (it4.hasNext()) {
            it4.next();
            System.out.print(link.dequeueRear() + " ");
        }

        System.out.println("Deque is: " + link.toString());

        DoublyLinkedDeque<Integer> linkInt = new DoublyLinkedDeque();

        linkInt.enqueueRear(1);
        linkInt.enqueueRear(2);
        linkInt.enqueueRear(3);

        linkInt.enqueueFront(4);
        System.out.println("Deque is: " + linkInt.toString());

        System.out.println("LOOP and Dequeue from FRONT until empty: ");

        Iterator<Integer> it5 = linkInt.iterator();
        while (it5.hasNext()) {
            it5.next();
            System.out.print(linkInt.dequeueFront() + " ");
        }
        System.out.println("");
        System.out.println("Deque is: " + link.toString());

        System.out.println("Creating Deque from Collection:");
        DoublyLinkedDeque<Integer> linkCol = new DoublyLinkedDeque(aList);
        System.out.println("Deque is: " + linkCol.toString());

        //System.out.println("This should cause an EXCEPTION (ON PURPOSE)!! Dequeue from REAR EXCEPTION!!: " + linkInt.dequeueRear());
    }
}
