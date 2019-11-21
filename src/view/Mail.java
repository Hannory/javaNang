package view;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail {
	public static void sendEmail() {
		SignUp su = new SignUp();
		
		String user = "jvnmaster";
		String password = "Dnsdudwk123@";
		
		Properties p = new Properties();
		p.put("mail.smtp.host", "smtp.gmail.com");
		p.put("mail.smtp.port", 465);
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.ssl.enable", "true");
		p.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		
		Session session = Session.getDefaultInstance(p, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});
		
		
		try {
			MimeMessage m = new MimeMessage(session);
			m.setFrom(new InternetAddress(user));
			
			//수신자 메일주소
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(su.emailtf.getText()));
			
			//메일 제목
			m.setSubject("java.nang E-mail 인증");
			
			m.setText("HelloWorld");
			
			//이메일 전송
			Transport.send(m); 
			System.out.println("발송 완료");
			
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	/*public static void sendEmail() {
		SignUp su = new SignUp();
		
		Properties p = new Properties();
		p.put("mail.smtp.user", "jvnmaster@gmail.com");
		p.put("mail.smtp.host", "smtp.gmail.com");
		p.put("mail.smtp.port", "465");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.debug", "true");
		p.put("mail.smtp.socketFactory", "465");
		p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		//p.put("mail.smtp.socketFactory.fallback", "false");
		
		
		try {
			Authenticator auth = new senderAccount();

			Session session = Session.getDefaultInstance(p, auth);
			session.setDebug(true);
			
			MimeMessage msg = new MimeMessage(session);
			
			msg.setSubject("java.nang e-mail 인증");
			Address fromAdd = new InternetAddress("jvnmaster@gmail.com");
			
			msg.setFrom(fromAdd);
			Address toAdd = new InternetAddress(su.emailtf.getText());
			
			msg.addRecipient(Message.RecipientType.TO, toAdd);
			msg.setContent("HelloWorld", "text/plain;charset=KSC5601");
			
			Transport.send(msg);
			System.out.println("발송 완료");
		} catch (Exception e) {	
			e.printStackTrace();
		}
		
		
		

	}
	
	private static class senderAccount extends javax.mail.Authenticator{
		public PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication("jvnmaster", "Dnsdudwk123@");
		}
	}*/
      /*public static String emailAddress;
      public static String[] returnNum = new String[4];
      
   public void getEmailAddress(String email) {
      String[] args1 = {" "};
      emailAddress = email;
   }
   
   public static void main(String[] args){
      SignUp sl = new SignUp();
      
      String host = "smtp.gmail.com";
      final String user = "jvnmaster";
      final String password = "Dnsdudwk123@";

      String to = emailAddress;

      // Get the session object
      Properties props = new Properties();
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.auth", "true");

      Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
         protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(user, password);
         }
      });
      
      
      // Compose the message
      try {
         MimeMessage message = new MimeMessage(session);
         message.setFrom(new InternetAddress(user));
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

         // Subject
         message.setSubject("[이메일 인증번호 입니다.]");
         
         int[] arr1 = new int[4];
         arr1[0] = (int)(Math.random() * 10);
         arr1[1] = (int)(Math.random() * 10);
         arr1[2] = (int)(Math.random() * 10);
         arr1[3] = (int)(Math.random() * 10);
         String[] arr2 = new String[4];
         for(int i = 0; i < arr1.length; i++) {
            arr2[i] = String.valueOf(arr1[i]);
            returnNum[i] = arr2[i];
            System.out.print(returnNum[i]);
         }
         
         // Text
         message.setText("임시 비밀번호 입니다. 다음 4자리를 입력하세요. \n" + arr2[0] + arr2[1] + arr2[2] + arr2[3]);
         
         // send the message
         Transport.send(message);
         System.out.println("메세지가 성공적으로 전송되었습니다.");

      } catch (MessagingException e) {
         e.printStackTrace();
      }
      
   }*/
}