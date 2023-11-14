package fr.diginamic.errordto;

import java.time.LocalDateTime;

public class ErrorDto {
    private LocalDateTime date;
    private String message;
    private String url;


    public LocalDateTime getDate() {
        return date;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    
}