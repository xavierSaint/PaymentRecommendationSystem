package org.example.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserContext {
    DeviceContext deviceContext;

    public UserContext(DeviceContext deviceContext1) {
        deviceContext = deviceContext1;
    }
}
