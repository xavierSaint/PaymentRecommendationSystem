package org.example.service;

import org.example.cart.Cart;
import org.example.paymentMethod.*;
import org.example.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PaymentRecommendationServiceImpl implements PaymentRecommendationService{
    @Override
    public List<PaymentInstrument> getPaymentRecommendation(User user, Cart cart) {
        List<PaymentInstrument> eligiblePaymentMethods = cart.getLineOfBusiness().getEligiblePaymentMethods();

        //Check if the total cart amount is within limits of each payment type
        eligiblePaymentMethods.removeIf(paymentInstrument -> cart.getTotalCartAmount() > paymentInstrument.getLimit());

        //Check if user has upiEnabled or not
        eligiblePaymentMethods.removeIf(paymentInstrument -> PaymentMethodType.UPI.equals(paymentInstrument.getPaymentMethodType()) && !user.getUserContext().getDeviceContext().isUpiEnabled());

        List<PaymentMethodType> eligiblePaymentMethodTypes = eligiblePaymentMethods.stream().map(PaymentInstrument::getPaymentMethodType).toList();

        //TODO: Check the relevance of paymentInstrument in case we have multiple paymentInstruments of the same type
        List<PaymentInstrument> paymentInstruments = getValidUserPaymentMethods(user.getPaymentInstrumentSet(), eligiblePaymentMethodTypes);

        return sortPaymentInstruments(paymentInstruments, eligiblePaymentMethodTypes);
    }

    private List<PaymentInstrument> getValidUserPaymentMethods(Set<PaymentInstrument> paymentInstrumentSet, List<PaymentMethodType> eligiblePaymentMethodTypes) {
        return paymentInstrumentSet.stream().filter(val -> eligiblePaymentMethodTypes.contains(val.getPaymentMethodType())).toList();
    }


    private List<PaymentInstrument> sortPaymentInstruments(List<PaymentInstrument> paymentInstruments, List<PaymentMethodType> eligiblePaymentMethodTypes) {
        //Reorder the payment instruments as per priority and relevance
        List<PaymentInstrument> orderedPaymentInstrumentList = new ArrayList<>();
        for (PaymentMethodType paymentMethodType : eligiblePaymentMethodTypes) {
            List<PaymentInstrument> methodPayments = paymentInstruments.stream()
                    .filter(val -> val.getPaymentMethodType().equals(paymentMethodType))
                    .sorted((o1, o2) -> o2.getRelevanceScore() - o1.getRelevanceScore()).toList();
            orderedPaymentInstrumentList.addAll(methodPayments);
        }
        return orderedPaymentInstrumentList;
    }

}
