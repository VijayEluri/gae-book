package com.appspot.template;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;

public class StringTemplateServlet extends HttpServlet {

  private static final long serialVersionUID = -7897709050363917514L;
  


  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    long startTime = System.currentTimeMillis();

    // StringTemplate hello = new StringTemplate("Hello, $name$");

    StringTemplateGroup group = new StringTemplateGroup("xhtml",
        "WEB-INF/templates/xhtml");
    StringTemplate hello = group.getInstanceOf("hello-world");
    hello.setAttribute("name", "World");
    response.getWriter().write(hello.toString());

    long diff = System.currentTimeMillis() - startTime;
    response.getWriter().write("time: " + diff);

  }
}
