package springtest.di.ioc.xml;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
//@Primary // 当有多个组件实现了ShortMessageService时，该组件优先使用
public class DummyShortMessageService implements ShortMessageService {

	@Override
	public void send(String phoneNumber, String message) {
		System.out.println(String.format("模拟发送短信【%s】到【%s】", 
				message, phoneNumber));
	}

}
