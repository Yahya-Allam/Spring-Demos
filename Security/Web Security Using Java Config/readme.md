# Web Secuirty Using Java Configuration:
Replace the traditional way of confugring "Spring Security" using xml files with a java configuration class.
### Some notes about migration form XML to Java Configuration class:
  1. In order to config spring security using annotaion :
    combine Spring IOC container and Spring MVC IOC container into one, in other words, do not use "ContextLoaderListener" in web.xml or the corresponding java class, otherwise you will get the following exception message :
    "NoSuchBeanDefinitionException: No bean named 'springSecurityFilterChain' available".
    
  2. If you add delegating filter in web.xml along with the class SpringSecurityInitializer class the
    following exception message will be thrown : "Duplicate Filter registration for 'springSecurityFilterChain' ".
    
### Features:
  1. A Java configuration class instead of XML configurations.
  2. Different Roles with handled different permissions.
  3. Custom login form.
  4. Remember me.
  5. Custom logout form.
  6. Maximum conccurent sessions.
    
  
