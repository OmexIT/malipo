package com.omexit.paymentbridge.core.payment;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

/**
 * Created by Antony on 2/9/2016.
 */
@Data
@Entity(name = "incoming")
@EqualsAndHashCode(callSuper = false)
public class IncomingPayment extends Payment {

	private static final long serialVersionUID = -1594760473960899561L;

	public PaymentType getPaymentType() {
        return PaymentType.INCOMING;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
