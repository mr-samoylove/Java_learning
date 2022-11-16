public class Sem05_Node {
    private final int value;
    private Sem05_Node leftChild;
    private Sem05_Node rightChild;

    public Sem05_Node(int value) {
        this.value = value;
        leftChild = null;
        rightChild = null;
    }

    public int getValue() {
        return this.value;
    }

    public Sem05_Node getLeftChild() {
        return this.leftChild;
    }

    public void setLeftChild(final Sem05_Node leftChild) {
        this.leftChild = leftChild;
    }

    public Sem05_Node getRightChild() {
        return this.rightChild;
    }

    public void setRightChild(final Sem05_Node rightChild) {
        this.rightChild = rightChild;
    }

    public String toString() {
        return "Node{" +
                "value=" + value +
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                '}';
    }
}