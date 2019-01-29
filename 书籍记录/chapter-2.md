# 入门
As of Spring version 5.0.0.RELEASE, Spring comes with 21 modules, packaged into 21 JAR files. Table 2-1 describes these JAR files and their corresponding modules. The actual JAR file name is, for example, spring-aop-5.0.0.RELEASE.jar, though we have included only the specific module portion for simplicity (as in aop, for example).

## Table 2-1. Spring modules
    |Module |Description|
    |------ |------------|  
    |aop    |This module contains all the classes you need to use Spring’s AOP features withinyour application. You also need to include this JAR in your application if youplan to use other features in Spring that use AOP, such as declarative transaction management. Moreover, classes that support integration with AspectJ are packed inthis module.|
    |aspects| This module contains all the classes for advanced integration with the AspectJ AOPlibrary. For example, if you are using Java classes for your Spring configuration andneed AspectJ-style annotation-driven transaction management, you will need thismodule.|
    |beans  |This module contains all the classes for supporting Spring’s manipulation of Springbeans. Most of the classes here support Spring’s bean factory implementation. Forexample, the classes required for processing the Spring XML configuration file and Java annotations are packed into this module.beans-groovy This module contains Groovy classes for supporting Spring’s manipulation ofSpring beans.|
    |context| This module contains classes that provide many extensions to Spring Core. You will find that all classes need to use Spring’s ApplicationContext feature (covered in Chapter 5), along with classes for Enterprise JavaBeans (EJB), Java Naming and Directory Interface (JNDI), and Java Management Extensions (JMX) integration. Also contained in this module are the Spring remoting classes, classes for integration with dynamic scripting languages (for example, JRuby, Groovy, and BeanShell), JSR-303 (Bean Validation), scheduling and task execution, and so on. context-indexer This module contains an indexer implementation that provides access to the candidates that are defined in META-INF/spring.components. The core class CandidateComponentsIndex is not meant to be used externally. context-support This module contains further extensions to the spring-context module. On the user-interface side, there are classes for mail support and integration with templating engines such as Velocity, FreeMarker, and JasperReports. Also, integration with various task execution and scheduling libraries including CommonJ and Quartz are packaged here.|
    |core   |This is the main module that you will need for every Spring application. In this JAR file, you will find all the classes that are shared among all other Spring modules (for example, classes for accessing configuration files). Also, in this JAR, you will find selections of extremely useful utility classes that are used throughout the Spring codebase and that you can use in your own application.|
    |expression |This module contains all support classes for Spring Expression Language (SpEL). instrument This module includes Spring’s instrumentation agent for JVM bootstrapping. This JAR file is required for using load-time weaving with AspectJ in a Spring application.|
    |dbc |This module includes all classes for JDBC support. You will need this module for all applications that require database access. Classes for supporting data sources, JDBC data types, JDBC templates, native JDBC connections, and so on, are packed in this module.|
    |jms |This module includes all classes for JMS support.|
    |messaging |This module contains key abstractions taken from the Spring Integration project to serve as a foundation for message-based applications and adds support for STOMP messages.|
    |orm |This module extends Spring’s standard JDBC feature set with support for popular ORM tools including Hibernate, JDO, JPA, and the data mapper iBATIS. Many of the classes in this JAR depend on classes contained in the spring-jdbc JAR file, so you definitely need to include that in your application as well.|
    |oxm |This module provides support for Object/XML Mapping (OXM). Classes for the abstraction of XML marshalling and unmarshalling and support for popular tools such as Castor, JAXB, XMLBeans, and XStream are packed into this module.|
    |test |Spring provides a set of mock classes to aid in testing your applications, and many of these mock classes are used within the Spring test suite, so they are well tested and make testing your applications much simpler. Certainly we have found great use for the mock HttpServletRequest and HttpServletResponse classes in unit tests for our web applications. On the other hand, Spring provides a tight integration with the JUnit unit-testing framework, and many classes that support the development of JUnit test cases are provided in this module; for example, SpringJUnit4ClassRunner provides a simple way to bootstrap the Spring ApplicationContext in a unit test environment.|
    |tx |This module provides all classes for supporting Spring’s transaction infrastructure. You will find classes from the transaction abstraction layer to support the Java Transaction API (JTA) and integration with application servers from major vendors.|
    |web |This module contains the core classes for using Spring in your web applications, including classes for loading an ApplicationContext feature automatically, file upload support classes, and a bunch of useful classes for performing repetitive tasks such as parsing integer values from the query string.|
    |web-reactive |This module contains core interfaces and classes for Spring Web Reactive model.|
    |web-mvc |This module contains all the classes for Spring’s own MVC framework. If you are using a separate MVC framework for your application, you won’t need any of the classes from this JAR file. Spring MVC is covered in more detail in Chapter 16.|
    |websocket |This module provides support for JSR-356 (Java API for WebSocket).|

# 模拟BeanFactory
    public class MessageSupportFactory {
    	private static MessageSupportFactory instance;
    	private Properties props;
    	private MessageRenderer renderer;
    	private MessageProvider provider;
	    private MessageSupportFactory() {
	    props = new Properties();
	    try {
	    props.load(this.getClass().getResourceAsStream("/msf.properties"));
		    String rendererClass = props.getProperty("renderer.class");
		    String providerClass = props.getProperty("provider.class");
		    renderer = (MessageRenderer) Class.forName(rendererClass).newInstance();
		    provider = (MessageProvider) Class.forName(providerClass).newInstance();
		    } catch (Exception ex) {
		    	ex.printStackTrace();
		    }
	    }
	    static {
	    	instance = new MessageSupportFactory();
	    }
	    public static MessageSupportFactory getInstance() {
	    	return instance;
	    }
	    public MessageRenderer getMessageRenderer() {
	    	return renderer;
	    }
	    public MessageProvider getMessageProvider() {
	    	return provider;
	    }
    }