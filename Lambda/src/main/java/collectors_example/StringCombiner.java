package collectors_example;

import java.util.List;

public class StringCombiner {
    private String delim;
    private String prefix;
    private String suffix;
    private Boolean atStart;
    private StringBuilder builder = new StringBuilder();

    public StringCombiner(String delim, String prefix, String suffix) {
        this.delim = delim;
        this.prefix = prefix;
        this.suffix = suffix;
        atStart = true;
    }

    public StringCombiner add(String element){
        if(areAtStart()){
            builder.append(prefix);
        } else {
            builder.append(delim);
        }
        builder.append(element);
        return this;
    }

    public StringCombiner merge(StringCombiner other){
        builder.append(other.builder);
        return this;
    }

    private Boolean areAtStart(){
        Boolean start = atStart;
        if(atStart){
           this.atStart = false;
        }
        return start;
    }

    @Override
    public String toString() {
        return this.builder.toString();
    }
}
