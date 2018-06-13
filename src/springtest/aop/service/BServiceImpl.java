package springtest.aop.service;

import org.springframework.stereotype.Service;

@Service
public class BServiceImpl implements BService {

	@Override
	public void bug() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		// 运行时异常不强制调用者catch
		throw new RuntimeException("故意的");
	}

}
