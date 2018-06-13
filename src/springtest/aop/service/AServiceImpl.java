package springtest.aop.service;

import org.springframework.stereotype.Service;

@Service
public class AServiceImpl implements AService {

	@Override
	public int plus(int a, int b) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		
		int result = a + b;
		return result;
	}

}
