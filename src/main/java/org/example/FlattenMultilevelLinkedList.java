package org.example;

public class FlattenMultilevelLinkedList {
    public Node flatten(Node head) {
        if (head == null) return null;

        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;

        while (head != null) {
            if (head.child != null) {
                Node child = head.child;
                while (child.next != null) {
                    child = child.next;
                }
                child.next = head.next;
                if (head.next != null) {
                    head.next.prev = child;
                }
                head.next = head.child;
                head.child.prev = head;
                head.child = null;
            }
            prev = head;
            head = head.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        FlattenMultilevelLinkedList solution = new FlattenMultilevelLinkedList();

        // Ejemplo de uso:
        // Construir la lista doblemente enlazada según el ejemplo 1:
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(3);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(4);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.prev = head.next.next.next;
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.prev = head.next.next.next.next;
        head.next.next.child = new Node(7);
        head.next.next.child.next = new Node(8);
        head.next.next.child.next.prev = head.next.next.child;
        head.next.next.child.next.next = new Node(11);
        head.next.next.child.next.next.prev = head.next.next.child.next;
        head.next.next.child.next.next.next = new Node(12);
        head.next.next.child.next.next.next.prev = head.next.next.child.next.next;
        head.next.next.next.next.next.child = new Node(9);
        head.next.next.next.next.next.child.next = new Node(10);
        head.next.next.next.next.next.child.next.prev = head.next.next.next.next.next.child;

        // Aplanar la lista doblemente enlazada:
        Node flattenedHead = solution.flatten(head);

        // Imprimir la lista aplanada:
        printList(flattenedHead);
    }

    private static void printList(Node head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}

