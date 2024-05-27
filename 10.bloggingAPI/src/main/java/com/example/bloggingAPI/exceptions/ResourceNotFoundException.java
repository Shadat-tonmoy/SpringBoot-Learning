package com.example.bloggingAPI.exceptions;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ResourceNotFoundException extends Exception {

    private String entityName;
    private String fieldName;
    private String fieldValue;

    public ResourceNotFoundException(String entityName, String fieldName, String fieldValue) {
        super(entityName + " not found for " + fieldName + " = " + fieldValue);
        this.entityName = entityName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
