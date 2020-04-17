package ru.bloch.builder;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * Здесь представлено кованирантное типизация вовзрата. Это позволяет использовать клиентам использовать строители без приведения типа
 * В параметрах билдера испольщуется имитация собственного типа
 * Шаблон строитель целесообразно использовать при количестве параметров конструктора больше четырех
 * @author Sergey Zhernovoy
 */
public abstract class Pizza {

    @Override
    public String toString() {
        return "Pizza{" +
                "toppings=" + toppings +
                '}';
    }

    public enum Topping {HAM, MUSHROOM, ONION, PEPPER, SAUSAGE}

    final Set<Topping> toppings;

    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone();
    }

    abstract static class Builder<T extends Builder> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }
        abstract Pizza build();

        protected abstract T self();
    }
}
