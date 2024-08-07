package com.rest.demo.exception;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeErrorResponse {
    private int status;
    private String message;
    private long timeStamp;

}
