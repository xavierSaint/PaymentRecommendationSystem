package org.example.cart;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.example.lineOfBusiness.LineOfBusiness;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Cart {
    LineOfBusiness lineOfBusiness;
    List<CartItem> cartItems = new ArrayList<>();
    double totalCartAmount;

    public void addToCard(CartItem cartItem) {
        cartItems.add(cartItem);
        totalCartAmount += cartItem.price;
    }
}
