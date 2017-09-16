package webstore.domain;/**
 * @author Sergey Zhernovoy
 * create on 16.09.2017.
 */

public class Customer {
    private  String customerId;
    private String name;
    private String address;
    private Boolean noOrdersMade;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getNoOrdersMade() {
        return noOrdersMade;
    }

    public void setNoOrdersMade(Boolean noOrdersMade) {
        this.noOrdersMade = noOrdersMade;
    }
}

    