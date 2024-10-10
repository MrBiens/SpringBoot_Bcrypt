package com.vn.sbit.idenfity_service.service;

import com.vn.sbit.idenfity_service.dto.request.AuthenticationRequest;
import com.vn.sbit.idenfity_service.exception.AppException;
import com.vn.sbit.idenfity_service.exception.ErrorCode;
import com.vn.sbit.idenfity_service.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class AuthenticationService {
    UserRepository userRepository;

    public ErrorCode Authenticate(AuthenticationRequest request){
        var user =userRepository.findByUserName(request.getUserName()).orElseThrow(()-> new AppException(ErrorCode.USER_NOT_EXISTED));
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
            //xác thực mật khẩu có khớp với mật khẩu đã lưu
        if( passwordEncoder.matches(request.getPassWord(), user.getPassWord())){
            return ErrorCode.AUTHENTICATION_SUCCESS;
        }else{
            return ErrorCode.AUTHENTICATION_NOT_SUCCESS;
        }
    }
}
