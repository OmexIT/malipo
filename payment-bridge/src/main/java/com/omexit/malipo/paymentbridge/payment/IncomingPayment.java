package com.omexit.malipo.paymentbridge.payment;

import com.omexit.malipo.commonlib.types.PaymentType;
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

	public PaymentType getPaymentType() {
        return PaymentType.INCOMING;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
