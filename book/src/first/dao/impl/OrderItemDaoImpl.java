package first.dao.impl;

import first.dao.OrderItemDao;
import first.pojo.OrderItem;

import java.util.List;

public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql="INSERT INTO t_order_item(`name`,`count` ,price ,total_price,order_id) VALUES(?,?,?,?,?) ";
        return update(sql,orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderId());
    }

    @Override
    public List<OrderItem> queryOrderItemByOrderId(String orderId) {
        String sql="SELECT id id,`name` name,`count` `count`,price price,total_price totalPrice,order_id orderId FROM t_order_item WHERE order_id=?;";
        return queryForList(OrderItem.class,sql,orderId);
    }


}
