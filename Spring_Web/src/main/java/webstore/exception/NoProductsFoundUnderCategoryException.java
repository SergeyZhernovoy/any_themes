package webstore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Sergey Zhernovoy
 * create on 26.10.2017.
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No found product under this category")
public class NoProductsFoundUnderCategoryException extends RuntimeException {
    private static final long serialVersionUID = -8128019905115223407L;
}
