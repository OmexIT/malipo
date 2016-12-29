package com.omexit.paymentbridge.core.payment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.omexit.paymentbridge.core.util.DateUtil;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by Antony on 2/9/2016.
 */
@Entity(name = "outgoing")
@EqualsAndHashCode(callSuper = false)
public class OutgoingPayment extends Payment {

	private static final long serialVersionUID = 8005427823824625540L;

	@JsonIgnore
    @Column(name = "actual_disbursement_date")
    private Date actualDisbursementDate;

    @JsonProperty("actual_disbursement_date")
    private String strActualDisbursementDate;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }


    public PaymentType getPaymentType() {
        return PaymentType.OUTGOING;
    }

    public Date getActualDisbursementDate() {
        return actualDisbursementDate;
    }

    public void setActualDisbursementDate(Date actualDisbursementDate) {
        this.actualDisbursementDate = actualDisbursementDate;
    }

    public String getStrActualDisbursementDate() {
        if (getDateCreated() != null) {
            strActualDisbursementDate = DateUtil.formatDate(getActualDisbursementDate(), DateUtil.DEFAULT_DATE_FORMAT);
        }

        return strActualDisbursementDate;
    }

    @Override
    public String toString() {
        return super.toString() + ", actualDisbursementDate: " + getStrActualDisbursementDate();
    }
}
