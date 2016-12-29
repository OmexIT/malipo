package com.omexit.paymentbridge.core.payment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.omexit.paymentbridge.core.channel.Channel;
import com.omexit.paymentbridge.core.util.DateUtil;
import com.omexit.paymentbridge.core.util.types.ErrorCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Antony on 2/9/2016.
 */
@ToString
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "payment_type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = IncomingPayment.class, name = "incoming"),
        @JsonSubTypes.Type(value = OutgoingPayment.class, name = "outgoing")})
@Entity(name = "tbl_payments")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Payment implements Serializable {
    private static final long serialVersionUID = -5563776068364123492L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JsonIgnore
    @Column(name = "date_created", updatable = false)
    private Date dateCreated;
    @JsonIgnore
    @Column(name = "last_modified")
    private Date lastModified;
    @JsonProperty("tenant_id")
    @Column(name = "tenant_id")
    private String tenantId;
    @JsonProperty("client_id")
    @Column(name = "client_id")
    private Long clientId;
    @JsonProperty("entity")
    @Column(name = "entity", length = 50)
    private String entity;
    @JsonProperty("entity_id")
    @Column(name = "entity_id")
    private Long entityId;
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
    private
    PaymentStatus paymentStatus;
    @Transient
    @JsonProperty("payment_type")
    private
    PaymentType paymentType;
    @JsonProperty("error_code")
    @Column(name = "error_code")
    private ErrorCode errorCode;
    @JsonProperty("status_reason_code_message")
    @Column(name = "status_reason_code_message")
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
    @Transient
    @JsonProperty("date_created")
    private String strDateCreated;
    @Transient
    @JsonProperty("last_modified")
    private String strLastModified;
    @JsonProperty("retry_count")
    @Column(name = "retry_count", nullable = false)
    private Integer retryCount;

    public Payment() {
        this.setPaymentStatus(PaymentStatus.PAYMENT_PENDING);
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @PrePersist
    protected void onCreate() {
        Date date = new Date();
        setDateCreated(date);
        setLastModified(date);
    }

    @PreUpdate
    protected void onUpdate() {
        setLastModified(new Date());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getPaymentAccount() {
        return paymentAccount;
    }

    public void setPaymentAccount(String paymentAccount) {
        this.paymentAccount = paymentAccount;
    }

    public Double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public String getStatusReasonCodeMessage() {
        return statusReasonCodeMessage;
    }

    public void setStatusReasonCodeMessage(String statusReasonCodeMessage) {
        this.statusReasonCodeMessage = statusReasonCodeMessage;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(Integer retryCount) {
        this.retryCount = retryCount;
    }

    public String getStrDateCreated() {
        if (this.getDateCreated()!= null) {
            strDateCreated  = DateUtil.formatDate(this.getDateCreated(), DateUtil.DEFAULT_DATE_FORMAT);
        }

        return strDateCreated;
    }

    public String getStrLastModified() {
        if (this.getLastModified() != null) {
            strLastModified = DateUtil.formatDate(this.getLastModified(), DateUtil.DEFAULT_DATE_FORMAT);
        }
        return strLastModified;
    }
}
