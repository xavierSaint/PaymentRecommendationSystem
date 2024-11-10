package org.example.lineOfBusiness;

import lombok.Getter;
import lombok.Setter;
import org.example.paymentMethod.PaymentInstrument;
import org.example.paymentMethod.PaymentMethodType;

@Getter
@Setter
public class InvestmentPurchase extends LineOfBusiness {
    public InvestmentPurchase() {
        this.eligiblePaymentMethods.add(getUPI());
        this.eligiblePaymentMethods.add(getNetBanking());
        this.eligiblePaymentMethods.add(getDebitCard());
    }

    private PaymentInstrument getNetBanking() {
        PaymentInstrument paymentInstrument = new PaymentInstrument();
        paymentInstrument.setLimit(150000);
        paymentInstrument.setPaymentMethodType(PaymentMethodType.NET_BANKING);
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
        paymentInstrument.setLimit(150000);
        paymentInstrument.setPaymentMethodType(PaymentMethodType.DEBIT_CARD);
        return paymentInstrument;
    }
}
