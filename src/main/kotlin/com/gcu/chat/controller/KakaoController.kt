package com.gcu.chat.controller

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@RestController
class KakaoController {
    //카카오톡 오픈빌더로 리턴할 스킬 API
    // test API
    @GetMapping("/hello")
    fun hello(): String {
        return "hello"
    }

    //카카오톡 오픈빌더로 리턴할 스킬 API
    @RequestMapping(
        value = ["/kkoChat/v1"],
        method = [RequestMethod.POST, RequestMethod.GET],
        headers = ["Accept=application/json"]
    )
    fun callAPI(
        @RequestBody params: Map<String?, Any?>,
        request: HttpServletRequest?,
        response: HttpServletResponse?
    ): HashMap<String, Any>? {
        val resultJson = HashMap<String, Any>()
        try {
            val mapper = ObjectMapper()
            val jsonInString = mapper.writeValueAsString(params)
            println(jsonInString)

            /* 발화 처리 부분 * */
            val userRequest = params["userRequest"] as HashMap<*, *>?
            val utter = userRequest!!["utterance"].toString().replace("\n", "")
            var rtnStr = ""
            rtnStr = when (utter) {
                "뭐야" -> "코딩32 챗봇입니다."
                "ㅋㅋ" -> "저도 기분이 좋네요"
                else -> "안녕하세요 코딩 32 챗봇입니다."
            }
            /* 발화 처리 끝*/
            val outputs: MutableList<HashMap<String, Any>> = ArrayList()
            val template = HashMap<String, Any>()
            val simpleText = HashMap<String, Any>()
            val text = HashMap<String, Any>()
            text["text"] = rtnStr
            simpleText["simpleText"] = text
            outputs.add(simpleText)
            template["outputs"] = outputs
            resultJson["version"] = "2.0"
            resultJson["template"] = template
        } catch (e: Exception) {
        }
        return resultJson
    }
}