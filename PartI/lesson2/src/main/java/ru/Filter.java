package ru;

/**
 * @author Sergey Zhernovoy
 *         create on 10.05.2017.
 */
public interface Filter {
    void accept(FilterVisitor visitor);
}
