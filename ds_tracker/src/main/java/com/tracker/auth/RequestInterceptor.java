package com.tracker.auth;

import com.tracker.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

@Component
public class RequestInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object object) throws Exception {
        // In case need to get the JSON Payload from the request
        // Call getBody method
        System.out.println(request.getRequestURI());
        String token = request.getParameter("token");
        Map<String, String> pathVariables = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        String emailId = pathVariables.get("emailId");
         if (userService.validateToken(emailId,token))
             return true;
         else {
             response.setContentType("application/json");
             response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
             return false;
         }
    }


    private String getBody(HttpServletRequest request) throws IOException {
        String body = null;
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
                bufferedReader = request.getReader();
                char[] charBuffer = new char[128];
                int bytesRead = -1;
                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }

        } catch (IOException ex) {
            throw ex;
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    throw ex;
                }
            }
        }
        body = stringBuilder.toString();
        return body;
    }
}