package com.example.demo.Serviece;

import com.example.demo.BaseResponse.BaseResponse;
import com.example.demo.DTO.DecodeDto;
import com.example.demo.DTO.EmployeeDTO;
import com.example.demo.DTO.TokenDTO;
import com.example.demo.Entity.Employee;
import com.example.demo.Repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.example.demo.Util.Decode.decode;
import static com.example.demo.Util.GenerateToken.generateToken;



@Service
public class EmployeeServiece {
    @Autowired
    private EmployeeRepository employeeRepository;


    public BaseResponse addDetail(EmployeeDTO employeeDTO)
    {
        Employee dto=new Employee();
        BaseResponse baseResponse=new BaseResponse();
        dto.setEmpName(employeeDTO.getEmpName());
        dto.setEmail(employeeDTO.getEmail());
        dto.setPassword(generateToken(employeeDTO.getPassword()));
        employeeRepository.save(dto);
        baseResponse.setData(dto);
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("success");
        return  baseResponse;
    }


    public BaseResponse jwt(TokenDTO tokenDto) {
        Optional<Employee> empl = employeeRepository.findByEmail(tokenDto.getEmail());
        try {
            if (empl.isPresent()) {
                String jwtt = generateToken(empl.get().getEmail());
                tokenDto.setToken(jwtt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        BaseResponse baseResponse=new BaseResponse();
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("success");
        baseResponse.setData(tokenDto);
        return  baseResponse;
    }

    public BaseResponse decodetoken(DecodeDto decodeDto){
        Optional<Employee>employee = employeeRepository.findByPassword(decodeDto.getPassword());
        try{
            if (employee.isPresent()){
                String jwttt=decode(employee.get().getPassword());
                decodeDto.setToken(jwttt);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        BaseResponse baseResponse=new BaseResponse();
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("success");
        baseResponse.setData(decodeDto);
        return  baseResponse;
    }
}
