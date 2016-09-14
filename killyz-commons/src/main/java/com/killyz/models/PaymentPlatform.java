package com.killyz.models;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum PaymentPlatform {

    PAYPAL("PayPal");

    private final String platformName;

    PaymentPlatform(String platformName) {
        this.platformName = platformName;
    }

    @JsonValue
    public String getPlatformName() {
        return platformName;
    }

    public static PaymentPlatform getPaymentPlatform(String platformName) {
        PaymentPlatform paymentPlatform = null;
        for (PaymentPlatform platform : PaymentPlatform.values()) {
            if (platform.getPlatformName().equalsIgnoreCase(platformName))
                paymentPlatform = platform;
        }
        return paymentPlatform;
    }

    public static List<PaymentPlatform> getPlatforms() {
        return Stream.of(PaymentPlatform.values()).collect(Collectors.toList());
    }
}
