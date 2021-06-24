package configParser;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.HashMap;

/**
 * A simple tool based off the HashMap class that can be used to easily write
 * and read configuration files of your Java project. You can find my other
 * projects at github.com/FlameknightGD.
 * 
 * @version v1.0.1
 * @author FlameknightGD
 * @see java.util.HashMap
 */

public class ConfigParser extends HashMap<String, String> {
	// Global Variables

	/**
	 * Serial Version UID that is used as an identifier for the ConfigParser class.
	 * 
	 * @since v1.0.0
	 */
	private static final long serialVersionUID = 5979389544685269824L;

	/**
	 * The file that is going to be used by the ConfigParser to save and read
	 * information.
	 *
	 * @since v1.0.0
	 */
	File configFile;

	// Constructors

	/**
	 * Constructer for the ConfigParser class using the actual file.
	 * 
	 * @param configFile The file that is going to be used by the ConfigParser to
	 *                   save and read information
	 * @since v1.0.0
	 */
	public ConfigParser(File configFile) {
		setConfigFile(configFile);
	}

	/**
	 * Constructer for the ConfigParser class using the file path.
	 * 
	 * @param filePath The path of the file that is going to be used by the
	 *                 ConfigParser to save and read information.
	 * @since v1.0.0
	 */
	public ConfigParser(String filePath) {
		setConfigFile(new File(filePath));
	}

	// Main Methods

	/**
	 * Writes the content of the ConfigParser object into an external file.
	 * 
	 * <p>
	 * When called, the method {@link #write()} will start a for each loop to write
	 * each key and its corresponding value into an external file, using a
	 * StringBuffer and the global variable '{@link #configFile}'.
	 * 
	 * @throws IOException if the file can't be found
	 * @since v1.0.0
	 * @see java.lang.StringBuffer
	 * @see java.nio.file.Files
	 */
	public void write() throws IOException {
		StringBuffer fileContent = new StringBuffer();
		for (String key : this.keySet()) {
			fileContent.append(key + "=" + this.get(key) + "\n");
		}
		Files.write(configFile.toPath(), fileContent.toString().getBytes());
	}

	/**
	 * Reads the content of the configuration file into the ConfigParser object
	 * 
	 * <p>
	 * When called, the method {@link #read()} will clear the content of the
	 * ConfigParser object and use the Files.readAllBytes method to get the Bytes of
	 * the configuration file and convert said Bytes to a string. This string will
	 * be split with the String.split() method and all keys and their corresponding
	 * values will be added to the ConfigParser object via the put method of the
	 * HashMap class.
	 * 
	 * @throws IOException if the file can't be found
	 * @since v1.0.0
	 * @see java.nio.charset.StandardCharsets
	 * @see java.nio.file.Files
	 */
	public void read() throws IOException {
		this.clear();
		String fileContent = new String(Files.readAllBytes(configFile.toPath()), StandardCharsets.UTF_8);
		for (String line : fileContent.split("\n")) {
			String[] splitLine = line.split("=");
			this.put(splitLine[0], splitLine[1]);
		}
	}

	// Getters

	/**
	 * Gets the currently selected configuration file.
	 * 
	 * @return File that is currently selected by the ConfigParser
	 * @since v1.0.0
	 */
	public File getConfigFile() {
		return this.configFile;
	}

	/**
	 * Gets the path of the currently selected configuration file.
	 * 
	 * @return File that is currently selected by the ConfigParser
	 * @since v1.0.0
	 */
	public String getFilePath() {
		return this.configFile.getPath();
	}

	// Setters

	/**
	 * Sets the file that is being used by the ConfigParser object.
	 * 
	 * @param configFile The file that is going to be used by the ConfigParser to
	 *                   save and read information
	 * @since v1.0.0
	 */
	public void setConfigFile(File configFile) {
		this.configFile = configFile;
	}

	/**
	 * Sets the path of the file that is being used by the ConfigParser object.
	 * 
	 * @param filePath The path of the file that is going to be used by the
	 *                 ConfigParser to save and read information
	 * @since v1.0.1
	 */
	public void setFilePath(String filePath) {
		this.configFile = new File(filePath);
	}
}
