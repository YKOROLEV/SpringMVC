package exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class UserIdNotFoundException extends RuntimeException {

    public UserIdNotFoundException() {
    }
}