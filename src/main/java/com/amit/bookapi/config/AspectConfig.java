package com.amit.bookapi.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
@Aspect
public class AspectConfig {
	Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 *
	 * @param joinPoint
	 * @return
	 * @throws Throwable
	 */


	@Around(value = "execution(* com.amit.bookapi.controllers.*.*(..))")
	public Object applicationLogger(ProceedingJoinPoint joinPoint) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		String methodName = joinPoint.getSignature().getName();
		String className = joinPoint.getTarget().getClass().toString();
		Object[] array = joinPoint.getArgs();
        logger.info("Method " + methodName + " with arguments :"
				+ mapper.writeValueAsString(array) + " invoked of " + className );
		Object object = joinPoint.proceed();
		logger.info("response is :" + mapper.writeValueAsString(object));

		return object;

	}

}
