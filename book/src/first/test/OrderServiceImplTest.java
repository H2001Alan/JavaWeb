package first.test;

import first.pojo.Cart;
import first.pojo.CartItem;
import first.pojo.Order;
import first.service.OrderService;
import first.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class OrderServiceImplTest {
    private OrderService orderService=new OrderServiceImpl();
    @Test
    public void createOrder() {
        Cart cart = new Cart();
        cart.addItems(new CartItem(1,"go",10,new BigDecimal(15),new BigDecimal(150)));
        cart.addItems(new CartItem(1,"go",8,new BigDecimal(15),new BigDecimal(120)));
        cart.addItems(new CartItem(2,"java",10,new BigDecimal(110),new BigDecimal(1100)));
        System.out.println(orderService.createOrder(cart, 1));
    }

    @Test
    public void showAllOrders() {
        List<Order> orders = orderService.showAllOrders();
        for (Order order:orders){
            System.out.println(order);
        }
    }

    @Test
    public void sendOrder() {
        orderService.sendOrder("16363652578211");
    }

    @Test
    public void showMyOrders() {
        System.out.println(orderService.showMyOrders(1));
    }

    @Test
    public void receiverOrder() {
        orderService.receiverOrder("16363652578211");
    }

    @Test
    public void showOrderDetail() {
        System.out.println(orderService.showOrderDetail("16363652578211"));
    }
}