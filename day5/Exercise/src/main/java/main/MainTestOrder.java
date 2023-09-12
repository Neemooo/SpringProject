package main;

import configuration.JPAConfig;
import models.Order;
import models.OrderDetail;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.OrderDetailRepos;
import repository.OrderRepos;

import java.time.LocalDate;
import java.util.*;

public class MainTestOrder {
    static AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(JPAConfig.class);
    static OrderRepos orderRepos = applicationContext.getBean("orderRepos", OrderRepos.class);
    static OrderDetailRepos orderDetailRepos= applicationContext.getBean("orderDetailRepos", OrderDetailRepos.class);
public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    String input;
    do{
        System.out.println("Enter 1 to insert");
        System.out.println("Enter 2 to list all order and orderDetails in the database");
        System.out.println("Enter 3 to get an order and orderDetails by order id");
        System.out.println("Enter 4 to list all the orders in the current month");
        System.out.println("Enter 5 to list all orders which have total amount more than 1,000USD");
        System.out.println("Enter 0 to exit application");
       input=sc.nextLine();

        switch (input){
            case "1":{
                List<OrderDetail> orderDetails=new ArrayList<>();
                Order order=inputOrder(sc);
                String subInput;
                do {
                    System.out.println("Enter at least one product!");
                    System.out.println("Enter 1 to continue!");
                    System.out.println("Enter 0 to finish process!");
                    subInput=sc.nextLine();
                    if ("1".equals(subInput)) {
                        OrderDetail orderDetail=inputOrderDetail(sc);
                        orderDetails.add(orderDetail);
                    }
                } while (!subInput.equals("0"));
                if(!orderDetails.isEmpty()){
                    insertOrderDetail(order,orderDetails);
                } else {
                    System.out.println("Error: You create order but That have not product");
                }

                break;
            }
            case "2":{
                findAll();
                break;
            }
            case "3":{
                System.out.println("Enter id of order That you want to find!");
                Long id=sc.nextLong();
                sc.nextLine();
                findAllById(id);
                break;
            }
            case "4":{
                findAllCurrentMonth();
                break;
            }
            case "5":{
                findAllByPriceGreaterThan(1000.0);
                break;
            }
        }
    }
    while (!input.equals("0"));
}

// Enter 1 to insert
    private static void insertOrderDetail(Order order,List<OrderDetail> orderDetailList){
        orderRepos.save(order);
        for (OrderDetail orderDetail : orderDetailList) {
            orderDetail.setOrder(order);
            orderDetailRepos.save(orderDetail);
            System.out.println("Order is saved!");
        }
    }

// Enter 2 to list all order and orderDetails in the database
    private static void findAll(){
        List<Order> orders=orderRepos.findAll();
       for(Order order:orders){
           System.out.println(order);
           order.getOrderDetail().forEach(System.out::println);
        }
    }

// Enter 3 to get an order and orderDetails by order id
    private static void findAllById(Long id){
        Optional<Order> optionalOrder = orderRepos.findById(id);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            System.out.println(order);
            order.getOrderDetail().forEach(System.out::println);
        } else {
            System.out.println("Not found any order with id is " + id);
        }
    }

//    Enter 4 to list all the orders in the current month
    private static void findAllCurrentMonth(){
        LocalDate currentDate = LocalDate.now();
        Integer month=currentDate.getMonthValue();
        List<Order> orders=orderRepos.findAllByOrderDate_Month(month);
        if(!orders.isEmpty()){
            System.out.println("List all the orders in the current month "+month);
            for(Order order:orders){
                System.out.println(order);
                order.getOrderDetail().forEach(System.out::println);
            }
        } else {
            System.out.println("Not found order in the current month "+month);
        }
    }

//   Enter 5 to list all orders which have total amount more than 1,000USD"

    private static void findAllByPriceGreaterThan(Double price){
    List<Order> orders=orderRepos.findAll();
    Map<Order,Double> map=new HashMap<>();
    for (Order order: orders){
        List<OrderDetail> orderDetails=order.getOrderDetail();
        double total= orderDetails.stream().mapToDouble(orderDetail->orderDetail.getUnitPrice()*orderDetail.getQuantity()).sum();
        if(total>price) map.put(order,total);
    }
    if(!map.isEmpty()){
        System.out.println("List all orders which have total amount more than 1,000USD");
        map.forEach((order,total)->
                System.out.println(order + " with total "+ total));
    } else {
            System.out.println("Not found list all orders which have total amount more than 1,000USD");
    }
    }

    // input order:
    private static Order inputOrder(Scanner sc){
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
    private static OrderDetail inputOrderDetail(Scanner sc){
        System.out.println("Enter name product");
        String nameProduct = sc.nextLine();

        System.out.println("Enter quantity product");
        Integer quantity = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter unit price product");
        Double unitPrice = sc.nextDouble();
        sc.nextLine();

       return OrderDetail.builder()
                .productName(nameProduct)
                .quantity(quantity)
                .unitPrice(unitPrice)
                .build();
    }
}
