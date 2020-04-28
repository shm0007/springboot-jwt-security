package com.ehsan.jwtScaffolder.endpoint;


import com.ehsan.jwtScaffolder.model.ErrorResponse;
import com.ehsan.jwtScaffolder.model.LoginRequest;
import com.ehsan.jwtScaffolder.model.RegistrationRequest;
import com.ehsan.jwtScaffolder.model.SignInResponse;
import com.ehsan.jwtScaffolder.security.AuthEntryPointJwt;
import com.ehsan.jwtScaffolder.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping(value = "/api/auth")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthEntryPointJwt.class);

    @Autowired
    UserService userService;

    @PostMapping(value = "/register")
    public ResponseEntity<?> registerUser(@RequestBody RegistrationRequest request){
        logger.info("Register Request {}",request);
        Object obj = userService.registerUser(request);
        if( obj instanceof ErrorResponse)
            return ResponseEntity.badRequest().body(obj);
        return ResponseEntity.ok(obj);
    }
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody @Valid LoginRequest request){
        logger.info("Login Request {}" , request);
        SignInResponse response = userService.checkAndLoginUser(request);
        logger.info("Login Response {}" , response);

        return ResponseEntity.ok(response);

    }
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity uploadFile(@RequestParam MultipartFile[] files) {
        for (int i = 0; i < files.length; i++) {
            logger.info(String.format("File name '%s' uploaded successfully.", files[i].getOriginalFilename()));
        }
        return ResponseEntity.ok().build();
    }
    @RequestMapping("/download")
    public ResponseEntity downloadFile1(@RequestParam String fileName) throws IOException {

        File file = new File(fileName);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .contentLength(file.length())
                .body(resource);
    }

}
