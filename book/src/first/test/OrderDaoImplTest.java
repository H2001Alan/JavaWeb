package first.test;

import first.dao.impl.OrderDaoImpl;
import first.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class OrderDaoImplTest {
    private OrderDaoImpl orderDao=new OrderDaoImpl();
    @Test
    public void saveOrder() {
        orderDao.saveOrder(new Order("215674579615",new Date(2001-07-23),new BigDecimal(100),0,15));
    }

    @Test
    public void queryOrder() {
        List<Order> orders = orderDao.queryOrder();
        for(Order order:orders){
            System.out.println(order);
        }
    }

    @Test
    public void changerOrderStatus() {
        orderDao.changerOrderStatus("156789615",2);
    }



    @Test
    public void testQueryOrdersByUserId() {
        System.out.println(orderDao.queryOrdersByUserId(15));
    }
}