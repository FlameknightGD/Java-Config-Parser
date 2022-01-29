# Java-Config-Parser
A simple Java class, based on the HashMap class, that can be used to easily write and read configuration files for you projects. In order to use it, just put the file into your project and you're ready to go!

## How To Use
1. Add the ConfigParser.java file to your project
2. Change the "com.flameknightgd.examplePackage;" within the file to whatever the name of the package, where the class is located, is
3. Import it into the class you want to use it in

The methods, included in this class, are as follows:

- All of the default methods of the HashMap class
- write(): Writes down the keys and the values, currently held by the ConfigParser object into your config file
- read(): Reads the keys and values of your config file and adds them into the ConfigParser object
- Getter and Setter methods

Here is an example of how to use this class:

```java
import com.flameknightgd.examplePackage;

public class ConfigParserTest {
  static ConfigParser cp;

  public static void main(String[] args) {
    cp = new ConfigParser("config/settings.cfg", '#'); //Initialize Config Parser
    
    cp.put("exampleKey","exampleValue"); //Puts a key and a corresponding value into the ConfigParser object
    
    cp.write(); //Saves Keys And Values Into Config File
    cp.read(); //Gets Keys And Values From Config File
  }
```

This is how it would look like in the config file:

```
exampleKey#exampleValue
```
