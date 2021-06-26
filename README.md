# jCPLib
A simple Java library that consists of just the Java class ConfigParser.java, which you can use to easily write and read configuration files for you project. It is an extension of the HashMap class and just needs to be put into your project and it will be ready to use.

## How To Use
There are two ways to use this library:

1. You can put the java file directly into your project and use it from there
2. You can install the jar file into your IDE as a library, I can't give you an exact guide on this, as installing liberaries differs depending on which IDE you use.

After installing, you need to import the class jcplib.ConfigParser and you're ready to go.

The class has a couple of methods:

- All of the default methods of the HashMap class
- write(): Saves the current keys and values of the ConfigParser object into the config file
- read(): Gets the keys and values of the config file into the ConfigParser object
- Getter and Setter methods

Here is an example of how to use this class:

```java
import jcplib.ConfigParser;

public class ConfigParserTest {
  static ConfigParser cp;

  public static void main(String[] args) {
    cp = new ConfigParser("config/settings.cfg", '#'); //Initialize Config Parser
    
    cp.put("exampleKey","exampleValue"); //Puts a key and its corresponding value into the ConfigParser object
    
    cp.write(); //Saves Keys And Values Into Config File
    cp.read(); //Gets Keys And Values From Config File
  }
```

In the config file it is going to look like this:

```
exampleKey#exampleValue
```
