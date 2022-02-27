package first.dao;

import first.pojo.Order;

import java.util.List;

public interface OrderDao {
    int saveOrder(Order order);
    List<Order> queryOrder();
    void changerOrderStatus(String orderId,int status);
    List<Order> queryOrdersByUserId(int UserId);
}
