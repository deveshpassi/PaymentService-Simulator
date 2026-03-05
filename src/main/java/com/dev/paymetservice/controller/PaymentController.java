package com.dev.paymetservice.controller;

import com.dev.paymetservice.dto.CreatePaymentRequest;
import com.dev.paymetservice.dto.PaymentResponse;
import com.dev.paymetservice.entity.Payment;
import com.dev.paymetservice.service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/payment")
public class PaymentController {

      private final PaymentService paymentService;

      public PaymentController(PaymentService paymentService) {
            this.paymentService = paymentService;
      }

      @PostMapping
      public ResponseEntity<PaymentResponse> createPayment(@RequestHeader("Idempotency-Key") String idempotencyKey, @Valid  @RequestBody CreatePaymentRequest request) {

            Payment payment = paymentService.createPayment(request, idempotencyKey);

            return ResponseEntity.status(HttpStatus.CREATED).body(new PaymentResponse(payment));
      }

      @GetMapping("/{id}")
      public ResponseEntity<PaymentResponse> getPayment(@PathVariable UUID id) {

            Payment payment = paymentService.getPayment(id);

            return ResponseEntity.ok(new PaymentResponse(payment));
      }
}
