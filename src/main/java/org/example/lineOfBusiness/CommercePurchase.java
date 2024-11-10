package org.example.lineOfBusiness;

import lombok.Getter;
import lombok.Setter;
import org.example.paymentMethod.PaymentInstrument;
import org.example.paymentMethod.PaymentMethodType;

@Getter
@Setter
public class CommercePurchase extends LineOfBusiness {

    public CommercePurchase() {
        this.eligiblePaymentMethods.add(getCreditCard());
        this.eligiblePaymentMethods.add(getUPI());
        this.eligiblePaymentMethods.add(getDebitCard());
    }

    private PaymentInstrument getCreditCard() {
        PaymentInstrument paymentInstrument = new PaymentInstrument();
        paymentInstrument.setLimit(250000);
        paymentInstrument.setPaymentMethodType(PaymentMethodType.CREDIT_CARD);
        return paymentInstrument;
    }

    private PaymentInstrument getUPI() {
        PaymentInstrument paymentInstrument = new PaymentInstrument();
        paymentInstrument.setLimit(100000);
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
