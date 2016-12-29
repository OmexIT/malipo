package com.omexit.paymentbridge.core.channel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Antony on 2/14/2016.
 */
@Service
public class ChannelServiceImpl implements ChannelService {
    @Autowired
    ChannelRepository channelRepository;

    @Override
    public Channel saveOrUpdateChannel(Channel channel) {
        channel = channelRepository.save(channel);
        channel = channelRepository.findById(channel.getId());
        return channel;
    }

    @Override
    public Channel findChannelByChannelName(String channelName) {
        Channel channel = channelRepository.findByChannelName(channelName);


        return channel;
    }

    @Override
    public Channel findchannelbyId(Long channelId) {
        return channelRepository.findById(channelId);
    }

    @Override
    public List<Channel> findAllChannels() {
        return channelRepository.findAll();
    }
}
