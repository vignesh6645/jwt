package com.example.demo.Controller;

import com.example.demo.BaseResponse.BaseResponse;
import com.example.demo.DTO.DecodeDto;
import com.example.demo.DTO.EmployeeDTO;
import com.example.demo.DTO.TokenDTO;
import com.example.demo.Serviece.EmployeeServiece;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeServiece employeeServiece;

    @PostMapping("/addemployee")
    public BaseResponse addDetail(@RequestBody EmployeeDTO employeeDTO)
    {
        return employeeServiece.addDetail(employeeDTO);
    }
    @GetMapping("/login")
    public BaseResponse jwt(@RequestBody TokenDTO tokenDto) {
        return employeeServiece.jwt(tokenDto);
    }

    @GetMapping("/decode")
    public BaseResponse decodetoken(@RequestBody DecodeDto decodeDto){
        return employeeServiece.decodetoken(decodeDto);
    }
}
