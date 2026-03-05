package com.dev.paymetservice.service;

import com.dev.paymetservice.entity.Payment;
import com.dev.paymetservice.entity.PaymentStatus;
import com.dev.paymetservice.repository.PaymentRepository;
import jakarta.transaction.Transactional;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class AsyncPaymentProcessor {

      private final PaymentRepository paymentRepository;

      public AsyncPaymentProcessor(PaymentRepository paymentRepository) {
            this.paymentRepository = paymentRepository;
      }

      @Async
      @Transactional
      public void processPayment(UUID paymentId) {

            Payment payment = paymentRepository.findById(paymentId).orElseThrow();

            payment.setStatus(PaymentStatus.PROCESSING);
            paymentRepository.save(payment);

            try{
                  Thread.sleep(2000);
            }catch(InterruptedException e){
                  Thread.currentThread().interrupt();
            }
            boolean success = new Random().nextBoolean();

            payment.setStatus(success ? PaymentStatus.SUCCESS : PaymentStatus.FAILED);
            paymentRepository.save(payment);

      }
}
