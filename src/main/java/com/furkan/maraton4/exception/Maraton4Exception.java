package com.furkan.maraton4.exception;

import lombok.Getter;

@Getter
public class Maraton4Exception extends RuntimeException{
    private final EErrorType EErrorType;

    /**
     * Runtime dan miras aldığımız için hata mesajının kendisine iletilmesi gereklidir.
     * @param EErrorType
     */
    public Maraton4Exception(EErrorType EErrorType){
        super(EErrorType.getMessage());
        this.EErrorType = EErrorType;
    }

    public Maraton4Exception(EErrorType EErrorType, String message){
        super(message);
        this.EErrorType = EErrorType;
    }
}
