package org.example.paymentMethod;

import lombok.*;
import org.example.issuer.Issuer;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PaymentInstrument {
    PaymentMethodType paymentMethodType;
    int limit = 0;
    Issuer issuer = null;
    int relevanceScore = 0;
}
