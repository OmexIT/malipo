package com.omexit.paymentbridge.core.payment;


import java.util.Date;
import java.util.List;

/**
 * Created by Antony on 2/12/2016.
 */
public interface PaymentService {
    List<Payment> findAllPayments();

    Payment saveOrUpdatePayment(Payment payment);

    Payment findPaymentById(Long id);

    Payment findPaymentIfExist(Long entityId, String tenantId, Long clientId, String entity);

    List<Payment> findTransactionsToProcess(Date actualDisbursementDate, PaymentStatus paymentStatus);
}
