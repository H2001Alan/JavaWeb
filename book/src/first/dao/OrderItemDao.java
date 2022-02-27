package first.dao;

import first.pojo.Order;
import first.pojo.OrderItem;

import java.util.List;
import java.util.Map;

public interface OrderItemDao {
    int saveOrderItem(OrderItem orderItem);
    List<OrderItem> queryOrderItemByOrderId(String orderId);
}
