package org.example.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.paymentMethod.PaymentInstrument;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class User {
    int userId;
    String name;
    UserContext userContext;
    Set<PaymentInstrument> paymentInstrumentSet = new HashSet<>();

    public User(int userId, String name, UserContext userContext) {
        this.userId = userId;
        this.name = name;
        this.userContext = userContext;
    }

}
