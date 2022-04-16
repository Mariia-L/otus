package homework;

import com.google.common.collect.Maps;

import java.util.*;

public class CustomerService {

    private final TreeMap<Customer, String> customerData = new TreeMap<>(Customer::compareTo);

    public Map.Entry<Customer, String> getSmallest() {

        return getMapEntry(customerData.firstEntry());
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {

        return getMapEntry(customerData.higherEntry(customer));
    }

    public void add(Customer customer, String data) {

        customerData.put(customer, data);
    }

    private Map.Entry<Customer, String> getMapEntry(Map.Entry<Customer, String> entry)
    {
        return entry == null ? null : Maps.immutableEntry(new Customer(entry.getKey().getId(),
                entry.getKey().getName(), entry.getKey().getScores()), entry.getValue());
    }
}
