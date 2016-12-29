package com.omexit.paymentbridge.core.channel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.omexit.paymentbridge.core.util.DateUtil;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Antony on 2/10/2016.
 */
@Entity(name = "tbl_channels")
public class Channel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JsonProperty("channel_name")
    @Column(name = "channel_name", length = 50, unique = true, nullable = false)
    private String channelName;
    @JsonProperty("channel_endpoint")
    @Column(name = "channel_endpoint", length = 100, nullable = false)
    private String channelEndpoint;
    @JsonProperty("channel_type")
    @Column(name = "channel_type", nullable = false)
    private ChannelClassificationType channelType;
    @JsonProperty("active")
    @Column(name = "is_active", nullable = false)
    private boolean isActive;
    @JsonProperty("callback")
    @Column(name = "callback", nullable = false)
    private boolean isCallback;
    @JsonIgnore
    @Column(name = "date_created", updatable = false)
    private Date dateCreated;
    @JsonIgnore
    @Column(name = "last_modified")
    private Date lastModified;
    @JsonProperty("max_retry_count")
    @Column(name = "max_retry_count", nullable = false)
    private Integer maxRetryCount;
    @Transient
    @JsonProperty("date_created")
    private String strDateCreated;
    @Transient
    @JsonProperty("last_modified")
    private String strLastModified;

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

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelEndpoint() {
        return channelEndpoint;
    }

    public void setChannelEndpoint(String channelEndpoint) {
        this.channelEndpoint = channelEndpoint;
    }

    public ChannelClassificationType getChannelType() {
        return channelType;
    }

    public void setChannelType(ChannelClassificationType channelType) {
        this.channelType = channelType;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isCallback() {
        return isCallback;
    }

    public void setCallback(boolean callback) {
        isCallback = callback;
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

    public Integer getMaxRetryCount() {
        return maxRetryCount;
    }

    public void setMaxRetryCount(Integer maxRetryCount) {
        this.maxRetryCount = maxRetryCount;
    }


    public String getStrDateCreated() {
        if (this.getDateCreated() != null) {
            strDateCreated = DateUtil.formatDate(this.getDateCreated(), DateUtil.DEFAULT_DATE_FORMAT);
        }

        return strDateCreated;
    }

    public String getStrLastModified()  {
        if (this.getLastModified() != null) {
            strLastModified = DateUtil.formatDate(this.getLastModified(), DateUtil.DEFAULT_DATE_FORMAT);
        }
        return strLastModified;
    }

}
