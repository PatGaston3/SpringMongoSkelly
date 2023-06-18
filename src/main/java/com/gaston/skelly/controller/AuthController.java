package com.gaston.skelly.controller;

import com.gaston.skelly.model.User;
import com.gaston.skelly.response.BaseResponse;
import com.gaston.skelly.response.BaseResponseBuilder;
import com.gaston.skelly.response.BaseServiceErrorCode;
import com.gaston.skelly.service.Hasher;
import com.gaston.skelly.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthController {

    private final Hasher hasher;
    private final UserService userService;

    public AuthController(Hasher hasher, UserService userService) {
        this.hasher = hasher;
        this.userService = userService;
    }

    // Auth Endpoint to handle bad credentials
    @PostMapping("/failure")
    public ResponseEntity<BaseResponse> badCredentials() {
        log.info("bad credentials request received");
        Map<String, Object> response = new HashMap<>();
        response.put("Error", "Bad Credentials");
        return BaseResponseBuilder.buildErrorResponse(BaseServiceErrorCode.INVALID_CREDENTIALS_ERROR, HttpStatus.UNAUTHORIZED);
    }

    // Auth endpoint to handle successful login
    @PostMapping("/success")
    public ResponseEntity<BaseResponse> success(Principal principal, HttpSession session) {
        log.info("Successful login for user with email: {}", principal.getName());
        HashMap<String, Object> response = new HashMap<>();
        response.put("user", principal.getName());
        response.put("sessionId", session.getId());
        return BaseResponseBuilder.buildSuccessResponse(response);
    }

    // Auth endpoint to handle logout
    @PostMapping("/logout/success")
    public ResponseEntity<BaseResponse> logout() {
        log.info("logout request received");
        return BaseResponseBuilder.buildSuccessResponse("Logout Successful");
    }

    // Auth endpoint to create user
    @PostMapping("/register")
    public ResponseEntity<BaseResponse> register(@RequestBody @Valid User newUser) {
        log.info("register request received. email: {}", newUser.getEmail());

        // set email to lowercase to save in db
        newUser.setEmail(newUser.getEmail().toLowerCase());

        // check if user already exists
        // if user exists, return error
        if (userService.userExists(newUser.getEmail())) {
           return BaseResponseBuilder.buildErrorResponse(BaseServiceErrorCode.EMAIL_ALREADY_EXISTS, HttpStatus.BAD_REQUEST);
        }

        // else create user and return success
        newUser.setPassword(hasher.hashValue(newUser.getPassword()));
        userService.createUser(newUser);
        return BaseResponseBuilder.buildSuccessResponse(newUser, HttpStatus.CREATED);
    }
}
