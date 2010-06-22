package com.appspot.mail;

//import javax.persistence.Id;

public class StoredMessage {

  private /*@Id*/
  Long id;
  private String sender;
  private String subject;
  private Object content;

  public StoredMessage() {
  }

  public StoredMessage(String sender, String subject, Object content) {
    this.sender = sender;
    this.subject = subject;
    this.content = content;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getAddress() {
    return sender;
  }

  public void setAddress(String address) {
    this.sender = address;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public Object getContent() {
    return content;
  }

  public void setContent(Object content) {
    this.content = content;
  }
}
