package org.example.service;

import org.example.cart.Cart;
import org.example.paymentMethod.PaymentInstrument;
import org.example.user.User;

import java.util.List;

public interface PaymentRecommendationService {
    List<PaymentInstrument> getPaymentRecommendation(User user, Cart cart);
}
