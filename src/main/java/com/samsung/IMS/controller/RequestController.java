package com.samsung.IMS.controller;


import com.samsung.IMS.model.RequestDetailInfoVO;
import com.samsung.IMS.service.RequestService;
import com.samsung.IMS.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "item")
@RequestMapping(value = "/item")
public class RequestController {
    @Autowired
    private RequestService requestService;

    @PostMapping("/borrow")
    public ResponseEntity<Object> requestItem(@RequestBody RequestDetailInfoVO requestDetailInfoVO) throws Exception{
        return new ResponseEntity<>(requestService.requestItem(requestDetailInfoVO), HttpStatus.OK);
    }
}
