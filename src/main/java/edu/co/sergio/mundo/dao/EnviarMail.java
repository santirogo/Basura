package edu.co.sergio.mundo.dao;
import com.sendgrid.*;
import java.io.IOException;


public class EnviarMail {
  public EnviarMail(){
    
  }  
    
  public void enviarMail(String toAdd){
    Email from = new Email("appumartsw@gmail.com");
    String subject = "Hello World from the SendGrid Java Library!";
    Email to = new Email("toAdd");
    Content content = new Content("text/plain", "Hello, Email! <3");
    Mail mail = new Mail(from, subject, to, content);

    SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
    Request request = new Request();
    try {
      request.method = Method.POST;
      request.endpoint = "mail/send";
      request.body = mail.build();
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.body);
      System.out.println(response.headers);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

