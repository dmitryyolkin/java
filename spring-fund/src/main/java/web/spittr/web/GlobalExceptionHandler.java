package web.spittr.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (13.06.18)
 */

// controller advise means that this handler will be used for all controllers of the application
// there is no need in annotating this controller with @Component because @ControllerAdvice
// is marked with @Component itself
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = DuplicateEntryException.class)
    private String handleDuplicateException() {
        return "error/duplicate";
    }

}
