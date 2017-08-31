package part1_preface;

/**
 * @author Sergey Zhernovoy
 *         create on 30.07.2017.
 */
@FunctionalInterface
public interface PersonFactory<P extends Person> {
    P create(String name, String lastName);
}
