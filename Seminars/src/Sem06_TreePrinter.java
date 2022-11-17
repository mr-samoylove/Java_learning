import java.util.Stack;

public class Sem06_TreePrinter {

    static public void PrintTreePreOrder(Sem05_Node root) {
        if (root != null){
            System.out.print(root.getValue());
            var left = root.getLeftChild();
            var right = root.getRightChild();
            if (left != null || right != null) {
                System.out.print("(");
                if (left == null) System.out.print("null");
                else PrintTreePreOrder(left);
                System.out.print(",");
                if (right == null) System.out.print("null");
                else PrintTreePreOrder(right);
                System.out.print(")");
            }
        }
    }

    static public void PrintTreePostOrder(Sem05_Node root){
        if (root != null){
            var left = root.getLeftChild();
            var right = root.getRightChild();
            if (left != null || right != null) {
                System.out.print("(");
                if (left == null) System.out.print("null");
                else PrintTreePostOrder(left);
                System.out.print(",");
                if (right == null) System.out.print("null");
                else PrintTreePostOrder(right);
                System.out.print(")");
            }
            System.out.print(root.getValue());
        }
    }

    static public void PrintTreeInOrder(Sem05_Node root){
        if (root != null){
            PrintTreeInOrder(root.getLeftChild());
            System.out.print(root.getValue() + " ");
            PrintTreeInOrder(root.getRightChild());
        }
    }


    static public void printTreeBreadthFirst(Sem05_Node root) {
        Stack<Sem05_Node> globalStack = new Stack<>(); // общий стек для значений дерева
        globalStack.push(root);
        int gaps = 32; // начальное значение расстояния между элементами
        String separator = "-----------------------------------------------------------------";
        System.out.println(separator);
        boolean isRowEmpty = false;
        while (!isRowEmpty) {
            Stack<Sem05_Node> localStack = new Stack<>(); // локальный стек для задания потомков элемента
            isRowEmpty = true;

            for (int j = 0; j < gaps; j++)
                System.out.print(' ');
            while (!globalStack.isEmpty()) {
                Sem05_Node temp = (Sem05_Node) globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.getValue());
                    localStack.push(temp.getLeftChild()); // сохраняем в локальный стек наследников текущего элемента
                    localStack.push(temp.getRightChild());
                    if (temp.getLeftChild() != null ||
                            temp.getRightChild() != null)
                        isRowEmpty = false;
                }
                else {
                    System.out.print("__");// - если элемент пустой
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < gaps * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            gaps /= 2;// при переходе на следующий уровень расстояние между элементами каждый раз уменьшается
            while (!localStack.isEmpty())
                globalStack.push(localStack.pop()); // перемещаем все элементы из локального стека в глобальный
        }
        System.out.println(separator);
    }
}
