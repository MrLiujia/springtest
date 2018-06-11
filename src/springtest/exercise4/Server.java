package springtest.exercise4;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class Server {
	private String host; // ip，0.0.0.0表示所有网卡
	private Integer port; // 端口，1024以下的端口需要root权限
	
	public Server(Environment env) { // 依赖Environment获取属性文件中的配置
		host = env.getProperty("server.host");
		port = Integer.valueOf(env.getProperty("server.port"));
	}
	
	public void start() {
		String msg = String.format("正在启动服务器（主机：%s，端口：%s）", host, port);
		System.out.println(msg);
	}
}
