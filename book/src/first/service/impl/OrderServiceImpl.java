package first.service.impl;

import first.dao.BookDao;
import first.dao.OrderDao;
import first.dao.OrderItemDao;
import first.dao.impl.BookDaoImpl;
import first.dao.impl.OrderDaoImpl;
import first.dao.impl.OrderItemDaoImpl;
import first.pojo.*;
import first.service.OrderService;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao=new OrderDaoImpl();
    private OrderItemDao orderItem= new OrderItemDaoImpl();
    private BookDao bookDao=new BookDaoImpl();
    @Override
    public String createOrder(Cart cart,int userId) {
        String orderId= System.currentTimeMillis() +""+userId;
        Order order = new Order(orderId, new Date(), cart.getTotalPrice(), 0, userId);
        orderDao.saveOrder(order);
        Map<Integer, CartItem> items = cart.getItems();
        for(Map.Entry<Integer,CartItem> entry:items.entrySet()){
            orderItem.saveOrderItem(new OrderItem(0,entry.getValue().getName(),entry.getValue().getCount(),entry.getValue().getPrice(),entry.getValue().getTotalPrice(),orderId));
            //更新库存和销量
            Book book = bookDao.queryBookById(entry.getValue().getId());
            book.setSales(book.getSales()+entry.getValue().getCount());
            book.setStock(book.getStock()-entry.getValue().getCount());
            bookDao.updateBook(book);
        }
        cart.clear();
        return orderId;
    }

    @Override
    public List<Order> showAllOrders() {
        List<Order> orders = orderDao.queryOrder();
        return orders;
    }

    @Override
    public void sendOrder(String orderId) {
        orderDao.changerOrderStatus(orderId,1);
    }

    @Override
    public List<Order> showMyOrders(int userId) {
        List<Order> orders = orderDao.queryOrdersByUserId(userId);
        return orders;
    }

    @Override
    public void receiverOrder(String orderId) {
        orderDao.changerOrderStatus(orderId,2);
    }

    @Override
    public List<OrderItem> showOrderDetail(String orderId) {
        return  orderItem.queryOrderItemByOrderId(orderId);
    }
}
