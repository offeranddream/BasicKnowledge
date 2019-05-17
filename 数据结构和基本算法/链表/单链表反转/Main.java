package com.hotnuclear.revers;

/**
 * Created by louqilin on 2019/5/13.
 */
public class Main {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node1.setNextNode(node2);
        node2.setNextNode(node3);
        node3.setNextNode(node4);
        node4.setNextNode(node5);

        printNodes(node1);

        Node orderedNode = getReversNode(node1);

        printNodes(orderedNode);

    }

    public static Node getReversNode(Node currNode) {
        if (null != currNode) {
            Node preNode = null;

            while (currNode.getNextNode() != null) {
                Node nextNode = currNode.nextNode;
                currNode.setNextNode(preNode);
                preNode = currNode;
                currNode = nextNode;
            }

            currNode.setNextNode(preNode);
        }
        return currNode;
    }

    private static void printNodes(Node node) {
        if (null != node) {
            System.out.println(node.getValue());
            if (null != node.getNextNode()) {
                printNodes(node.getNextNode());
            }
        }
    }
}
