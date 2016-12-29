package com.omexit.malipo.paymentbridge.payment;

import com.fasterxml.jackson.annotation.*;
import com.omexit.malipo.commonlib.types.ErrorCode;
import com.omexit.malipo.commonlib.types.PaymentStatus;
import com.omexit.malipo.commonlib.types.PaymentType;
import com.omexit.malipo.commonlib.util.DateUtil;
import com.omexit.malipo.paymentbridge.channel.Channel;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Antony on 2/9/2016.
 */
@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "payment_type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = IncomingPayment.class, name = "incoming"),
        @JsonSubTypes.Type(value = OutgoingPayment.class, name = "outgoing")})
@Entity(name = "tbl_payments")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Payment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JsonProperty("client_id")
    @Column(name = "client_id")
    private Long clientId;
    @JsonProperty("action")
    @Column(name = "action", length = 50)
    private String action;
    @JsonProperty("payment_account")
    @Column(name = "payment_account", length = 100)
    private String paymentAccount;
    @JsonProperty("transaction_amount")
    @Column(name = "transaction_amount")
    private Double transactionAmount;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "channel_id")
    private Channel channel;
    @Transient
    @JsonProperty("channel_name")
    private String channelName;
    @JsonProperty("payment_status")
    @Column(name = "payment_status")
    private PaymentStatus paymentStatus;
    @Transient
    @JsonProperty("payment_type")
    private PaymentType paymentType;
    @JsonProperty("error_code")
    @Column(name = "error_code")
    private ErrorCode errorCode;
    @JsonProperty("status_reason_code_message")
    @Transient
    private String statusReasonCodeMessage;
    @JsonProperty("currency")
    @Column(name = "currency")
    private String currency;
    @JsonProperty("external_id")
    @Column(name = "external_id", length = 50)
    private String externalId;
    @JsonProperty("description")
    @Column(name = "description")
    private String description;
    @JsonProperty("retry_count")
    @Column(name = "retry_count", nullable = false)
    private Integer retryCount;
    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = DateUtil.DEFAULT_DATE_FORMAT)
    @JsonProperty("date_created")
    @Column(name = "date_created", updatable = false, nullable = false)
    private Date dateCreated;
    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = DateUtil.DEFAULT_DATE_FORMAT)
    @JsonProperty("last_modified")
    @Column(name = "last_modified", nullable = false)
    private Date lastModified;

    @PrePersist
    protected void onCreate() {
        Date date = new Date();
        this.dateCreated = date;
        this.lastModified = date;
    }

    @PreUpdate
    protected void onUpdate() {
        this.lastModified = new Date();
    }

}
