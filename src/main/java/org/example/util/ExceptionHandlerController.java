package org.example.util;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(SubmitFailedException.class)
    public String handleException(Model model) {

        model.addAttribute("success", false);
        return "new-order-result";
    }
}
