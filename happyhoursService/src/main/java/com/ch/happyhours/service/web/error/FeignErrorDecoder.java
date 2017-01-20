package com.ch.happyhours.service.web.error;

import feign.FeignException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by Chemakh on 30/12/2016.
 */
@Service
public class FeignErrorDecoder implements ErrorDecoder {

    private Logger logger = LoggerFactory.getLogger(FeignErrorDecoder.class);


    @Override
    public Exception decode(String methodKey, Response response) {

        FeignException ex= FeignException.errorStatus(methodKey, response);
        logger.error("FeignException : ",ex.getMessage());
        return ex;
    }
}
