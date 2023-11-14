package fr.diginamic.springmvc.errordto;

import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.stream.Collectors;

public class InvalidEntityErrorDto extends ErrorDto {
    private List<String> globalErrors;
    private List<String> fieldErrors;

    public InvalidEntityErrorDto(BindingResult bindingResult) {
        super(400, null, "erreur validation", null);

        this.globalErrors = bindingResult.getGlobalErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.toList());

        this.fieldErrors = bindingResult.getFieldErrors()
                .stream()
                .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
                .collect(Collectors.toList());
    }

    public List<String> getGlobalErrors() {
        return globalErrors;
    }

    public List<String> getFieldErrors() {
        return fieldErrors;
    }
}