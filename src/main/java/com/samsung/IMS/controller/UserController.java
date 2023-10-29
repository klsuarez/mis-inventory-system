package com.samsung.IMS.controller;


import com.samsung.IMS.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "user")
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/equipment")
    public ResponseEntity<Object> getAvailableEquipment() {
        return new ResponseEntity<>(userService.getAvailableItems(), HttpStatus.OK);
    }
}
