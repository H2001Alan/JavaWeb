package first.test;

import first.dao.OrderItemDao;
import first.dao.impl.OrderItemDaoImpl;
import first.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class OrderItemDaoImplTest {
    private OrderItemDao orderItemDao=new OrderItemDaoImpl();
    @Test
    public void saveOrderItem() {
        orderItemDao.saveOrderItem(new OrderItem(0,"Java从入门到精通",5,new BigDecimal(60),new BigDecimal(140),"156789615"));
    }

    @Test
    public void queryOrderItemByOrderId() {
        List<OrderItem> orderItems = orderItemDao.queryOrderItemByOrderId("156789615");
        System.out.println(orderItems);
    }
}