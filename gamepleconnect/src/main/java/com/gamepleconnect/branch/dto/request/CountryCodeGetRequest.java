package com.gamepleconnect.branch.dto.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CountryCodeGetRequest {

    @NotBlank()
    private String ip;

    @Builder
    public  CountryCodeGetRequest(String ip) {
        this.ip = ip;
    }
}
