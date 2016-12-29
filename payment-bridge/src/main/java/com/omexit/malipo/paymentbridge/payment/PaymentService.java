package com.omexit.malipo.paymentbridge.payment;


import com.omexit.malipo.commonlib.types.PaymentStatus;

import java.util.Date;
import java.util.List;

/**
 * Created by Antony on 2/12/2016.
 */
public interface PaymentService {
    List<Payment> findAllPayments();

    Payment saveOrUpdatePayment(Payment payment);

    Payment findPaymentById(Long id);

    List<Payment> findTransactionsToProcess(Date actualDisbursementDate, PaymentStatus paymentStatus);
}
