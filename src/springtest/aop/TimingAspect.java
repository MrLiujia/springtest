package springtest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect // 声明这是切面
public class TimingAspect {

	@Around("execution(public * springtest.aop.service.*.*(..))") // 选择感兴趣的方法
	public Object timing(ProceedingJoinPoint pjp) throws Throwable { // pjp表示当前被拦截的方法
		long startMs = System.currentTimeMillis();
		
		try {
			Object result = pjp.proceed(); // 让当前被拦截的方法继续
			return result;
		} finally { // 不管有没有异常，都要计时
			long endMs = System.currentTimeMillis();
			System.out.println(String.format("service[%s.%s]耗时%sms", 
					pjp.getTarget().getClass().getSimpleName(), // 被拦截的方法的对象的类名
					pjp.getSignature().getName(), // 被拦截的方法的方法名
					endMs - startMs));
		}
	}
}
