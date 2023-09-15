package utils;

import error.ErrorEmpty;
import models.Order;
import models.OrderDetail;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InspectValid {
    public static Map<String,String> inspectValid(Order order) {
        Map<String,String> error=new HashMap<>();

       if(order.getCustomerName().trim().equals("")) error.put("customerName","Name can not blank!");
       if(order.getCustomerAddress().trim().equals("")) error.put("customerAddress","Address can not blank!");
       return error;
    }

    public static Map<String,String> inspectValid(List<OrderDetail> list) {
        Map<String,String> error=new HashMap<>();

        for (OrderDetail orderDetail : list) {
            if(orderDetail.getProductName().trim().equals("")) error.put("productName","Name product can not blank!");
        }
        return error;
    }
}
