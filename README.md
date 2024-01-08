# REST API

1.for connecting to services we need RESTAPI calls over HTTP. REST- Representational State Transfer -- language independent- can use any data format-- commonly XML and JSON --popular ones-JSON---JavaScript Object Notation
2.REST over HTTP-- REST leverages HTTP methods for CRUD Operations such as GET,POST,PUT,DELETE
3.We use client tool such as POSTMAN for better REST testing.
4.Data binding -- process of converting JSON data to Java POJO[marshalling/unmarshalling,serialization/deserailization,Mapping] which spring uses JACKSON PROJECT behind the scenes for databinding
5.@PathVariable  -- retreive data by using entity informattion --
6.Spring REST Exception Handling : 
     a.create a custom error response class
     b.create a custom exception class
     c.update rest service to throw exception if student not found
     d.Add an exception handler method using @ExceptionHandler where it returns a Response Entity which in turn wrapper for HTTP response Object.
7.implemented expection handler to handle errors during retreival of data
Expection handler is limited to specific rest controller which cant be used by other controllers
8.Global Exception handlers promotes resuse of exception handling and also centralize exception handling. @Con]]]]]]trollerAdvice is similar to filter [Real time use of AOP]
Service Layer::
  Service Design Facade Pattern where it integrates data from multiple sources
  @Service Annotation --applied to service implementation
  In service implementation,leave @Transactional to methods in service layer.
  #architecture
Employee rest controller ---- employee service --  employee DAO--- database 


  Instead of Using JPA API,i ask to use Spring Data JPA - creates DAO form me -plugin my entity type and primary key and give me all of basic CRUD features for free.
  Spring Data JPA provides the interface -- JpaRepository .
  same applies for REST -- add spring-boot-starter-data-rest dependency in xml.
  HATEOAS:
    Hypermedia as the Engine of Application State 
    Spring Data REST  endpoints are HATEOAS compliant. where we contain metadata under links section  in the endpoint.
    @RepositoryRestResource(path="members") custom name to our endpoint path variable
    we can setup base path ,page size and get the data by sorting.
