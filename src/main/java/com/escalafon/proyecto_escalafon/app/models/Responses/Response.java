package com.escalafon.proyecto_escalafon.app.models.Responses;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Response<T> implements Serializable {
    private String status;

    private String code;

    private String message;

    private T data;

    public Response(String deleted, String code, String message) {
    }
}
