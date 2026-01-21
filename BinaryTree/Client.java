package BinaryTree;

public class Client {
    static void main() {
        // input: 10 true 20 true 40 false false true 50 false false true 30 false true 60 true 70 false false false
        BinaryTree bt = new BinaryTree();
        bt.display();
        System.out.println(bt.seacrh(72));
        System.out.println(bt.height());
        System.out.println(bt.max());
        bt.levelOrder();
        System.out.println(Integer.parseInt("123") + 1);
    }
}
