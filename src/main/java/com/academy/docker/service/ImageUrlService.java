package com.academy.docker.service;

import org.springframework.stereotype.Service;

@Service
public class ImageUrlService {

    public String getUrl(long employeeId) {
        return "https://someserver.org/somefolder/img/emp" + employeeId + ".jpg";
    }

}
