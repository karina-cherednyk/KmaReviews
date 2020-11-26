package com.moop.kmareviews.server_side.exceptions;

import java.util.List;

public class NotUniqueNameException extends Throwable {
    List<String> names;

    public NotUniqueNameException(List<String> t) {
        names = t;
    }
    public List<String> getNames() {
        return names;
    }
}


