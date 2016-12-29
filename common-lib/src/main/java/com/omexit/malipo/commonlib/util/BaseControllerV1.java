package com.omexit.malipo.commonlib.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Antony Omeri
 */
public abstract class BaseControllerV1 {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final String API_PATH = "/v1";
    //User URL
    protected final String USER_URL = API_PATH + "/user";
    protected final String GET_USER_URL = API_PATH + "/user/{id}";
    protected final String UPDATE_USER_URL = API_PATH + "/user/{id}";
    //Channel URL
    protected final String CHANNEL_URL = API_PATH + "/channel";
    protected final String GET_CHANNEL_URL = API_PATH + "/channel/{id}";
    //Payment URL
    protected final String PAYMENT_URL = API_PATH + "/payment";
    protected final String GET_PAYMENT_URL = API_PATH + "/payment/{id}";
}
