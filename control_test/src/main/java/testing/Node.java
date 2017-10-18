package testing;

import java.util.*;

/**
 * @author Sergey Zhernovoy
 * create on 18.10.2017.
 */

public class Node<E> {

    private List<Node<E>> children = new ArrayList<>();

    private Node<E> parent;

    private E value;

    public Node(Node<E> parent, E value){
        this.parent = parent;
        this.value = value;
    }

    public List<Node<E>> getChildrenNode(){
        return this.children;
    }

    public Node addChild(E value){
        Node<E> child = new Node<>(this, value);
        this.children.add(child);
        return child;
    }

    public int getTreeHeight(){
        Map<Node<E>,Integer> frequency = new HashMap<>();
        return getTreeHeightReccur(this,frequency);
    }

    private int getTreeHeightReccur(Node<E> root, Map<Node<E>,Integer> bag){
        int result = 1;
        if(root.getChildrenNode().size() > 0){
            List<Integer> maxHeigths = new ArrayList<>();
            for(Node<E> node : root.getChildrenNode()){
                int resultReccur = getTreeHeightReccur(node,bag);
                maxHeigths.add(resultReccur);
            }
            result = Collections.max(maxHeigths);
        }
        return result;
    }

    public static void main(String[] args) {
        Node<String> tree = new Node<>(null,"root");
        Node<String> child1 = tree.addChild("1");
        Node<String> child2 = tree.addChild("2");
        Node<String> child3 = child1.addChild("3");
        Node<String> child4 = child2.addChild("4");
        Node<String> child5 = child2.addChild("5");
        Node<String> child6 = child5.addChild("6");
        Node<String> child7 = child5.addChild("7");

        System.out.println("Max heigt =  " + tree.getTreeHeight());

    }
}

    