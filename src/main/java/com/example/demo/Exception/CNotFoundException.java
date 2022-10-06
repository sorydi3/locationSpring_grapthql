package com.example.demo.Exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.*;

import org.apache.logging.log4j.message.Message;
import org.springframework.http.HttpStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Dog not found")
public class CNotFoundException extends RuntimeException implements GraphQLError {
    
    public Map<String, Object> extensions = new HashMap<>();

    public CNotFoundException(String message, Object breed) {
        super(message);
        extensions.put(message, breed);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DataFetchingException;
    }

   
    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }
}
