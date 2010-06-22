package com.appspot.mail;

//import javax.persistence.Id;

/**
 * Low-level alternative to StoredMessage. 
 */
public class StoredLLMessage {

  private /*@Id*/ Long id;
  private String mail;

  public StoredLLMessage() {
  }

  public StoredLLMessage(String mail) {
    this.mail = mail;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

}
