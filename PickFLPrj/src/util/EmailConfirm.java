package util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

public class EmailConfirm{
	public String connectEmail(String email){
		
		String to1 = email; // 인증위해 사용자가 입력한 이메일주소
		String host="smtp.naver.com"; // smtp 서버
		String subject = "PickFL 인증정보 전달 메일입니다."; //제목
		String fromName = "PickFL"; //보내는 이름
		String from = "skekkjim@naver.com"; // 보내는 사람 계정
		String authNum = EmailConfirm.authNum(); // 인증번호 난수
		String content = "인증번호는 " + authNum + "입니다."; // 이메일내용
		System.out.println(authNum);
		
		//SMPT이용을 위해 설정해주는 설정값들
		try{
			Properties props=new Properties();
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.host", host);
			props.setProperty
	                       ("mail.smtp.socketFactory.class",
	                        "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.port", 25);
			props.put("mail.smtp.user",from);
			props.put("mail.smtp.auth","true");
			props.put("mail.smtp.ssl.protocols", "TLSv1.2");

			Session mailSession 
	           = Session.getDefaultInstance(props,new javax.mail.Authenticator(){
				    protected PasswordAuthentication getPasswordAuthentication(){
					    return new PasswordAuthentication("skekkjim@naver.com", "");
				}
			});
			
			Message msg = new MimeMessage(mailSession);
			InternetAddress []address1 = {new InternetAddress(to1)};
			msg.setFrom(new InternetAddress(from, MimeUtility.encodeText(fromName, "UTF-8", "B")));
			msg.setRecipients(Message.RecipientType.TO, address1); //받는 사람 설정
			msg.setSubject(subject); // 제목설정
			msg.setSentDate(new java.util.Date()); // 보내는 날짜
			msg.setContent(content, "text/html; charset=UTF-8"); // 내용설정
			
			Transport.send(msg); // 메일보내기
		}catch(MessagingException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return authNum;
	}

//	난수발생
	public static String authNum() {
		StringBuffer buffer = new StringBuffer();
		for(int i = 0; i <= 6; i++) {
			int num = (int)(Math.random()*9 + 1);
			buffer.append(num);
		}
		return buffer.toString();
	}	
}
