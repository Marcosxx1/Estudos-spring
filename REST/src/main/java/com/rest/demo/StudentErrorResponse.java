package com.rest.demo;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentErrorResponse {
    private int status;
    private String message;
    private long timeStamp;

}
