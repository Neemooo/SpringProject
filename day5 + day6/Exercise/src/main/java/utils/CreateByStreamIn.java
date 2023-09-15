package utils;

import error.ErrorEmpty;
import models.Order;
import models.OrderDetail;

import java.util.Date;
import java.util.Scanner;

public class CreateByStreamIn {
    // input order:
    public static Order inputOrder(Scanner sc){
        System.out.println("Enter name customer!");
        String name=sc.nextLine();
        System.out.println("Enter address customer!");
        String address=sc.nextLine();
        return Order.builder()
                .orderDate(new Date())
                .customerName(name)
                .customerAddress(address)
                .build();
    }

    // input orderDetail
    public static OrderDetail inputOrderDetail(Scanner sc) throws ErrorEmpty {
        System.out.println("Enter name product");
        String nameProduct = sc.nextLine();

        System.out.println("Enter quantity product");
        Integer quantity = sc.nextInt();
        sc.nextLine();
        if(quantity==0) throw new ErrorEmpty("Quantity can not be 0!");

        System.out.println("Enter unit price product");
        Double unitPrice = sc.nextDouble();
        sc.nextLine();
        if(unitPrice==0) throw new ErrorEmpty("UnitPrice can not be 0!");

        return OrderDetail.builder()
                .productName(nameProduct)
                .quantity(quantity)
                .unitPrice(unitPrice)
                .build();
    }

    // update 
    public static Order inputOrder(Scanner sc, Order order){
        System.out.println("Old name customer is "+order.getCustomerName());
        System.out.println("Enter new name customer!");
        String name=sc.nextLine();
        if(!name.isEmpty() || !name.trim().equals("")) order.setCustomerName(name);

        System.out.println("Old address customer is "+order.getCustomerAddress());
        System.out.println("Enter address customer!");
        String address=sc.nextLine();
        if (!address.isEmpty() || !address.trim().equals("")) order.setCustomerAddress(address);

        order.setOrderDate(new Date());
        return order;
    }

    public static OrderDetail inputOrderDetail(Scanner sc, OrderDetail orderDetail) throws ErrorEmpty {

        System.out.println("Old name product is "+orderDetail.getProductName());
        System.out.println("Enter name product");
        String nameProduct = sc.nextLine();
        if(!nameProduct.isEmpty() || !nameProduct.trim().equals("")) orderDetail.setProductName(nameProduct);

        System.out.println("Old quantity is "+orderDetail.getQuantity());
        System.out.println("Enter quantity product or enter 0 to remain its old value");
        Integer quantity = sc.nextInt();
        sc.nextLine();
        if(quantity!=0) orderDetail.setQuantity(quantity);

        System.out.println("Old unit price is "+orderDetail.getUnitPrice());
        System.out.println("Enter unit price product or enter 0 to remain its old value");
        Double unitPrice = sc.nextDouble();
        sc.nextLine();
        if(unitPrice!=0) orderDetail.setUnitPrice(unitPrice);

        return orderDetail;
    }
}
