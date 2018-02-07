package collectors_example;

public class StringCombiner {
    private String delim;
    private String prefix;
    private String suffix;
    private StringBuilder builder = new StringBuilder();

    public StringCombiner(String delim, String prefix, String suffix) {
        this.delim = delim;
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public StringCombiner add(String element){
        if(!areAtStart()){
            builder.append(delim);
        }
        builder.append(element);
        return this;
    }

    public StringCombiner merge(StringCombiner other){
        if(!other.equals(this)){
            if(!other.areAtStart() && !areAtStart()){
                other.builder.insert(0,this.delim);
            }
            builder.append(other.builder);
        }

        return this;
    }

    private Boolean areAtStart(){
        return builder.length() == 0;
    }

    @Override
    public String toString() {
        return String.format("%s%s%s",prefix,this.builder.toString(),suffix);
    }
}
