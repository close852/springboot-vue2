package com.cjhm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseVO<T> {
    private String message;

    @Builder.Default
    private boolean check = true;
    private T response;

}