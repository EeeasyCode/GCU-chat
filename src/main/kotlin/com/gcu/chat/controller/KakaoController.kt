package com.gcu.chat.controller

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@RestController
class KakaoController {
    //카카오톡 오픈빌더로 리턴할 스킬 API
    @RequestMapping(
        value = ["/kkoChat/v1"],
        method = [RequestMethod.POST, RequestMethod.GET],
        headers = ["Accept=application/json"]
    )
    fun callAPI(
        @RequestBody params: Map<String?, Any?>?,
        request: HttpServletRequest?,
        response: HttpServletResponse?
    ): String {
        try {
            val mapper = ObjectMapper()
            val jsonInString = mapper.writeValueAsString(params)
            println(jsonInString)
            val x = 0
        } catch (e: Exception) {
            println("error: $e")
            return "error"
        }
        return "index"
    }
}