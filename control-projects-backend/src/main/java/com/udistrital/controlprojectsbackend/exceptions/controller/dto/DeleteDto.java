package com.udistrital.controlprojectsbackend.exceptions.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class DeleteDto {

    private String message;
    private Boolean isDeleted;
}
