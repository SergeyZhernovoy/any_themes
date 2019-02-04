package service_bean.impl;

import service_bean.CommonBeanActions;
import service_bean.Shopping;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import java.util.HashMap;
import java.util.Map;

@Stateful
public class ShoppingCard implements Shopping, CommonBeanActions {

    private Map<String, Integer> items = new HashMap<>();

    @Override
    public void addItem(String item, int quantity) {
        Integer orderQuantity = items.get(item);
        if (orderQuantity == null) {
            orderQuantity = 0;
        }
        orderQuantity += quantity;
        items.put(item, orderQuantity);
    }

    @Override
    public void removeItem(String item, int quantity) {

    }

    @Override
    public Map<String, Integer> getItems() {
        return null;
    }

    @Remove
    @Override
    public void checkout(int paymentId) {

    }

    @Remove
    @Override
    public void cancel() {

    }
}
