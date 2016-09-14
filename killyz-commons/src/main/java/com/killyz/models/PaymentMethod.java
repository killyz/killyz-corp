package com.killyz.models;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum PaymentMethod {

    UPON_COMPLETION("Upon Completion"),
    HALF_AND_HALF("Half & Half");

    private final String methodName;

    PaymentMethod(String methodName) {
        this.methodName = methodName;
    }

    @JsonValue
    public String getMethodName() {
        return methodName;
    }

    public static PaymentMethod getPaymentMethod(String methodName) {
        PaymentMethod paymentMethod = null;
        for (PaymentMethod method : PaymentMethod.values()) {
            if (method.getMethodName().equalsIgnoreCase(methodName))
                paymentMethod = method;
        }
        return paymentMethod;
    }

    public static List<PaymentMethod> getMethods() {
        return Stream.of(PaymentMethod.values()).collect(Collectors.toList());
    }
}
