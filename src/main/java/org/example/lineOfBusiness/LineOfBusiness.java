package org.example.lineOfBusiness;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.paymentMethod.PaymentInstrument;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public abstract class LineOfBusiness {
    List<PaymentInstrument> eligiblePaymentMethods = new ArrayList<>();
}
