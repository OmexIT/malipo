package com.omexit.malipo.paymentbridge.payment;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.omexit.malipo.commonlib.util.DateUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by Antony on 2/9/2016.
 */
@Data
@Entity(name = "outgoing")
@EqualsAndHashCode(callSuper = false)
public class OutgoingPayment extends Payment {

    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = DateUtil.DEFAULT_DATE_FORMAT)
    @JsonProperty("disbursement_date")
    @Column(name = "disbursement_date", nullable = false)
    private Date actualDisbursementDate;
}
