package configParser;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.HashMap;

public class ConfigParser extends HashMap<String, String> {
	// Global Variables

	/**
	 * Serial Version UID that is used as an identifier for the ConfigParser class
	 */
	private static final long serialVersionUID = 5979389544685269824L;

	/**
	 * Serial Version UID that is used as an identifier for the ConfigParser class
	 */
	File configFile;

	// Constructors

	/**
	 * Constructer for the ConfigParser class using java.io.File
	 * 
	 * @param File 'configFile' - The file that is going to be used by the
	 *             ConfigParser to save and read information
	 */
	public ConfigParser(File configFile) {
		setConfigFile(configFile);
	}

	/**
	 * Constructer for the ConfigParser class using a String as the file path
	 * 
	 * @param String 'filePath' - The path of the file that is going to be used by
	 *               the ConfigParser to save and read information
	 */
	public ConfigParser(String filePath) {
		setConfigFile(new File(filePath));
	}

	// Main Methods

	/**
	 * Method used to write the config file with the current keys and values of the
	 * ConfigParser object
	 * 
	 * @throws IOException if there any are issues with the file
	 */
	public void write() throws IOException {
		StringBuffer fileContent = new StringBuffer();
		for (String key : this.keySet()) {
			fileContent.append(key + "=" + this.get(key) + "\n");
		}
		Files.write(configFile.toPath(), fileContent.toString().getBytes());
	}

	/**
	 * Method used to read a specific value of the config file with the current keys
	 * and values of the ConfigParser object
	 * 
	 * @throws IOException if there are any issues with the file
	 */
	public void read() throws IOException {
		this.clear();
		String fileContent = new String(Files.readAllBytes(configFile.toPath()), StandardCharsets.UTF_8);
		for (String line : fileContent.split("\n"))
        {
			String[] splitLine = line.split("=");
			this.put(splitLine[0], splitLine[1]);
        }
	}

	// Getters

	/**
	 * Method to get the file that is being used by the ConfigParser to save and
	 * read information
	 * 
	 * @return File that is currently selected by the ConfigParser
	 */
	public File getConfigFile() {
		return this.configFile;
	}

	/**
	 * Method to get the file that is being used by the ConfigParser to save and
	 * read information
	 * 
	 * @return File that is currently selected by the ConfigParser
	 */
	public String getFilePath() {
		return this.configFile.getPath();
	}

	// Setters

	/**
	 * Method to change the file that is being used by the ConfigParser to save and
	 * read information
	 * 
	 * @param File 'configFile' - The file that is going to be used by the
	 *             ConfigParser to save and read information
	 */
	public void setConfigFile(File configFile) {
		this.configFile = configFile;
	}
}
