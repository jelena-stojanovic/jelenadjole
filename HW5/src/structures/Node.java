/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structures;

/**
 *
 * @author Jelena
 */
public class Node {

    public int value;
    public Node leftNode;
    public Node rightNode;
    public Node parentNode;

    public Node() {
    }

    public Node(int value, Node leftNode, Node rightNode, Node parentNode) {
        this.value = value;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.parentNode = parentNode;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Node other = (Node) obj;
        return this.value == other.value;
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (obj instanceof Node) {
//            if (obj != null) {
//                return this.value == ((Node) obj).value;
//            }
//        }
//        return false;
//
//    }

    @Override
    public String toString() {
        String str;
        if (this != null) {
            str = value + "\n";
            if (leftNode == null) {
                str += "  //";
            } else {
                str += "  " + leftNode.value;
            }
            if (rightNode == null) {
                str += "  \\\\";
            } else {
                str += "  " + rightNode.value;
            }
        } else {
            str = "\tNULL";
        }
        return str;
    }

}
