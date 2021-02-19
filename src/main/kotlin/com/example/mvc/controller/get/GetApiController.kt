package com.example.mvc.controller.get

import com.example.mvc.model.http.UserRequest
import org.springframework.web.bind.annotation.*

@RestController     // REST API Controller 동작
@RequestMapping("/api")
class GetApiController {

    @GetMapping("/hello") // path = ["/abc","/abcd"]
    fun hello(): String {
        return "hello kotlin"
    }

    @RequestMapping(method = [RequestMethod.GET], path = ["/request-mapping"])
    fun requestMapping(): String {
        return "request-mapping"
    }

    @GetMapping("/get-mapping/path-variable/{name}/{age}")
    fun pathVariable(@PathVariable name: String, @PathVariable age: Int): String {
        println("$name, $age")
        return "$name $age"
    }

    @GetMapping("/get-mapping/path-variable2/{name}/{age}")
    fun pathVariable2(@PathVariable(value = "name") _name: String, @PathVariable(name = "age") _age: Int): String {
        val name = "kotlin"

        println("$_name, $_age")
        return "$_name $_age"
    }

    @GetMapping("/get-mapping/query-param")
    fun queryParam(
            @RequestParam(name = "name") name: String,
            @RequestParam(value = "age") age: Int,
    ): String {
        println("$name, $age")
        return "$name $age"
    }

    @GetMapping("/get-mapping/query-param/object")
    fun queryParamObject(userRequest: UserRequest): UserRequest {
        println(userRequest)
        return userRequest
    }

    @GetMapping("/get-mapping/query-param/map")
    fun queryParamMap(@RequestParam map: Map<String,Any>): Map<String, Any> {
        println(map)
        val phoneNumber = map["phone-number"]
        return map
    }
}