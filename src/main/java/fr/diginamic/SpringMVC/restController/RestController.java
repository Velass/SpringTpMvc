package fr.diginamic.springmvc.restController;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import fr.diginamic.errordto.ErrorDto;
import fr.diginamic.errordto.InvalidEntityErrorDto;
import fr.diginamic.springmvc.exception.EntityToCreateHasAnIdException;
import fr.diginamic.springmvc.exception.EntityToCreateHasNoIdException;
import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class RestController {
    @ExceptionHandler({ EntityNotFoundException.class })
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ErrorDto handleEntityNotFoundException(Exception exception, WebRequest request) {
        exception.printStackTrace();
        return new ErrorDto(
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now(),
                exception.getMessage(),
                request.getDescription(false));

    }

    @ExceptionHandler({ EntityToCreateHasAnIdException.class, EntityToCreateHasNoIdException.class })
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ErrorDto handleCreateEntityException(Exception exception, WebRequest request) {
        exception.printStackTrace();
        return new ErrorDto(
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now(),
                exception.getMessage(),
                request.getDescription(false));

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto handleValidationException(MethodArgumentNotValidException exception, WebRequest request) {
        exception.printStackTrace();
        return new InvalidEntityErrorDto(exception.getBindingResult());

    }

}
