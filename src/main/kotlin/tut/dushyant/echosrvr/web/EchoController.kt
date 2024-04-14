package tut.dushyant.echosrvr.web

import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController("/")
class EchoController {

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun get(request: HttpServletRequest): Map<String, Map<String, String>> {
        val headers = request.headerNames.toList().map { headerName ->
            headerName to request.getHeader(headerName)
        }.toMap()
        val params = request.parameterMap.map { (paramName, paramValues) ->
            paramName to paramValues.joinToString(",")
        }.toMap()
        val attributes = request.attributeNames.toList().map { attrName ->
            attrName to request.getAttribute(attrName).toString()
        }.toMap().filter { (key, _) -> !key.startsWith("org.springframework") }
        val retMap = mutableMapOf<String, Map<String, String>>()
        retMap["method"] = mapOf("method" to request.method)
        retMap["path"] = mapOf("path" to request.requestURI)
        retMap["query"] = mapOf("query" to request.queryString)
        retMap["params"] = params
        retMap["attributes"] = attributes
        retMap["headers"] = headers

        return retMap
    }
}