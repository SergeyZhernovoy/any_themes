package annotation.analizator;/**
 * Created by Admin on 17.06.2017.
 */

/**
 * Реализован шаблон конструктор, для избавления от телескопических конструкторов
 */

public class Entity {

    protected Long id;
    protected String description;

    private Entity(Builder builder){
            this.id = builder.id;
            this.description = builder.description;
    }

    public static class Builder {

        Long id = Long.valueOf(0);
        String description = "";

        public Builder setIdEntity(Long id){
            this.id = id;
            return this;
        }

        public Builder setDescriptionEntity(String description){
            this.description = description;
            return this;
        }

        public Entity build(){
            return new Entity(this);
        }
    }

    public static void main(String[] args) {
        Entity newEntity = new Entity.Builder()
                                     .setIdEntity(1L)
                                     .setDescriptionEntity("Test")
                                     .build();
    }

}
