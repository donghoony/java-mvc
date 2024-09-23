package com.techcourse.controller;

import com.interface21.context.stereotype.Controller;
import com.interface21.web.bind.annotation.RequestMapping;
import com.interface21.web.bind.annotation.RequestMethod;
import com.interface21.webmvc.servlet.ModelAndView;
import com.interface21.webmvc.servlet.view.JspView;
import com.techcourse.domain.User;
import com.techcourse.repository.InMemoryUserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class RegisterController {

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView show(HttpServletRequest request, HttpServletResponse response) {
        JspView jspView = new JspView("/register.jsp");
        return new ModelAndView(jspView);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView save(HttpServletRequest request, HttpServletResponse response) {
        final var user = new User(
                2,
                request.getParameter("account"),
                request.getParameter("password"),
                request.getParameter("email")
        );
        InMemoryUserRepository.save(user);

        JspView jspView = new JspView("redirect:/index.jsp");
        return new ModelAndView(jspView);
    }
}
