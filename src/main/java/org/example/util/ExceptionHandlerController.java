package org.example.util;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
public class ExceptionHandlerController implements ErrorController {

    @ExceptionHandler(value = Exception.class)
    public String handleException(SubmitFailedException exception, Model model) {

        model.addAttribute("success", false);
        model.addAttribute("errorMessage", exception.getMessage());
        return "new-order-result";
    }

    @Override
    public String getErrorPath() {
        return "error";
    }
}
