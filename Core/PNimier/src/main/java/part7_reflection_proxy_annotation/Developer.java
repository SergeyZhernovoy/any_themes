package part7_reflection_proxy_annotation;/**
 * @author Sergey Zhernovoy
 * create on 16.08.2017.
 */

@Access
public class Developer implements IPerson {

    private String name = "Sergey";

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name =name;
    }
}

    