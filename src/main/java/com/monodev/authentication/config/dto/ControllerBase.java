package com.monodev.authentication.config.dto;

import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import java.util.Collection;
import java.net.URI;
public class ControllerBase extends ActionResult {
    private @Nullable Object data;
    private @Nullable Integer numItems;
    
    public ControllerBase() {
    }
    
    public ControllerBase(boolean success, String message, String[] error, String[] errorDetails, int status,
            String location, Object data) {
        super(success, message, error, errorDetails, status, location);
        this.data = data;
        this.numItems = calculateNumItems(data);
    }

    public ControllerBase(boolean success, String message, String[] error, String[] errorDetails, int status, Object data) {
        super(success, message, error, errorDetails, status);
        this.data = data;
        this.numItems = calculateNumItems(data);
    }

    public ControllerBase(boolean success, String message, String[] error, String[] errorDetails, Object data) {
        super(success, message, error, errorDetails);
        this.data = data;
        this.numItems = calculateNumItems(data);
    }

    public ControllerBase(boolean success, String message, Object data) {
        super(success, message);
        this.data = data;
        this.numItems = calculateNumItems(data);
    }

    public ControllerBase(boolean success, Object data) {
        super(success);
        this.data = data;
        this.numItems = calculateNumItems(data);
    }

    public ControllerBase(boolean success, Object data, String message, HttpStatus status) {
        super(success, message, status);
        this.data = data;
        this.numItems = calculateNumItems(data);
    }

    public ControllerBase(boolean success, Object data, String message, HttpStatus status, String location) {
        super(success, message, null, null, status.value(), location);
        this.data = data;
        this.numItems = calculateNumItems(data);
    }
  
    public static  ControllerBase ok( @Nullable String message) {
        return new ControllerBase(true, null, message, HttpStatus.OK);
    } public static <T> ControllerBase ok(T data) {
        return new ControllerBase(true, data, null, HttpStatus.OK);
    }

    public static <T> ControllerBase ok(@Nullable T data, @Nullable String message) {
        return new ControllerBase(true, data, message, HttpStatus.OK);
    }

    public static <T> ControllerBase created(@Nullable T data, @Nullable String message, @Nullable URI location) {
        return new ControllerBase(true, data, message, HttpStatus.CREATED, location!=null?location.toString():null);
    }
    public static ControllerBase created( @Nullable String message, @Nullable URI location) {
        return new ControllerBase(true, null, message, HttpStatus.CREATED, location!=null?location.toString():null);
    }
    public static  ControllerBase created(  @Nullable URI location) {
        return new ControllerBase(true, null, "recurso creado ", HttpStatus.CREATED, location!=null?location.toString():null);
    }

    public static <T> ControllerBase internalServerError(@Nullable T data, @Nullable String message) {
        return new ControllerBase(false, data, message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static <T> ControllerBase badRequest(@Nullable T data, @Nullable String message) {
        return new ControllerBase(false, data, message, HttpStatus.BAD_REQUEST);
    }
    public static ActionResult badRequest(String message,String[] errorDetails) {
        return new ActionResult(false, message, null, errorDetails, HttpStatus.BAD_REQUEST.value());
    }
     

    public static <T> ControllerBase unauthorized(@Nullable T data, @Nullable String message) {
        return new ControllerBase(false, data, message, HttpStatus.UNAUTHORIZED);
    }

    public static <T> ControllerBase forbidden(@Nullable T data, @Nullable String message) {
        return new ControllerBase(false, data, message, HttpStatus.FORBIDDEN);
    }

    public static <T> ControllerBase conflict(@Nullable T data, @Nullable String message) {
        return new ControllerBase(false, data, message, HttpStatus.CONFLICT);
    }

    public static <T> ControllerBase notImplemented(@Nullable T data, @Nullable String message) {
        return new ControllerBase(false, data, message, HttpStatus.NOT_IMPLEMENTED);
    }

    public static <T> ControllerBase serviceUnavailable(@Nullable T data, @Nullable String message) {
        return new ControllerBase(false, data, message, HttpStatus.SERVICE_UNAVAILABLE);
    }

    public static <T> ControllerBase gatewayTimeout(@Nullable T data, @Nullable String message) {
        return new ControllerBase(false, data, message, HttpStatus.GATEWAY_TIMEOUT);
    }

    public static <T> ControllerBase methodNotAllowed(@Nullable T data, @Nullable String message) {
        return new ControllerBase(false, data, message, HttpStatus.METHOD_NOT_ALLOWED);
    }

    public static <T> ControllerBase preconditionFailed(@Nullable T data, @Nullable String message) {
        return new ControllerBase(false, data, message, HttpStatus.PRECONDITION_FAILED);
    }

   
    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public @Nullable Integer getNumItems() {
        return numItems;
    }

    public void setNumItems(@Nullable Integer numItems) {
        this.numItems = numItems;
    }

    // Método para calcular el número de elementos de la colección
    private Integer calculateNumItems(@Nullable Object data) {
        if (data instanceof Collection<?>) {
            return ((Collection<?>) data).size();
        } else if (data instanceof Object[]) {
            return ((Object[]) data).length;
        } else if (data instanceof Iterable<?>) {
            int count = 0;
            for (@SuppressWarnings("unused") Object item : (Iterable<?>) data) {
                count++;
            }
            return count;
        } else {
            return null;
        }
    }

   
}