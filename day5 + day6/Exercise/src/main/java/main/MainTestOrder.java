package main;

import configuration.JPAConfig;
import utils.InspectValid;
import error.NullOrderDetail;
import error.ErrorEmpty;
import models.Order;
import models.OrderDetail;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.OrderDetailService;
import service.OrderService;
import utils.CreateByStreamIn;

import java.time.LocalDate;
import java.util.*;

public class MainTestOrder {
    static AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(JPAConfig.class);
    static OrderService orderService=applicationContext.getBean("orderService", OrderService.class);
    static OrderDetailService orderDetailService=applicationContext.getBean("orderDetailService", OrderDetailService.class);

    public static void main(String[] args) throws ErrorEmpty {
    Scanner sc=new Scanner(System.in);
    String input;
    do{
        System.out.println("Enter 1 to insert");
        System.out.println("Enter 2 to list all order and orderDetails in the database");
        System.out.println("Enter 3 to get an order and orderDetails by order id");
        System.out.println("Enter 4 to list all the orders in the current month");
        System.out.println("Enter 5 to list all orders which have total amount more than 1,000USD");
        System.out.println("Enter 6 to list all orders buy Java book");
        System.out.println("Enter 7 to update order and orderDetail by id");
        System.out.println("Enter 8 to delete order by name customer");
        System.out.println("Enter 0 to exit application");
       input=sc.nextLine();

        switch (input){
            case "1":{
                List<OrderDetail> orderDetails=new ArrayList<>();
                Order order= CreateByStreamIn.inputOrder(sc);
                String subInput;
                do {
                    System.out.println("Enter at least one product!");
                    System.out.println("Enter 1 to continue!");
                    System.out.println("Enter 0 to finish process!");
                    subInput=sc.nextLine();
                    if ("1".equals(subInput)) {
                        OrderDetail orderDetail= CreateByStreamIn.inputOrderDetail(sc);
                        orderDetails.add(orderDetail);
                    }
                } while (!subInput.equals("0"));
                insertOrderDetail(order,orderDetails);
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
            case "6":{
                System.out.println("Enter product name");
                String name=sc.nextLine();
                findAllByProductName(name);
                break;
            }
            case "7":{
                System.out.println("Enter id That you want to update!");
                Long id=sc.nextLong();
                sc.nextLine();
                Optional<Order> isExisted=orderService.findById(id);
                if(isExisted.isPresent()){
                    Order order=new Order();
                    List<OrderDetail> orderDetails=isExisted.get().getOrderDetail();
                    String subInput;
                    do {
                        System.out.println("Enter 1 to update order (name customer, address customer)!");
                        System.out.println("Enter 2 to update orderDetail(name product, quantity, unit price)");
                        System.out.println("Enter 0 to finish process!");
                        System.out.println("Enter your choice");
                        subInput=sc.nextLine();
                        switch (subInput){
                            case "1":{
                                order=CreateByStreamIn.inputOrder(sc,isExisted.get());
                                break;
                            }
                            case "2":{
                                for (OrderDetail orderDetail:orderDetails){
                                    CreateByStreamIn.inputOrderDetail(sc,orderDetail);
                                }
                                break;
                            }
                        }
                    } while (!subInput.equals("0"));
                    insertOrderDetail(order,orderDetails);
                    System.out.println("Order is updated!");
                } else {
                    System.out.println("Not found any order with id is " + id);
                }
                break;
            }
            case "8":{
                System.out.println("Enter name customer!");
                String name=sc.nextLine();
                deletedByNameCustomer(name);
                break;
            }
        }
    }
    while (!input.equals("0"));
}

// Enter 1 to insert
// Enter 7 to update
    private static void insertOrderDetail(Order order,List<OrderDetail> orderDetailList) throws ErrorEmpty {

        if (orderDetailList.isEmpty()) throw new NullOrderDetail("Can not create order without any order detail!");

        Map<String, String> errorOrder= InspectValid.inspectValid(order);

        Map<String, String> errorOrderDetail= InspectValid.inspectValid(orderDetailList);

        StringBuilder warning=new StringBuilder();
        if (!errorOrder.isEmpty()) errorOrder.forEach((key,value)-> warning.append(key).append(": ").append(value).append("\n"));
        if (!errorOrderDetail.isEmpty()) errorOrderDetail.forEach((key,value)-> warning.append(key).append(": ").append(value).append("\n"));

        // if it have not error: 
        if(errorOrder.isEmpty() && errorOrderDetail.isEmpty()){
            orderService.insertOrder(order);
            for (OrderDetail orderDetail : orderDetailList) {
                orderDetail.setOrder(order);
                orderDetailService.insertOrderDetail(orderDetail);
                System.out.println("Order is saved!");
            }
            System.out.println(order.getId()==null?"Insert is successful!":"Update is successful!");
        } else {
            throw new ErrorEmpty( "Process failed!\n" + "Reason: \n" + warning.toString());
        }

    }

// Enter 2 to list all order and orderDetails in the database
    private static void findAll(){
        List<Order> orders=orderService.findAll();
       for(Order order:orders){
           System.out.println(order);
           order.getOrderDetail().forEach(System.out::println);
        }
    }

// Enter 3 to get an order and orderDetails by order id
    private static void findAllById(Long id){
        Optional<Order> optionalOrder = orderService.findById(id);
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
        List<Order> orders=orderService.findAllByOrderDate_Month(month);
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
    List<Order> orders=orderService.findAll();
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

//    Enter 6 to list all orders buy Java book
    private static void findAllByProductName(String name){
    List<Order> orders=orderService.findAllByOrderDetailProductName(name);
    if(!orders.isEmpty()){
        System.out.println(String.format("List all orders buy %s book", name));
        System.out.println(orders);
    } else {
        System.out.println(String.format("Not found list all orders buy %s book", name));
    }
    }

//    Enter 8 to deleted by name customer
    private static void deletedByNameCustomer(String name){
        List<Order> orderList=orderService.findAllByCustomerNameLike(name);
        if(!orderList.isEmpty()){
           for(Order order: orderList){
               orderDetailService.deleteAllByOrderById(order.getId());
               orderService.deleteById(order.getId());
           }
            System.out.println("Deleted is successful!");
        } else {
            System.out.println(String.format("Not found list all orders name customer %s ", name));
        }

    }

}
