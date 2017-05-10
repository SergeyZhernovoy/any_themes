package ru;/**
 * @author Sergey Zhernovoy
 * create on 10.05.2017.
 */

public class FilterField implements Filter {

    private String fieldName;
    private Operation operation;
    private Object value;
    private boolean placeholder = false;


    public FilterField() {
    }

    /**
     * @param fieldName наименование поля
     * @param operation операция
     * @param value     значение (строка, дата, число, булевское значение)
     */
    public FilterField(String fieldName, Operation operation, Object value) {
        this.fieldName = fieldName;
        this.operation = operation;
        this.value = value;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public void accept(FilterVisitor visitor) {
        visitor.visitFilterField(this);
    }

}


    