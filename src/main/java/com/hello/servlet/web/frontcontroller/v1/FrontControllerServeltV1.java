package com.hello.servlet.web.frontcontroller.v1;

import com.hello.servlet.web.frontcontroller.v1.contoller.MemberFormControllerV1;
import com.hello.servlet.web.frontcontroller.v1.contoller.MemberListControllerV1;
import com.hello.servlet.web.frontcontroller.v1.contoller.MemberSaveControllerV1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name="frontControllerServeltV1", urlPatterns = "/front-controller/v1/*")
public class FrontControllerServeltV1 extends HttpServlet {

    private Map<String, ControllerV1> controllerMap = new HashMap<>();

    public FrontControllerServeltV1() {
        controllerMap.put("/front-controller/v1/members/new-form", new MemberFormControllerV1());
        controllerMap.put("/front-controller/v1/members/save", new MemberSaveControllerV1());
        controllerMap.put("/front-controller/v1/members", new MemberListControllerV1());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FrontControllerServeltV1.service");
        String requestURI = request.getRequestURI();

        ControllerV1 controllerV1 = controllerMap.get(requestURI);

        if (controllerV1 == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        controllerV1.process(request, response);


    }
}
