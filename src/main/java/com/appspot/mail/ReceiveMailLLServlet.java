package com.appspot.mail;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Low-level alternative to ReceiveMailServlet. 
 */
public class ReceiveMailLLServlet extends HttpServlet {

  private static final long serialVersionUID = 5658728239701374460L;

  protected void doPost(HttpServletRequest request, 
          HttpServletResponse response)
      throws ServletException, IOException {

    String mail = readMailFromRequest(request);
    StoredLLMessage message = new StoredLLMessage(mail);
    storeMessage(message);
  }

  private String readMailFromRequest(HttpServletRequest request)
      throws IOException {
    BufferedReader reader = request.getReader();
    StringBuffer stringBuffer = new StringBuffer(1000);
    char[] buffer = new char[1024];
    int length = 0;
    while ((length = reader.read(buffer)) > 0) {
      String readData = String.valueOf(buffer, 0, length);
      stringBuffer.append(readData);
    }
    reader.close();
    String result = stringBuffer.toString();
    return result;
  }

  private void storeMessage(StoredLLMessage message) {
    // @TODO Fix
    /*ObjectifyService.register(StoredLLMessage.class);
    Objectify objectify = ObjectifyService.begin();
    objectify.put(message);*/
  }
}
