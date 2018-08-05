package com.abhishek.yasma.remote;

import javax.inject.Inject;

public class ApiServiceHelper {

    private final ApiService service;

    @Inject
    public ApiServiceHelper(ApiService service) {
        this.service = service;
    }
}
