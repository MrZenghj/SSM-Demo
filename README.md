## SSM-知识点学习
### 关于java日志的学习
### 关于swagger学习
1. swagger了解（cdsn）
https://blog.csdn.net/i6448038/article/details/77622977  

2. swagger配置步骤（springMVC、spring、整合swagger） 
  * **第一步**：依赖配置,在pom中引入相关的依赖
``` java
    <!-- swagger -->
    <dependency>
      <groupId>com.mangofactory</groupId>
      <artifactId>swagger-springmvc</artifactId>
      <version>1.0.2</version>
    </dependency>
    <dependency>
      <groupId>com.mangofactory</groupId>
      <artifactId>swagger-models</artifactId>
      <version>1.0.2</version>
    </dependency>
    <dependency>
      <groupId>com.wordnik</groupId>
      <artifactId>swagger-annotations</artifactId>
      <version>1.3.11</version>
    </dependency>
    <!-- swagger-springmvc dependencies -->
    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-core</artifactId>
      <version>2.5.4</version>
    </dependency>
    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-annotations</artifactId>
      <version>2.5.4</version>
    </dependency>
    <dependency>
      <groupId>com.google.guava</groupId>
      <artifactId>guava</artifactId>
      <version>15.0</version>
    </dependency>
    <dependency>
      <groupId>com.fasterxml</groupId>
      <artifactId>classmate</artifactId>
      <version>1.1.0</version>
    </dependency>
    <!-- swagger end -->
```
  * **第二步**:：SwaggerConfig类的配置,自定义SwaggerConfig类(名字可自取)，引入springSwaggerConfig
  * **第三步**：在SpringMVC.xml配置中添加SwaggerConfig类BEAN
``` java
 <!-- SpringSwaggerConfig 对象的注入 -->
 <bean class="com.mangofactory.swagger.configuration.SpringSwaggerConfig" />
 <!-- 将自定义的swagger配置类加载到spring容器 -->
 <bean class="com.snipe.config.SwaggerConfig" />
```
  * **第四步**：静态资源文件的配置，去官网下载Zip包，或者在github上下载，将dist文件夹下的所有文件的复制到webapp目录下，并配置对应的静态资源过滤。  
https://github.com/swagger-api/swagger-ui（github地址）
``` java
    <SpringMVC 静态资源处理>
    <mvc:resources mapping="/swagger/**" location="/WEB-INF/swagger/"/>
```  
  * **第五步**：修改资源下的index.html代码中url  
例如：url = "http://localhost:8080/SSM-Demo/api-docs"; // http://IP:端口/项目名/api-docs

  * **第六步**：访问swagger url = http://localhost:8080/SSM-Demo/swagger/index.html

3. 遇到的问题  
* SpringMVC与Swagger整合后，在打开的ui页面提示：No operations defined in spec!，并没有显示编写的接口是什么原因  
原因：出现这个问题主要是由于swagger-ui版本问题  
tag v2.2.10 版本以下的才行，如果下载的静态资源版本大于2.2.10就会出现以上述问题。

### 关于异常处理的学习

### 关于Druid学习
1. 介绍和详解
    https://www.cnblogs.com/niejunlei/p/5977895.html
2. 基本步骤
    * 第一步：maven引入jar
    * 第二步：jdbc.properties配置
    * 第三步：spring-mybati.xml中数据源配置
    * 第四步：web.xml引入启用 Web 监控统计功能

2. 遇到的问题  
    
* 数据库---> Access denied for user 'snipe'@'localhost' (using password: YES)  
* 这个问题查看了博客，主要是由于计算机变量username引起的(JVM)。    
解决方案  
* 方案一：将properties文件中的username换成user或其他就字符串就可以成功获取连接访问数据库。  
* 方案二：在Spring配置文件中修改成：<context:property-placeholder location="classpath:/jdbc.properties" system-properties-mode="FALLBACK / NEVER"/>  
添加一个system-properties-mode属性    
该属性有三个值：FALLBACK  默认值，不存在时覆盖    
                NEVER　　 不覆盖
　　　　　　　　OVERRIDE　覆盖

### 关于protobuff学习
博客：https://blog.csdn.net/antgan/article/details/52103966  
