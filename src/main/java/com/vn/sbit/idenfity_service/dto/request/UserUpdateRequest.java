package com.vn.sbit.idenfity_service.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
@Data//lombok -Thay cho getter , setter , tostring.....
@NoArgsConstructor //constructor không tham số
@AllArgsConstructor // constructor có tham số
@Builder // bắt buộc phải có all constuctor ( builder có thể dùng tham số tùy chọn mà không phải tạo constructor tương ứng)
@FieldDefaults(level = AccessLevel.PRIVATE) // thay cho Access Modifier - private,(tùy theo level) ;

public class UserUpdateRequest {

     String passWord;

     String firstName;

     String lastName;

     LocalDate dob;




}
