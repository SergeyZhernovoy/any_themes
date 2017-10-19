package testing;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * @author Sergey Zhernovoy
 * create on 19.10.2017.
 */
public class NodeTest {

    @Test
    public void checkCurrentDepth(){

        Node<String> root = new Node<>("root");
        Node<String> child1 = new Node<>("1");
        Node<String> child2 = new Node<>("2");
        Node<String> child3 = new Node<>("3");
        Node<String> child4 = new Node<>("4");
        Node<String> child5 = new Node<>("5");
        Node<String> child6 = new Node<>("6");
        Node<String> child7 = new Node<>("7");

        root.setLeft(child1);
        root.setRight(child2); //1
        child1.setLeft(child3);
        child1.setRight(child4);//2
        child3.setLeft(child5);//3
        child5.setRight(child6);//4
        child2.setRight(child7);//
        // + 1 root

        Assert.assertThat(5,is(Node.maxDepth(root)));

    }


}