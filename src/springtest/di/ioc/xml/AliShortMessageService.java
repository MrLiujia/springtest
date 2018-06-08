package springtest.di.ioc.xml;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class AliShortMessageService implements ShortMessageService {

	@Override
	public void send(String phoneNumber, String message) {
		// 此处应该调用阿里云短信服务SDK
		System.out.println(String.format("使用阿里云短信服务发送短信【%s】到【%s】", 
				message, phoneNumber));
	}

}
