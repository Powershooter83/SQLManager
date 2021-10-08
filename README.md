#### SQLManager
This API allows a simple processing of a SQL database. 

#### Installation
To use this API with Maven this repository must be downloaded with version control and then maven -> install.

```xml
    <dependency>
        <groupId>me.prouge</groupId>
        <artifactId>SQLManager</artifactId>
        <version>1.0-SNAPSHOT</version>
    </dependency>
```
#### Documentation
The first thing to do is to create a manager:

```java
Manager sqlManager =  SQLManager.create("HOST", "PORT", "DATABASE", "USERNAME", "PASSWORD");
```

Then you can use the api:
 
```java
sqlManager.createQuery("Your SQL statement");
```

## Authors
- [@Powershooter83](https://www.github.com/Powershooter83)
- [@Grill99](https://www.github.com/Grill99)
## License

[MIT](https://choosealicense.com/licenses/mit/)

  
