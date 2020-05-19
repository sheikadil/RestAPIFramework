package rough;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.anaaz.api.utilities.MonitoringMail;
import com.anaaz.api.utilities.TestConfig;

public class TestMail {

	static String messageBody;
	public static void main(String[] args) throws AddressException, MessagingException {
		
		try {
			messageBody = "http://"+InetAddress.getLocalHost().getHostAddress()+":8080/job/RestAPIFramework/Extent_20Reports/";
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MonitoringMail mail = new MonitoringMail();
		mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, messageBody);
	}
}
