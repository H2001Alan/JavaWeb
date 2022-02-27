package first.dao.impl;

import first.dao.OrderDao;
import first.pojo.Order;

import java.util.List;

public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int saveOrder(Order order) {
        String sql="insert into t_order(order_id,create_time,price,`status`,user_id) values(?,?,?,?,?)";
        return update(sql,order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());
    }

    @Override
    public List<Order> queryOrder() {
        String sql="select order_id orderId,create_time createTime,price price,status status,user_id userId from t_order";
        return queryForList(Order.class,sql);
    }

    @Override
    public void changerOrderStatus(String orderId, int status) {
        String sql="UPDATE t_order SET `status`=? WHERE order_id=?";
        update(sql,status,orderId);
    }

    @Override
    public List<Order> queryOrdersByUserId(int userId) {
        String sql = "select order_id orderId,create_time createTime,price price,status status,user_id userId from t_order where user_id=?";
        List<Order> orders = queryForList(Order.class, sql, userId);
        return orders;
    }

}
