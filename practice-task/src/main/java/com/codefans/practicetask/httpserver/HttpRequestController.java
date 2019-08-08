package com.codefans.practicetask.httpserver;

import com.alibaba.fastjson.JSON;
import com.codefans.reusablecode.util.SignUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author: mpif
 * @date: 2018-06-06 10:05
 */
@RestController
@RequestMapping("/admin")
public class HttpRequestController {

    @RequestMapping(path = "/queryString", produces = "text/plain")
    public ResponseEntity<String> queryString() {
        String jsonResult = "{\"name\":\"zhangsan\",\"password\":\"123456\"}";
        ResponseEntity<String> entity = ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(jsonResult);
        return entity;
    }

    @PostMapping(path = "/addDomain")
    public ResponseEntity<String> addUser(@ModelAttribute RequestDomain body) {
//        String jsonResult = "{\"name\":\"zhangsan\",\"password\":\"123456\"}";
        String jsonResult = "I am Post method!!! post request content is:[" + body.toString() + "]";
        ResponseEntity<String> entity = ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(jsonResult);
        return entity;
    }

    @GetMapping(path = "/queryGetString")
    public ResponseEntity<String> queryGetString(@RequestParam(value = "username", required = true) String username,
                                                 @RequestParam(value = "password", required = true) String password) {
        String jsonResult = "welcome to get method!!! get request content is:[" + username + "," + password + "]";
        ResponseEntity<String> entity = ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(jsonResult);
        return entity;
    }

    @RequestMapping(path = "/set/{username}-{password}", method={RequestMethod.GET})
    public ResponseEntity<String> set(@PathVariable String username, @PathVariable String password) {
        String jsonResult = "path variable username:[" + username + "], password:[" + password + "]";
        ResponseEntity<String> entity = ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(jsonResult);
        return entity;
    }

    @PostMapping(path = "/faceDetect")
    public ResponseEntity<String> faceDetect(@ModelAttribute Map<String, Object> paramMap) {
        String jsonResult = "I am Post method!!! post request content is:[" + JSON.toJSONString(paramMap) + "]";

        boolean validateSuccess = SignUtils.validateSignature(paramMap);
        jsonResult = jsonResult + ", validate result:[" + validateSuccess + "]";

        ResponseEntity<String> entity = ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(jsonResult);
        return entity;
    }

    @RequestMapping(path = "/http/test", method={RequestMethod.GET})
    public ResponseEntity<String> test(HttpServletRequest req, HttpServletResponse resp) {

        String jsonResult = "";

        Map<String, String> headMaps = this.parseHeader(req);
        this.printMap(headMaps);

        String userAgent = headMaps.get("User-Agent");
        if(userAgent == null) {
            userAgent = headMaps.get("user-agent");
            jsonResult = "head, [user-agent]:" + userAgent;
        } else {
            jsonResult = "head:[user-agent]:" + userAgent;
        }

        ResponseEntity<String> entity = ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(jsonResult);
        return entity;
    }

    public Map<String, String> parseHeader(HttpServletRequest request) {
        Map<String, String> headMaps = new HashMap<String, String>();
        Enumeration<String> headNames = request.getHeaderNames();
        String headName = "";
        while(headNames.hasMoreElements()) {
            headName = headNames.nextElement();
            headMaps.put(headName, request.getHeader(headName));
        }
        return headMaps;
    }

    public void printMap(Map<String, String> maps) {
        Iterator<String> iter = maps.keySet().iterator();
        String key = "";
        String val = "";
        while(iter.hasNext()) {
            key = iter.next();
            val = maps.get(key);
            System.out.println("key=" + key + ", val=" + val);
//            log.info("key=" + key + ", val=" + val);
        }
    }

}
