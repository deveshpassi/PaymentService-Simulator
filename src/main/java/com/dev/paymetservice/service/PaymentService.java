package com.dev.paymetservice.service;

import com.dev.paymetservice.dto.CreatePaymentRequest;
import com.dev.paymetservice.entity.Payment;
import com.dev.paymetservice.entity.PaymentStatus;
import com.dev.paymetservice.repository.PaymentRepository;
import jakarta.transaction.Transactional;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PaymentService {

      private final PaymentRepository paymentRepository;
      private final AsyncPaymentProcessor asyncPaymentProcessor;

      public PaymentService(PaymentRepository paymentRepository, AsyncPaymentProcessor asyncPaymentProcessor) {
            this .paymentRepository = paymentRepository;
            this.asyncPaymentProcessor = asyncPaymentProcessor;
      }

      @Transactional
      public Payment createPayment(CreatePaymentRequest request, String idempotencyKey) {

            Optional<Payment> existing = paymentRepository.findByIdempotencyKey(idempotencyKey);

            if (existing.isPresent()) {
                  return existing.get();
            }
            Payment payment = new Payment();
            payment.setAmount(request.getAmount());
            payment.setIdempotencyKey(idempotencyKey);
            payment.setCurrency(request.getCurrency());
            payment.setStatus(PaymentStatus.CREATED);

            try {
                paymentRepository.save(payment);
            } catch (DataIntegrityViolationException e) {
                  return paymentRepository.findByIdempotencyKey(idempotencyKey).orElseThrow();
            }
            asyncPaymentProcessor.processPayment(payment.getId());

            return payment;
      }
      public Payment getPayment(UUID paymentId) {
            return  paymentRepository.findById(paymentId).orElseThrow(()-> new RuntimeException("Payment not found"));
      }
}
