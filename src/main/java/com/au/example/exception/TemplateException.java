package com.au.example.exception;

/**
 * Created by Ayhan Ugurlu - (ayhan.ugurlu@odc.com.tr) on 13.09.2017.
 */
public abstract class TemplateException extends  Exception{

    public abstract  int getHttpStatusCode();

    public abstract  String getErrorCode();

    public abstract  String[] getApiErrors();

}
