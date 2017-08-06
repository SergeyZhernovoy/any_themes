package javabean_di_approach;/**
 * @author Sergey Zhernovoy
 * create on 06.08.2017.
 */

public class PoeticJuggler extends Juggler {

    private PoemImpl poem;

    public PoeticJuggler(int beanBags, PoemImpl poem) {
        super(beanBags);
        this.poem = poem;
    }

    public PoeticJuggler(PoemImpl poem) {
        super();
        this.poem = poem;
    }

    @Override
    public void perform() throws PerformanceException {
        super.perform();
        System.out.println("While reciting...");
        poem.recite();
    }
}

    