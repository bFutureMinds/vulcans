package com.vulcans.chatbot.dao;

import com.vulcans.chatbot.data.Context;
import com.vulcans.chatbot.domain.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 6/12/2016.
 */
public class CustomerDAO {

    private static Map<String, Customer> customersMap = new HashMap() {
        {
            put("ID1", new Customer("ID1", "Sonal", "Oza", "soza@bcus.com", "10000", "", "", Context.DFT));
            put("ID2", new Customer("ID2", "Kanhaiya", "Gautam", "kgautam@bcus.com", "10000", "", "", Context.DFT));
            put("ID3", new Customer("ID3", "Shrikant", "Pandit", "spandit@bcus.com", "10000", "", "", Context.DFT));
        }
    };

    public Customer getCustomer(String id) {
        return customersMap.get(id);
    }

    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customersMap.values());
    }
}
