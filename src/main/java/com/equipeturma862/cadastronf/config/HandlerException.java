package com.equipeturma862.cadastronf.config;

import com.equipeturma862.cadastronf.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.util.List;

    @RestControllerAdvice
    public class HandlerException {

        @ExceptionHandler({AgenciaNotFound.class})
        @ResponseStatus(HttpStatus.NOT_FOUND)
        public APIError handlerExceptionAgenciaNotFound(Exception exception) {
            APIError apiError = APIError.builder()
                    .message(exception.getMessage())
                    .code("ERROR0001")
                    .build();
            return apiError;
        }
        @ExceptionHandler({NotaFiscalNotFound.class})
        @ResponseStatus(HttpStatus.NOT_FOUND)
        public APIError handlerExceptionNotaFiscalNotFound(Exception exception) {
            APIError apiError = APIError.builder()
                    .message(exception.getMessage())
                    .code("ERROR0002")
                    .build();
            return apiError;
        }

        @ExceptionHandler({FuncionarioNotFound.class})
        @ResponseStatus(HttpStatus.NOT_FOUND)
        public APIError handlerExceptionFuncionarioNotFound(Exception exception) {
            APIError apiError = APIError.builder()
                    .message(exception.getMessage())
                    .code("ERROR0003")
                    .build();
            return apiError;
        }

        @ExceptionHandler({RemetenteNotFound.class})
        @ResponseStatus(HttpStatus.NOT_FOUND)
        public APIError handlerExceptionRemetenteNotFound(Exception exception) {
            APIError apiError = APIError.builder()
                    .message(exception.getMessage())
                    .code("ERROR0004")
                    .build();
            return apiError;
        }
        @ExceptionHandler({AgenciaExists.class})
        @ResponseStatus(HttpStatus.CONFLICT)
        public APIError handlerExceptionAgenciaExists(Exception exception) {
            APIError apiError = APIError.builder()
                    .message(exception.getMessage())
                    .code("ERROR0005")
                    .build();
            return apiError;
        }

        @ExceptionHandler({FuncionarioExists.class})
        @ResponseStatus(HttpStatus.CONFLICT)
        public APIError handlerExceptionFuncionarioExists(Exception exception) {
            APIError apiError = APIError.builder()
                    .message(exception.getMessage())
                    .code("ERROR0006")
                    .build();
            return apiError;
        }
        @ExceptionHandler({NotaFiscalExists.class})
        @ResponseStatus(HttpStatus.CONFLICT)
        public APIError handlerExceptionNotaFiscalExists(Exception exception) {
            APIError apiError = APIError.builder()
                    .message(exception.getMessage())
                    .code("ERROR0007")
                    .build();
            return apiError;
        }
        @ExceptionHandler({RemetenteExists.class})
        @ResponseStatus(HttpStatus.CONFLICT)
        public APIError handlerExceptionRemetenteExists(Exception exception) {
            APIError apiError = APIError.builder()
                    .message(exception.getMessage())
                    .code("ERROR0008")
                    .build();
            return apiError;
        }

        @ExceptionHandler({RequisicaoNotFound.class})
        @ResponseStatus(HttpStatus.NOT_FOUND)
        public APIError handlerExceptionRequisicaoNotFound(Exception exception) {
            APIError apiError = APIError.builder()
                    .message(exception.getMessage())
                    .code("ERROR0009")
                    .build();
            return apiError;
        }

        @ExceptionHandler({TipoNaturezaNotFound.class})
        @ResponseStatus(HttpStatus.NOT_FOUND)
        public APIError handlerExceptionTipoNaturezaNotFound(Exception exception) {
            APIError apiError = APIError.builder()
                    .message(exception.getMessage())
                    .code("ERROR0010")
                    .build();
            return apiError;
        }

        @ExceptionHandler({FileNotFound.class})
        @ResponseStatus(HttpStatus.NOT_FOUND)
        public APIError handlerExceptionFileNotaFiscalNotFound(Exception exception) {
            APIError apiError = APIError.builder()
                    .message(exception.getMessage())
                    .code("ERROR0011")
                    .build();
            return apiError;
        }
        @ExceptionHandler({ValidationRequired.class})
        @ResponseStatus(HttpStatus.NOT_FOUND)
        public APIError handlerExceptionValidationRequired(Exception exception) {
            APIError apiError = APIError.builder()
                    .message(exception.getMessage())
                    .code("ERROR0012")
                    .build();
            return apiError;
        }

        @ExceptionHandler({FuncionarioSolicitante.class})
        @ResponseStatus(HttpStatus.NOT_FOUND)
        public APIError handlerExceptionFuncionarioSolicitante(Exception exception) {
            APIError apiError = APIError.builder()
                    .message(exception.getMessage())
                    .code("ERROR0013")
                    .build();
            return apiError;
        }
        @ExceptionHandler(MaxUploadSizeExceededException.class)
        public APIError handleMaxSizeException(MaxUploadSizeExceededException exc) {
            return APIError.builder().message("File too large!").build();
        }

        @ExceptionHandler({MethodArgumentNotValidException.class})
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        public APIError handlerExceptionValidation(MethodArgumentNotValidException exception) {

            List<FieldErrorDTO> errors = exception.getAllErrors().stream().map(error -> {
                FieldError fieldError = (FieldError) error;
                return FieldErrorDTO.builder().name(fieldError.getField())
                        .error(fieldError.getDefaultMessage()).build();
            }).toList();

            APIError apiError = APIError.builder()
                    .message("Validation failed for argument")
                    .code("ERROR0000")
                    .error(errors)
                    .build();
            return apiError;
        }
    }

