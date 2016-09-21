package com.example.abetare.thoutside.source;

/**
 * Created by Abetare on 9/19/2016.
 */
public class OutsideSourceException extends Exception {
    public OutsideSourceException() {
    }

    public OutsideSourceException(String detailMessage) {
        super(detailMessage);
    }

    public OutsideSourceException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public OutsideSourceException(Throwable throwable) {
        super(throwable);
    }
}
