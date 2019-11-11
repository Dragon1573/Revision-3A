package io.github.dragon1573;

/**
 * A simple class implemented nodes.
 *
 * @author Dragon1573
 */
class Node<E> {
    public E value = null;
    public Node<E> left = null;
    public Node<E> right = null;

    Node(E value) {
        this.value = value;
    }

    /**
     * Pre-order Traversal
     *
     * @return {@link java.lang.String}
     */
    final String DLR() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.value);
        if (this.left != null) {
            builder.append(this.left.DLR());
        }
        if (this.right != null) {
            builder.append(this.right.DLR());
        }
        return builder.toString();
    }

    /**
     * In-order Traversal
     *
     * @return {@link java.lang.String}
     */
    final String LDR() {
        StringBuilder builder = new StringBuilder();
        if (this.left != null) {
            builder.append(this.left.LDR());
        }
        builder.append(this.value);
        if (this.right != null) {
            builder.append(this.right.LDR());
        }
        return builder.toString();
    }

    /**
     * Post-order Traversal
     *
     * @return {@link java.lang.String}
     */
    final String LRD() {
        StringBuilder builder = new StringBuilder();
        if (this.left != null) {
            builder.append(this.left.LRD());
        }
        if (this.right != null) {
            builder.append(this.right.LRD());
        }
        builder.append(this.value);
        return builder.toString();
    }
}
