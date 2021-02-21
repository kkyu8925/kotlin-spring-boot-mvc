package com.example.mvc.model.http

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import java.lang.Exception
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.validation.constraints.*

//@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class UserRequest (

    @field:NotEmpty
    @field:Size(min = 2, max = 8)
    var name:String?=null,

    @field:PositiveOrZero // 0 이상의 숫자 (양수)
    var age:Int?=null,

    @field:Email
    var email:String?=null,

    @field:NotBlank
    var address:String?=null,

//    @JsonProperty("phone_number")
    @field:Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}\$")  // 정규식 검증
    var phoneNumber:String?=null, // phone_number

    var createAt:String?=null // yyy-MM-dd NN:mm:ss
){
    @AssertTrue(message = "생성일자 패턴 yyy-MM-dd NN:mm:ss")
    private fun isValiCreateAt():Boolean{ // 정상 true, 비정상 false

        return try{
            LocalDateTime.parse(this.createAt, DateTimeFormatter.ofPattern("yyyy-MM-dd NN:mm:ss"))
            true
        } catch (e:Exception) {
            false
        }
    }
}