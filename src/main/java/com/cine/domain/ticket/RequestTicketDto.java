package com.cine.domain.ticket;

import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;

@Data
public class RequestTicketDto {

    @DecimalMin("1")
    private int funcionid;

    @NotBlank(message = "usuario es requerido")
    private String usuario;

    @DecimalMin(value = "1", message = "cantidad es requerida")
    private int cantidad;
}