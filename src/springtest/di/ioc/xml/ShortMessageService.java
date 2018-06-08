package springtest.di.ioc.xml;

public interface ShortMessageService {
	/**
	 * 向phoneNumber手机号发送短信message
	 * @param phoneNumber
	 * @param message
	 */
	void send(String phoneNumber, String message);
}
