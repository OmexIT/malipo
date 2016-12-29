package com.omexit.paymentbridge.core.util;

import com.omexit.paymentbridge.core.util.exception.ResourceNotFoundException;
import com.omexit.paymentbridge.core.util.exception.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.NoResultException;
import javax.validation.ConstraintViolationException;

/**
 * The BaseController class implements common functionality for all Controller
 * classes. The <code>@ExceptionHandler</code> methods provide a consistent
 * response when Exceptions are thrown from <code>@RequestMapping</code>
 * Controller methods.
 *
 * @author Matt Warman
 */
public abstract class BaseController {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final String API_PATH = "/v1";
    protected final String USER_URL = API_PATH + "/user";
    protected final String GET_USER_URL = API_PATH + "/user/{id}";
    protected final String UPDATE_USER_URL = API_PATH + "/user/{id}";
    protected final String PAYMENT_URL = API_PATH + "/payment";
    protected final String GET_PAYMENT_URL = API_PATH + "/payment/{id}";
    protected final String PAYMENT_CALLBACK_URL = API_PATH + "/payment/{paymentId}/callback";
    protected final String PAYMENT_HOOK = API_PATH + "/payment-hook";

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Exception> handleConstraintViolationException(
            ConstraintViolationException cre) {
        logger.error("> handleConstraintViolationException");
        logger.error("- ConstraintViolationException: ", cre);
        logger.error("< handleConstraintViolationException");
        return new ResponseEntity<Exception>(HttpStatus.BAD_REQUEST);
    }


    /**
     * Handles JPA NoResultExceptions thrown from web service controller
     * methods. Creates a response with an empty body and HTTP status code 404,
     * not found.
     *
     * @param nre A NoResultException instance.
     * @return A ResponseEntity with an empty response body and HTTP status code
     * 404.
     */
    @ExceptionHandler(NoResultException.class)
    public ResponseEntity<Exception> handleNoResultException(
            NoResultException nre) {
        logger.error("> handleNoResultException");
        logger.error("- NoResultException: ", nre);
        logger.error("< handleNoResultException");
        return new ResponseEntity<Exception>(HttpStatus.NOT_FOUND);
    }

    /**
     * Handles all Exceptions not addressed by more specific
     * <code>@ExceptionHandler</code> methods. Creates a response with the
     * Exception detail in the response body as JSON and a HTTP status code of
     * 500, internal server error.
     *
     * @param e An Exception instance.
     * @return A ResponseEntity containing a the Exception attributes in the
     * response body and a HTTP status code 500.
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<RestError> handleException(Exception e) {
        logger.error("- Exception: ", e);
//        logger.error("< handleException");
        RestError error = new RestError(HttpStatus.INTERNAL_SERVER_ERROR.value(), 500, "Error occurred in the server",
                null, e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Handles HttpMessageNotReadableException Exceptions not addressed by more specific
     * <code>@ExceptionHandler</code> methods. Creates a response with the
     * Exception detail in the response body as JSON and a HTTP status code of
     * 500, internal server error.
     *
     * @param e An Exception instance.
     * @return A ResponseEntity containing a the Exception attributes in the
     * response body and a HTTP status code 500.
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public ResponseEntity<RestError> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        logger.error("- HttpMessageNotReadableException: ", e);
//        logger.error("< handleException");
        RestError error = new RestError(HttpStatus.BAD_REQUEST.value(), 1002, "Request not readable",
                e.getMessage(), e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ValidationException.class)
    @ResponseBody
    public ResponseEntity<RestError> handleValidationException(ValidationException e) {
        logger.error("- ValidationException: " + e.getMessage());

        RestError error = new RestError(HttpStatus.BAD_REQUEST.value(), 1002, "Request validation errors",
                e.getMessage(), e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseBody
    public ResponseEntity<RestError> handleRetailerNotFoundException(ResourceNotFoundException e) {
        logger.error("- ResourceNotFoundException: " + e.getMessage());

        RestError error = new RestError(HttpStatus.NOT_FOUND.value(), 1002, "Resource not found",
                e.getMessage(), e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }


}
