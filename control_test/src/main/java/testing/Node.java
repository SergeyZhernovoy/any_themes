package testing;

/**
 * @author Sergey Zhernovoy
 * create on 18.10.2017.
 */


/**
 * Please write the java code for the following task - we need to

 calculate height of a tree when given its root node. Please design your

 own classes. We don't need tree rebalancing etc. Just the basic

 class(es) sufficient to represent the tree and be able to calculate the

 height. Feel free to make any assumptions. If you have time please

 provide unit test.

 Max time limit is 30 minutes to complete.
 * @param <E>
 */

public class Node<E> {

    private Node<E> left;

    private Node<E> right;

    private E value;

    public Node(E value){
        this.value = value;
    }


    public static <E> int maxDepth(Node<E> root) {
        if (root != null) {
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
        return 0;
    }

    public void setLeft(Node<E> left){
        this.left = left;
    }

    public void setRight(Node<E> right){
        this.right = right;
    }

}

    