package aod.lab1;

/**
 * Representerar en nod i en länkad lista.
 *
 * Varje nod innehåller ett element och en referens
 * till nästa nod i listan.
 *
 * @author Abdisalan Mahad Omar
 * @date 2026-04-10
 */

class Node<T> {

    T element;
    Node<T> next;

    Node(T element) {
        this.element = element;
        this.next = null;
    }
}