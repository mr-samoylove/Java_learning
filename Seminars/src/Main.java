public class Main {
    public static void main(String[] args) {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_RED = "\u001B[31m";
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

        var root = tree.getRootNode();
        System.out.println(ANSI_RED + "Вывод в ширину" + ANSI_RESET);
        Sem06_TreePrinter.printTreeBreadthFirst(root);

        System.out.println(ANSI_RED + "Вывод принципом NLR (pre-order)" + ANSI_RESET);
        Sem06_TreePrinter.PrintTreePreOrder(root);
        System.out.println();

        System.out.println(ANSI_RED + "Вывод принципом LRN (post-order)" + ANSI_RESET);
        Sem06_TreePrinter.PrintTreePostOrder(root);
        System.out.println();

        System.out.println(ANSI_RED + "Вывод принципом LNR (in-order)" + ANSI_RESET);
        Sem06_TreePrinter.PrintTreeInOrder(root);
        System.out.println();
    }
}