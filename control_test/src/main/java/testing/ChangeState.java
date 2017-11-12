package testing;/**
 * @author Sergey Zhernovoy
 * create on 11.11.2017.
 */

public class ChangeState {
    public static class Claim{
        String name;
    }

    public static void main(String[] args) {
        Integer value = 1;
        ChangeState.change(value);
        System.out.println(value);
    }

    private static void processClaim(Claim value) {
        value.name = "task";
    }

    public static void change(Integer that) {
        that++;
    }
}

    