package com.omexit.malipo.paymentbridge.channel;

/**
 * Created by Antony on 2/10/2016.
 */
public enum ChannelClassificationType {
    INVALID_ID(0, "INVALID_ID"),
    MOBILE_MONEY_CHANNEL(1, "MOBILE_MONEY_CHANNEL"),
    BANKING_CHANNEL(2, "BANKING_CHANNEL"),
    EMAIL_MONEY_CHANNEL(3, "EMAIL_MONEY_CHANNEL");

    private final Integer value;
    private final String code;

    ChannelClassificationType(final Integer value, final String code) {
        this.value = value;
        this.code = code;
    }

    public static ChannelClassificationType fromInt(final Integer typeValue) {
        ChannelClassificationType enumeration = ChannelClassificationType.INVALID_ID;
        switch (typeValue) {
            case 1:
                enumeration = ChannelClassificationType.MOBILE_MONEY_CHANNEL;
                break;
            case 2:
                enumeration = ChannelClassificationType.BANKING_CHANNEL;
                break;
            case 3:
                enumeration = ChannelClassificationType.EMAIL_MONEY_CHANNEL;
                break;
        }

        return enumeration;
    }

    public Integer getValue() {
        return this.value;
    }

    public String getCode() {
        return this.code;
    }

    public boolean hasTypeOf(final ChannelClassificationType type) {
        return this.value.equals(type.getValue());
    }

    public boolean isInvalId() {
        return this.value.equals(ChannelClassificationType.INVALID_ID.getValue());
    }

    public boolean isMobileMoneyChannel() {
        return this.value.equals(ChannelClassificationType.MOBILE_MONEY_CHANNEL.getValue());
    }

    public boolean isBankingChannel() {
        return this.value.equals(ChannelClassificationType.BANKING_CHANNEL.getValue());
    }

    public boolean isEmailMoneyChannel() {
        return this.value.equals(ChannelClassificationType.EMAIL_MONEY_CHANNEL.getValue());
    }
}
