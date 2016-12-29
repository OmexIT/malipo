package com.omexit.malipo.paymentbridge.payment;

import com.omexit.malipo.commonlib.types.PaymentStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Antony on 2/12/2016.
 */
@Service
public class PaymentServiceImpl  implements PaymentService {

    private final PaymentRepository paymentRepository;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public List<Payment> findAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment saveOrUpdatePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payment findPaymentById(Long id) {
        return paymentRepository.findById(id);
    }

    @Override
    public List<Payment> findTransactionsToProcess(Date actualDisbursementDate, PaymentStatus paymentStatus) {
        return paymentRepository.findTransactionsToProcess(actualDisbursementDate, paymentStatus);
    }
}
