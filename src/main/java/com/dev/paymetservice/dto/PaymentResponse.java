package com.dev.paymetservice.dto;

import com.dev.paymetservice.entity.Payment;
import com.dev.paymetservice.entity.PaymentStatus;
import lombok.Getter;

import java.util.UUID;

@Getter
public class PaymentResponse {

      private UUID paymentId;
      private Double amount;
      private String currency;
      private PaymentStatus status;

      public PaymentResponse(Payment payment) {
            this.paymentId = payment.getId();
            this.amount = payment.getAmount();
            this.currency = payment.getCurrency();
            this.status = payment.getStatus();
      }
}
