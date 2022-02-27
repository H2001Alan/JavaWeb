package first.service;

import first.pojo.Cart;
import first.pojo.Order;
import first.pojo.OrderItem;

import java.util.List;

public interface OrderService {
    String createOrder(Cart cart, int userId);
    List<Order> showAllOrders();
    void sendOrder(String OrderId);
    List<Order> showMyOrders(int userId);
    void receiverOrder(String OrderId);
    List<OrderItem> showOrderDetail(String orderId);
}
