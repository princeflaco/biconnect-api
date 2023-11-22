package br.com.fiap.biconnect.util;

import br.com.fiap.biconnect.models.dtos.response.ErrorResponse;
import br.com.fiap.biconnect.models.dtos.response.SuccessPOST;

public class ResponseUtil {

    private ResponseUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static ErrorResponse createErrorResponse(String message) {
        return ErrorResponse.builder().details(message).build();
    }

    public static SuccessPOST createIdResponse(Long id) {
        return SuccessPOST.builder().id(id).build();
    }
}
