package web.spittr.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (13.06.18)
 */
@ResponseStatus(
        code = HttpStatus.BAD_REQUEST,
        reason = "Entry is already exists"
)
public class DuplicateEntryException extends RuntimeException{
}
