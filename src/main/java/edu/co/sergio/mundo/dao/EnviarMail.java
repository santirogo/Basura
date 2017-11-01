package edu.co.sergio.mundo.dao;
import com.sendgrid.*;
import com.sendgrid.Request;
import com.sendgrid.Response;
import java.io.IOException;

public class EnviarMail {
  public void sendMail(String toAdd) throws IOException {
    Email from = new Email("appumartsw@gmail.com");
    String subject = "Sending with SendGrid is Fun";
    Email to = new Email(toAdd);
      System.out.println("asss"+toAdd);
    Content content = new Content("text/plain", "and easy to do anywhere, even with Java");
    Mail mail = new Mail(from, subject, to, content);

    SendGrid sg = new SendGrid(System.getenv("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"));
    Request request = new Request();
//    try {
//      request.setMethod(Method.GET);
//      request.setEndpoint("mail/send");
//      request.setBody(mail.build());
//      Response response = sg.api(request);
//      System.out.println(response.getStatusCode());
//      System.out.println(response.getBody());
//      System.out.println(response.getHeaders());
//    } catch (IOException ex) {
//      throw ex;
//    }
  }
}

