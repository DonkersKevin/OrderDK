package donkers.kevin.orderdk.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoSuchCustomerException.class)
    protected void customerNotFoundException(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value(), "No customer by that id...");
    }

    @ExceptionHandler(UnauthorizedException.class)
    protected void UnauthorizedException(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value(), "No customer by that id...");
    }

    @ExceptionHandler(UnknownUserException.class)
    protected void unknownUserException(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value(), "Username unknown...");
    }

    @ExceptionHandler(WrongPassWordException.class)
    protected void wrongPasswordException(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value(), "Wrong password...");
    }

}
