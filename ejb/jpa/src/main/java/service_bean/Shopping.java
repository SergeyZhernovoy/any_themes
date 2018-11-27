package service_bean;

import java.util.Map;

public interface Shopping {
    void addItem(String item, int quantity);
    void removeItem(String item, int quantity);
    Map<String, Integer> getItems();
}
