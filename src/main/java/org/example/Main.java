package org.example;

import org.example.cart.Cart;
import org.example.cart.CartItem;
import org.example.issuer.Issuer;
import org.example.lineOfBusiness.CommercePurchase;
import org.example.lineOfBusiness.CreditCardBillPayment;
import org.example.lineOfBusiness.InvestmentPurchase;
import org.example.paymentMethod.*;
import org.example.service.PaymentRecommendationService;
import org.example.service.PaymentRecommendationServiceImpl;
import org.example.user.DeviceContext;
import org.example.user.User;
import org.example.user.UserContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("The program has started.");

        User user1 = new User(1, "Shubham Patel", getUserContextUpiDisabled());
        user1.getPaymentInstrumentSet().add(new PaymentInstrument(PaymentMethodType.UPI, 0,Issuer.HDFC, 19));
        user1.getPaymentInstrumentSet().add(new PaymentInstrument(PaymentMethodType.UPI, 0,Issuer.SBI, 99));
        user1.getPaymentInstrumentSet().add(new PaymentInstrument(PaymentMethodType.CREDIT_CARD, 0,Issuer.AMEX, 99));
        user1.getPaymentInstrumentSet().add(new PaymentInstrument(PaymentMethodType.DEBIT_CARD, 0,Issuer.CITI, 50));
        user1.getPaymentInstrumentSet().add(new PaymentInstrument(PaymentMethodType.NET_BANKING, 0,Issuer.ICICI, 45));

        User user2 = new User(2, "Kishan Kumar Gupta", getUserContextUpiEnabled());
        user2.getPaymentInstrumentSet().add(new PaymentInstrument(PaymentMethodType.UPI, 0,Issuer.CITI, 99));
        user2.getPaymentInstrumentSet().add(new PaymentInstrument(PaymentMethodType.UPI, 0,Issuer.AXIS, 100));
        user2.getPaymentInstrumentSet().add(new PaymentInstrument(PaymentMethodType.CREDIT_CARD, 0,Issuer.AMEX, 99));
        user2.getPaymentInstrumentSet().add(new PaymentInstrument(PaymentMethodType.DEBIT_CARD, 0,Issuer.CITI, 34));
        user2.getPaymentInstrumentSet().add(new PaymentInstrument(PaymentMethodType.NET_BANKING, 0,Issuer.ICICI, 45));

        User user3 = new User(3, "Hardik Khanna", getUserContextUpiEnabled());
        user3.getPaymentInstrumentSet().add(new PaymentInstrument(PaymentMethodType.UPI, 0,Issuer.CITI, 99));
        user3.getPaymentInstrumentSet().add(new PaymentInstrument(PaymentMethodType.UPI, 0,Issuer.AXIS, 100));
        user3.getPaymentInstrumentSet().add(new PaymentInstrument(PaymentMethodType.CREDIT_CARD, 0,Issuer.AMEX, 99));
        user3.getPaymentInstrumentSet().add(new PaymentInstrument(PaymentMethodType.DEBIT_CARD, 0,Issuer.CITI, 34));
        user3.getPaymentInstrumentSet().add(new PaymentInstrument(PaymentMethodType.NET_BANKING, 0,Issuer.ICICI, 45));

        Cart cart1 = new Cart();
        cart1.addToCard(new CartItem("Atta", 100));
        cart1.addToCard(new CartItem("Chicken", 400));
        cart1.addToCard(new CartItem("iPhone 15", 55000));
        cart1.addToCard(new CartItem("ps5", 44000));
        cart1.setLineOfBusiness(new CommercePurchase());

        Cart cart2 = new Cart();
        cart2.addToCard(new CartItem("Life Insurance", 7000));
        cart2.addToCard(new CartItem("Health Insurance", 1000));
        cart2.addToCard(new CartItem("Sovereign Gold Bond", 95000));
        cart2.setLineOfBusiness(new InvestmentPurchase());

        Cart cart3 = new Cart();
        cart3.addToCard(new CartItem("Flipkart Axis Bank Credit Card Bill", 97000));
        cart3.setLineOfBusiness(new CreditCardBillPayment());

        PaymentRecommendationService paymentRecommendationService = new PaymentRecommendationServiceImpl();
        List<PaymentInstrument> paymentInstrumentList1 = paymentRecommendationService.getPaymentRecommendation(user1, cart1);
        List<PaymentInstrument> paymentInstrumentList2 = paymentRecommendationService.getPaymentRecommendation(user2, cart2);
        List<PaymentInstrument> paymentInstrumentList3 = paymentRecommendationService.getPaymentRecommendation(user3, cart3);

        System.out.println(user1);
        System.out.println(cart1);
        for (PaymentInstrument paymentInstrument: paymentInstrumentList1) {
            System.out.println(paymentInstrument);
        }
        System.out.println("---------------------------------------------------------------");

        System.out.println(user2);
        System.out.println(cart2);
        for (PaymentInstrument paymentInstrument: paymentInstrumentList2) {
            System.out.println(paymentInstrument);
        }
        System.out.println("---------------------------------------------------------------");

        System.out.println(user3);
        System.out.println(cart3);
        for (PaymentInstrument paymentInstrument: paymentInstrumentList3) {
            System.out.println(paymentInstrument);
        }
        System.out.println("---------------------------------------------------------------");

        System.out.println("The program has terminated.");

    }

    private static UserContext getUserContextUpiEnabled() {
        return new UserContext(getDeviceContextUpiEnabled());
    }

    private static UserContext getUserContextUpiDisabled() {
        return new UserContext(getDeviceContextUpiDisabled());
    }

    private static DeviceContext getDeviceContextUpiEnabled() {
        return new DeviceContext(Boolean.TRUE);
    }

    private static DeviceContext getDeviceContextUpiDisabled() {
        return new DeviceContext(Boolean.FALSE);
    }
}