package fr.diginamic.errordto;

import java.time.LocalDateTime;

public class ErrorDto {
    private final int statusCode;
    private final LocalDateTime date;
    private final String message;
    private final String url;



    public ErrorDto(int statusCode, LocalDateTime date, String message, String url) {
        this.statusCode = statusCode;
        this.date = date;
        this.message = message;
        this.url = url;
    }
    public int getStatusCode() {
        return statusCode;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public String getMessage() {
        return message;
    }
    public String getUrl() {
        return url;
    }

    
}