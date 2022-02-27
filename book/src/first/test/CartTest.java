package first.test;

import first.pojo.Cart;
import first.pojo.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CartTest {

    @Test
    public void addItems() {
        Cart cart = new Cart();
        cart.addItems(new CartItem(1,"java",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItems(new CartItem(1,"java",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItems(new CartItem(2,"python",1,new BigDecimal(100),new BigDecimal(100)));
        System.out.println(cart);
        cart.deleteItems(1);
        System.out.println(cart);
        cart.clear();
        System.out.println(cart);
        cart.addItems(new CartItem(1,"java",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItems(new CartItem(1,"java",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItems(new CartItem(2,"python",1,new BigDecimal(100),new BigDecimal(100)));
        cart.updateCount(2,3);
        System.out.println(cart);
    }
}