package com.omexit.malipo.paymentbridge.channel;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.omexit.malipo.commonlib.types.ChannelType;
import com.omexit.malipo.commonlib.util.DateUtil;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Antony on 2/10/2016.
 */
@Data
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
    private ChannelType channelType;
    @JsonProperty("active")
    @Column(name = "is_active", nullable = false)
    private boolean isActive;
    @JsonProperty("callback")
    @Column(name = "callback", nullable = false)
    private boolean isCallback;
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
