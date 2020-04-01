package io.beid;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JSResponse<T> {

    public final String code;
    public final String message;
    public final T t;

}
