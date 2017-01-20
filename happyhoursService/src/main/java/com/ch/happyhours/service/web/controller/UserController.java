package com.ch.happyhours.service.web.controller;



import com.ch.happyhours.service.Exception.HappyHoursException;
import com.ch.happyhours.service.restclients.RestCLientCallback;
import com.ch.happyhours.service.service.UserService;
import com.ch.happyhours.service.web.dto.UserDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import net.minidev.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@Api(value = "user", description = "Operations with user", produces = "application/json")
@RestController
@RequestMapping("/ws/user")
public class UserController {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Value("${happy-hours.security.authentication.oauth.clientid}")
    private String oauthClientId;

    @Value("${happy-hours.security.authentication.oauth.secret}")
    private String oauthClientSecret;

    @Value("${happy-hours.security.authentication.oauth.grant_type}")
    private String grant_type;

    @Value("${happy-hours.security.authentication.oauth.scope}")
    private String scope;

    @Inject
    private UserService userService;

    @Inject
    private RestCLientCallback restCLientCallback;

    @RequestMapping(value = "/authenticate",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Authentification Service")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operation Executed Successfully"),
            @ApiResponse(code = 400, message = "Bad credentials")
    })
    public JSONObject authenticate(@RequestParam(value = "username") String username,
                                   @RequestParam(value = "password") String password) {
        return restCLientCallback.authenticate(oauthClientSecret, oauthClientId, grant_type, scope, username, password).getBody();
    }


    @RequestMapping(value = "/token/refresh",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Refresh Token Service")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operation Executed Successfully"),
            @ApiResponse(code = 401, message = "Bad Token")
    })
    public JSONObject refreshToken(@RequestParam(value = "token") String token) {
        ResponseEntity<JSONObject> responseEntity = restCLientCallback.refreshToken(oauthClientSecret, oauthClientId, "refresh_token", token);
        return responseEntity.getBody();
    }
}
