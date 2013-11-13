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
public class Tree {
    Node root;

    public Tree() {
    }

    public Tree(Node root) {
        this.root = root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }
    
}
