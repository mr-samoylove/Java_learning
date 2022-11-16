public class Main {
    public static void main(String[] args) {
        Sem05_Tree tree = new Sem05_Tree();

        tree.insertNode(6);
        tree.insertNode(8);
        tree.insertNode(5);
        tree.insertNode(8);
        tree.insertNode(2);
        tree.insertNode(10);
        tree.insertNode(9);
        tree.insertNode(11);
        tree.insertNode(7);
        tree.insertNode(4);
        tree.insertNode(1);

        tree.printTree();
    }
}