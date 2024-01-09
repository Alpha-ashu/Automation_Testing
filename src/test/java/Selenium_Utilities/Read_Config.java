package Selenium_Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Read_Config {

	Properties pro;

	public Read_Config() {
		File src = new File("./Configuration/Config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception E) {
			System.out.println("Exception is " + E.getMessage());
		}
	}

	public String getApplicationURL() {
		String url = pro.getProperty("baseURL");
		return url;
	}

	public String getUsername() {
		String username = pro.getProperty("username");
		return username;
	}

	public String getPassword() {
		String password = pro.getProperty("password");
		return password;
	}

	public String getChromepath() {
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}

	public String getFirefoxPath() {
		String FirefoxPath = pro.getProperty("FirefoxPath");
		return FirefoxPath;

	}
	public String getIEpath() 
	{
		String iePath = pro.getProperty("iePath");
		return iePath;
		}
}
