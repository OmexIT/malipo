package com.omexit.malipo.paymentbridge.payment;

import com.omexit.malipo.commonlib.types.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by omexic on 7/15/2015.
 */
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Payment findById(Long paymentId);

    @Query("SELECT p from outgoing p where p.actualDisbursementDate <= ?1 and p.paymentStatus = ?2")
    List<Payment> findTransactionsToProcess(Date actualDisbursementDate, PaymentStatus paymentStatus);

    List<Payment> findByDateCreated(Date dateCreated);

    List<Payment> findByLastModified(Date lastModified);

    List<Payment> findByTransactionAmount(Double lastModified);

}
