package com.mdtlabs.coreplatform.common.exception;

import com.mdtlabs.coreplatform.common.Constants;
import com.mdtlabs.coreplatform.common.MessageValidator;

import java.io.Serial;
import java.util.List;

/**
 * This class is used to handle ServicesException.
 *
 * @author Vigneshkumar Created on 30 Jun 2022
 */
public class ServicesException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 6918269662648545345L;
    private final Integer code;
    private final String message;

    // This is a constructor for the `ServicesException` class that takes an `Integer` code as input.
    // It sets the `code` variable to the input `code` value and sets the `message` variable to the
    // simple name of the `ServicesException` class. This constructor is used to create a
    // `ServicesException` object with a default message that does not include any dynamic parameters.
    public ServicesException(final Integer code) {
        this.code = code;
        this.message = this.getClass().getSimpleName();
    }

    // This is a constructor for the `ServicesException` class that takes an `Integer` code and a
    // `String` message as input. It sets the `code` variable to the input `code` value and uses the
    // `MessageValidator` class to generate a message using the input `code`, the constant
    // `Constants.ERROR`, and the input `message`. The generated message is then stored in the
    // `message` variable. This constructor is used to create a `ServicesException` object with a
    // custom message that does not include dynamic parameters.
    public ServicesException(final Integer code, final String message) {
        this.code = code;
        this.message = MessageValidator.getInstance().getMessage(code.toString(), Constants.ERROR, message);
    }

    // This is a constructor for the `ServicesException` class that takes an `Integer` code and a
    // variable number of `String` parameters as input. It sets the `code` variable to the input `code`
    // value and uses the `MessageValidator` class to generate a message using the input `code`, the
    // constant `Constants.ERROR`, and the `params` array. The generated message is then stored in the
    // `message` variable. This constructor is used to create a `ServicesException` object with a
    // custom message that includes dynamic parameters. The `params` array can have any number of
    // `String` values, which will be used to replace placeholders in the message generated by the
    // `MessageValidator`.
    public ServicesException(final Integer code, final String... params) {
        this.code = code;
        this.message = MessageValidator.getInstance().getMessage(code.toString(), Constants.ERROR, params);
    }

    // This is a constructor for the `ServicesException` class that takes an `Integer` code and a
    // `List` of `String` parameters as input. It sets the `code` variable to the input `code` value
    // and uses the `MessageValidator` class to generate a message using the input `code`, the constant
    // `Constants.ERROR`, and the `params` list. The generated message is then stored in the `message`
    // variable. This constructor is used to create a `ServicesException` object with a custom message
    // that includes dynamic parameters.
    public ServicesException(final Integer code, final List<String> params) {
        this.code = code;
        this.message = MessageValidator.getInstance().getMessage(code.toString(), Constants.ERROR, params);
    }

    /**
     * The function returns an Integer code.
     * 
     * @return An Integer object is being returned. The value of this object is determined by the value
     * of the variable "code".
     */
    public Integer getCode() {
        return code;
    }

    /**
     * This function returns a message.
     * 
     * @return The `getMessage()` method is returning a `String` value, which is stored in the
     * `message` variable.
     */
    @Override
    public String getMessage() {
        return message;
    }

}
