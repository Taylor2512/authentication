package com.monodev.authentication.config.dto;

import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
 
import java.time.LocalDateTime;
import java.time.ZoneId;
 
public class ActionResult {
    private boolean success;
    private LocalDateTime timestamp;
    private LocalDateTime timestampUtc;
    private @Nullable String message;
    private @Nullable String[] error;
    private @Nullable String[] errorDetails;
    private int status;
    private String location;
    public ActionResult() {
    }
    public ActionResult(boolean success, String message,
            String[] error, String[] errorDetails, int status, String location) {
        this.success = success;
        this.timestamp = LocalDateTime.now();
        this.timestampUtc = LocalDateTime.now(ZoneId.of("UTC"));
        this.message = message;
        this.error = error;
        this.errorDetails = errorDetails;
        this.status = status;
        this.location = location;
    }

    public ActionResult(boolean success, String message,
            String[] error, String[] errorDetails, int status) {
        this(success, message, error, errorDetails, status, null);
    }

    public ActionResult(boolean success, String message,
            String[] error, String[] errorDetails) {
        this(success, message, error, errorDetails, 0, null);
    }

    public ActionResult(boolean success, String message) {
        this(success, message, null, null, 0, null);
    }

    public ActionResult(boolean success) {
        this(success, null, null, null, 0, null);
    }

    public ActionResult(boolean success, String message, HttpStatus status) {
        this(success, message, null, null, status.value(), null);    }

    

    public static ActionResult ok() {
        return new ActionResult(true, "Success");
    }

    public static ActionResult created() {
        return new ActionResult(true, "Created");
    }

    public static ActionResult accepted() {
        return new ActionResult(true, "Accepted");
    }

    public static ActionResult noContent() {
        return new ActionResult(true, "No Content");
    }
    public static ActionResult badRequest() {
        return new ActionResult(false, "Bad Request");
    }
    public static ActionResult badRequest(String message) {
        return new ActionResult(false, message);
    }
    /**
     * @param message
     * @param errorDetails
     * @return
     */
    public static ActionResult badRequest(String message,String [] errorDetails) {
        return new ActionResult(false, message, null, errorDetails);
    }

    public static ActionResult unauthorized() {
        return new ActionResult(false, "Unauthorized");
    }
    public static ActionResult unauthorized(String message) {
        return new ActionResult(false, message);
    }
    public static ActionResult forbidden() {
        return new ActionResult(false, "Forbidden");
    }

    public static ActionResult forbidden(String message) {
        return new ActionResult(false, message);
    }
    public static ActionResult notFound() {
        return new ActionResult(false, "Not Found");
    }

    public static ActionResult notFound(String message) {
        return new ActionResult(false, message);
    }
    public static ActionResult conflict() {
        return new ActionResult(false, "Conflict");
    }

    public static ActionResult conflict(String message) {
        return new ActionResult(false, message);
    }
    public static ActionResult preconditionFailed() {
        return new ActionResult(false, "Precondition Failed");
    }

    public static ActionResult preconditionFailed(String message) {
        return new ActionResult(false, message);
    }
    public static ActionResult unsupportedMediaType() {
        return new ActionResult(false, "Unsupported Media Type");
    }
    public static ActionResult unsupportedMediaType(String message) {
        return new ActionResult(false, message);
    }
    public static ActionResult internalServerError() {
        return new ActionResult(false, "Internal Server Error");
    }

    public static ActionResult internalServerError(String message) {
        return new ActionResult(false, message);
    }
    public static ActionResult notImplemented() {
        return new ActionResult(false, "Not Implemented");
    }
    public static ActionResult notImplemented(String message) {
        return new ActionResult(false, message);
    }
    public static ActionResult serviceUnavailable() {
        return new ActionResult(false, "Service Unavailable");
    }

    public static ActionResult serviceUnavailable(String message) {
        return new ActionResult(false, message);
    }
    public static ActionResult gatewayTimeout() {
        return new ActionResult(false, "Gateway Timeout");
    }

    public static ActionResult gatewayTimeout(String message) {
        return new ActionResult(false, message);
    }
    public static ActionResult badGateway() {
        return new ActionResult(false, "Bad Gateway");
    }
    public static ActionResult badGateway(String message) {
        return new ActionResult(false, message);
    }
    public static ActionResult methodNotAllowed() {
        return new ActionResult(false, "Method Not Allowed");
    }

    public static ActionResult methodNotAllowed(String message) {
        return new ActionResult(false, message);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public LocalDateTime getTimestampUtc() {
        return timestampUtc;
    }

    public void setTimestampUtc(LocalDateTime timestampUtc) {
        this.timestampUtc = timestampUtc;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String[] getError() {
        return error;
    }

    public void setError(String[] error) {
        this.error = error;
    }

    public String[] getErrorDetails() {
        return errorDetails;
    }

    public void setErrorDetails(String[] errorDetails) {
        this.errorDetails = errorDetails;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getlocation() {
        return location;
    }

    public void setlocation(String location) {
        this.location = location;
    }
}