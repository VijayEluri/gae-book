package com.appspot.tasks;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.labs.taskqueue.Queue;
import com.google.appengine.api.labs.taskqueue.QueueFactory;
import com.google.appengine.api.labs.taskqueue.TaskOptions;

public class QueueMailTaskServlet extends HttpServlet {

  private static final long serialVersionUID = 
    9026042431554327176L;

  protected void doGet(HttpServletRequest request, 
          HttpServletResponse response)
      throws ServletException, IOException {

    TaskOptions task = TaskOptions.Builder
        .url("/tasks/m")
        .param("recipient", "adriaandejonge+1@gmail.com")
        .param("thread", "Question about JavaMail API")
        .param("url", "http://my-url/post/news-about-javamail")
        .param("message", "What is faster, JavaMail or the\n" +
                "low-level Google API?\n" +
                "\n" +
                "Kind regards,\n" +
                "\n" +
                "Me.");
    Queue queue = QueueFactory.getDefaultQueue();
    queue.add(task);
  }
}
