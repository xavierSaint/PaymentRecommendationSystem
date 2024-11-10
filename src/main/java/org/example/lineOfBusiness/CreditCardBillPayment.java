package org.example.lineOfBusiness;

import org.example.paymentMethod.*;

public class CreditCardBillPayment extends LineOfBusiness {

    public CreditCardBillPayment() {
        this.eligiblePaymentMethods.add(getUPI());
        this.eligiblePaymentMethods.add(getNetBanking());
        this.eligiblePaymentMethods.add(getDebitCard());
    }

    private PaymentInstrument getNetBanking() {
        PaymentInstrument paymentInstrument = new PaymentInstrument();
        paymentInstrument.setLimit(200000);
        paymentInstrument.setPaymentMethodType(PaymentMethodType.NET_BANKING);
        return paymentInstrument;
    }

    private PaymentInstrument getUPI() {
        PaymentInstrument paymentInstrument = new PaymentInstrument();
        paymentInstrument.setLimit(200000);
        paymentInstrument.setPaymentMethodType(PaymentMethodType.UPI);
        return paymentInstrument;
    }

    private PaymentInstrument getDebitCard() {
        PaymentInstrument paymentInstrument = new PaymentInstrument();
        paymentInstrument.setLimit(200000);
        paymentInstrument.setPaymentMethodType(PaymentMethodType.DEBIT_CARD);
        return paymentInstrument;
    }
}
