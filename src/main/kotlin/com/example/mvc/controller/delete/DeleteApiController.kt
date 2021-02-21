package com.example.mvc.controller.delete

import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@RestController
@RequestMapping("/api")
@Validated
class DeleteApiController {

    // 1. path variable
    // 2. request param

    @DeleteMapping(path = ["/delete-mapping"])
    fun deleteMapping(
        @RequestParam(value = "name") _name:String,

        @NotNull(message = "age값이 누락되었습니다.")
        @Min(value = 20, message ="age는 20 보다 커야 합니다.")
        @RequestParam(name = "age") _age:Int
    ): String {
        println(_name)
        println(_age)
        return "$_name $_age"
    }

    @DeleteMapping(path = ["/delete-mapping/name/{name}/age/{age}"])
    fun deleteMappingPath(
        @Size(min = 2, max = 5, message = "name은 2~5")
        @NotNull
        @PathVariable(value = "name") _name:String,

        @NotNull(message = "age값이 누락되었습니다.")
        @Min(value = 20, message ="age는 20 보다 커야 합니다.")
        @PathVariable(name = "age") _age:Int
    ): String {
        println(_name)
        println(_age)

        return "$_name $_age"
    }
}