package com.dev.paymetservice.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePaymentRequest {

      @NotNull
      private Double amount;

      @NotNull
      private String currency;
}
