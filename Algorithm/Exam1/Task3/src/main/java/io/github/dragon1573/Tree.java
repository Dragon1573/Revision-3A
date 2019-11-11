package io.github.dragon1573;

/**
 * A simple class implemented binary tree.
 *
 * @author Dragon1573
 */
public class Tree {
    Node<String> root = null;

    public final String preOrderTraversal() {
        return root.DLR();
    }

    public final String inOrderTraversal() {
        return root.LDR();
    }

    public final String postOrderTraversal() {
        return root.LRD();
    }
}
