package com.appspot.mail;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReceiveMailServlet extends HttpServlet {

  private static final long serialVersionUID 
      = -7871699848446235625L;

  protected void doPost(HttpServletRequest request, 
          HttpServletResponse response)
      throws ServletException, IOException {
    StoredMessage received = readRequestMessage(request);
    storeMessage(received);
  }

  private StoredMessage readRequestMessage(HttpServletRequest 
      request) throws ServletException, IOException {

    Properties props = new Properties();
    Session session = Session.getDefaultInstance(props, null);

    try {
      MimeMessage receivedMessage = new MimeMessage(session, request
          .getInputStream());

      String subject = receivedMessage.getSubject();
      String sender = readSender(receivedMessage);
      Object content = readMessage(receivedMessage);

      return new StoredMessage(sender, subject, content);

    } catch (MessagingException e) {
      throw new ServletException(e);
    }
  }

  private Object readMessage(MimeMessage receivedMessage)
      throws MessagingException, IOException, ServletException {

    Object multipartObject = receivedMessage.getContent();

    if (multipartObject instanceof MimeMultipart) {
      MimeMultipart multipart = (MimeMultipart) multipartObject;
      BodyPart bodypart = multipart.getBodyPart(0);
      return bodypart.getContent();
    }
    return null;
  }

  private String readSender(MimeMessage receivedMessage)
      throws ServletException, MessagingException {
    try {
      Address[] addresses = receivedMessage.getFrom();

      if (addresses.length > 0) {
        return addresses[0].toString();
      }
      return "";
    } catch (AddressException e) {
      throw new ServletException(e);
    }
  }

  private void storeMessage(StoredMessage message) {
   // @TODO Fix
    /* ObjectifyService.register(StoredMessage.class);
    Objectify objectify = ObjectifyService.begin();
    objectify.put(message);*/
  }

}
