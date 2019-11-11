package io.github.dragon1573;

/**
 * Hello world!
 *
 * @author Dragon1573
 */
public class App {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.root = new Node<>("a");
        tree.root.left = new Node<>("b");
        tree.root.right = new Node<>("c");
        tree.root.left.left = new Node<>("d");
        tree.root.right.left = new Node<>("e");
        tree.root.right.right = new Node<>("f");
        tree.root.left.left.left = new Node<>("x");
        tree.root.left.left.right = new Node<>("y");
        System.out.println(tree.preOrderTraversal());
        System.out.println(tree.inOrderTraversal());
        System.out.println(tree.postOrderTraversal());
    }
}
