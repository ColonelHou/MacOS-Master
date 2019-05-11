package com.java.algorithm.datastruct.a_link;

/**
 * Created by colonelhou on 2019/5/8.
 */
public class SingleLinkReserve {
    public static void main(String[] args) {
        Node head = new Node(3);
        head.next = new Node(5);
        Node tmp = head.next;
        tmp.next = new Node(7);
        tmp = tmp.next;
        tmp.next = new Node(1);
        tmp = tmp.next;
        tmp.next = new Node(9);

        print(head);
        System.out.println("+++++++++++++");
        head = reserve(head);
        print(head);
    }
    public static Node reserve(Node head) {
        Node p1 = head;
        Node p2 = head.next;
        Node p3 = null;
        while (p2 != null) {
            p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }
        head.next = null;
        head = p1;
        return head;
    }

    public static void print(Node head) {
        Node it = head;
        while (it != null) {
            System.out.println(it.data);
            it = it.next;
        }
    }

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}

