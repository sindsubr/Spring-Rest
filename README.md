# Spring-Rest
Spring-REST Web Service

<h1>REST API</h1><br>
Restful API is an interfce between 2 computer systems use <b><i> to exchange information securely over the internet</b></i>.<br><br>
A RESTful API is <b><i>an architectural style</b></i> for an application program interface (API) that uses <b><i>HTTP requests to access and use data</b></i>. That data can be used to <b>GET, PUT, POST and DELETE </b>data types(requests), which refers to the<b><i> creating, reading, updating and deleting of CRUD operations</b></i> concerning resources<br><br>
A RESTful API -- also referred to as a RESTful web service or REST API -- is based on REpresentational State Transfer (REST), which is an architectural style and approach to communications often used in web services development.<br><br>
Language Independent (Any of JAVA,C#,C++,Python...)<br><br>
Any Data Format (XML,JSON..)<br><br>
JSON widely using..(Collection of Name-Value pair)
<h1></h1>
<h3>Example</h3>
https://openweathermap.org/api,
salesforce platform api,
https://www.programmableweb.com/<br>

<h3>JSON(Java Script Object Notation)</h3>
Language Independent<br>Lightweight data format for storing and exchanging data(plain text)<br>
Eg: <img src = "https://addons.mozilla.org/user-media/previews/full/29/29967.png?modified=1622132517kvU&ust=1670390925159000&source=images&cd=vfe&ved=0CBAQjRxqFwoTCLiAtJ-h5PsCFQAAAAAdAAAAABAW" width="300" height="300"/>
<br>

<h1>JAVA-JSON Data Binding with Jackson</h1>
Data Binding is the process of converting JSON to JAVA POJO and vice versa.<br>
Also Known as Mapping or Serialization/Deserialization or Marshelling/UnMarshelling.<br><br>
Spring uses <b> JACKSON project</b> behind scenes.<br>
JAcKSON handles data binding between JSON and JAVA POJO.<br>
https://github.com/FasterXML/jackson-databind
<br><br>
JACKSON calls <b><i>getters and setters</b></i> on JAVA POJO for converting JAVA to JSON and JSON to JAVA.
<br><br>
<h3>Exception:</h3>UnrecognizedPropertyException
<h4>Solution</h4><b>@JsonIgnoreProperties(ignoreUnknown=true)</b> on java pojo<br>
<h4>MIME</h4>Multiourpose Internet Mail Transfer Protocol.<br>
<h4>Client Tool</h4>Postman,curl..
https://www.getpostman.com<br>
For Json test<br>
https://www.jsontest.com<br>
https://www.jsonplaceholder.typicode.com<br>

<h2></h2>
<h1>Spring REST Support</h1>
Spring web mvc provides support for Spring REST
<h3>Annotations:</h3>
@RestController<br>
@PathVariable<br>
@ExceptionHandler<br>
@ControllerAdvice<br>
@RequestBody<br>
<br>

<h3>pom.xml</h3>
<ol>
<li>spring-webmvc</li>
<li>spring-tx</li>
<li>spring-orm</li>
<li>jackson-databind</li>
<li>hibernate-core</li>
<li>mysql-connector-java</li>
<li>c3p0(com.mchange)</li>
<li>javax.servlet-api</li>
<li>javax.servlet.jsp-api</li>
<li>javax.xml.bind(jaxb-api)</li>
<li>javax.annotation-api ->for @PostConstruct and @PreDestroy</ol>

<h3>Links for Topics:<br>
-----------------</h3>
<ul>
<li><a href="https://github.com/sindsubr/Spring-Rest/tree/main/spring-rest-crm/src/main/java/org/sindu/restapi/restexceptionhandler">Rest Exception handler</a></li>
<li><a href="https://github.com/sindsubr/Spring-Rest/blob/main/spring-rest-crm-security/src/main/java/org/sindu/restapi/config/SpringRestSecurityCustomerConfiguration.java" >Enabling Rest API security based on roles</a></li>
<li><a hre="https://github.com/sindsubr/Spring-Rest/blob/main/spring-rest-crm-client/src/main/java/org/sindu/restapi/service/CustomerServiceRestClientImpl.java">Rest client api to connect/test Rest API</a></li>
<li><a href="https://github.com/sindsubr/Spring-Rest/blob/main/spring-rest-crm-client-security/src/main/java/org/sindu/restapi/service/CustomerServiceRestClientImpl.java"> Rest client security api to connect/test security enabled Rest API</a> </li>
</ul>

<h3>Important Points To Remember:</h3>
<ul> 
<li>RestTemplate to connect from client api to rest api</li>
<li>Basic Authorization enable to connect with security enabled rest api</li>
<li>Clear Auth list after successfull logout processing</li>
https://github.com/sindsubr/Spring-Rest/blob/main/spring-rest-crm-client-security/src/main/java/org/sindu/restapi/controller/LoginController.java
</ul> 

