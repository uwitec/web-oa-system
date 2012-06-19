package com.oa.dao.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.oa.dao.inf.OaQuestionDaoInf;

public class QuestionnaireTest {
	public static String[] path = {"applicationContext.xml","applicationContext-questionnaire.xml"};
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(path);
		OaQuestionDaoInf questionDaoInf = (OaQuestionDaoInf) applicationContext.getBean("questionDaoId");
		System.out.println(questionDaoInf);
		questionDaoInf.selectIdQuestion(12);
	}

}
