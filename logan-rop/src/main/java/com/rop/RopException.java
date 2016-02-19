
package com.rop;

/**
 * <pre>
 *   ROP的异常。
 * </pre>
 */
public class RopException extends RuntimeException {
    public RopException() {
    }

    public RopException(String message) {
        super(message);
    }

    public RopException(String message, Throwable cause) {
        super(message, cause);
    }

    public RopException(Throwable cause) {
        super(cause);
    }
}

