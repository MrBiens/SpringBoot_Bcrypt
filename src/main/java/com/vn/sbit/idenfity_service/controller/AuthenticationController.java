package com.vn.sbit.idenfity_service.controller;

import com.vn.sbit.idenfity_service.dto.ApiResponse;
import com.vn.sbit.idenfity_service.dto.request.AuthenticationRequest;
import com.vn.sbit.idenfity_service.dto.response.AuthenticationResponse;
import com.vn.sbit.idenfity_service.exception.ErrorCode;
import com.vn.sbit.idenfity_service.service.AuthenticationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor // tao construct de autowired
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class AuthenticationController {
    AuthenticationService authenticationService;

    @PostMapping("/log-in")
    public ApiResponse<AuthenticationResponse> authenticationApiResponse(@RequestBody AuthenticationRequest request){
        ErrorCode result=authenticationService.Authenticate(request);//true or false
        return ApiResponse.<AuthenticationResponse>builder().code(result.getCode()).message(result.getMessage())
                .result(AuthenticationResponse.builder()//result sẽ có 1 đối tượng kiểu AuthenticationResponse
                        .authenticated(result) //
                        .build())
                         /*-- Builder
                         AuthenticationResponse authResponse = AuthenticationResponse.builder() //Bắt đầu quá trình xây dựng một đối tượng AuthenticationResponse.
                                 .authenticated(result) // Thiết lập thuộc tính authenticated -(true or false vì property của class là boolean)
                                 .build();// Tạo đối tượng AuthenticationResponse hoàn chỉnh
                         */
                .build();

    }


}
