# Java-ConfigParser
A simple tool that consists of just one Java class, which you can use to easily write and read configuration files for you project. It is an extension of the HashMap class and just needs to be put into your project and it will be ready to use.

## How To Use
The Config Parser has a couple of methods:

- All of the default methods of the HashMap class
- write(): Saves the current keys and values of the ConfigParser object into the config file
- read(): Gets the keys and values of the config file into the ConfigParser object
- Getter and Setter methods

Here is an example of how to use this class:

```java
public class ConfigParserTest {
  File configFile;
  ConfigParser configParser;

  public static void main(String[] args) {
    this.configFile = new File("config/config.cfg"); //Initialize Config File
    this.configParser = new ConfigParser(this.configFile); //Initialize Config Parser
    
    this.configParser.put("exampleValue01","14"); //Puts Key And Value Into ConfigParser Object
    this.configParser.put("exampleValue02","23"); //Puts Key And Value Into ConfigParser Object
    
    this.configParser.write(); //Saves Keys And Values Into Config File
    this.configParser.read(); //Gets Keys And Values From Config File
  }
```

In the config file it is going to look like this:

```
exampleValue01=14
exampleValue02=23
```
