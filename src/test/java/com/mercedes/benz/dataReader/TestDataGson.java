package com.mercedes.benz.dataReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;






/**
 * @author garima
 * This class is mapped to E2ETestData.json format
 * for data read from json file
 * It reads data in form of objects so easy to use
 * The json file is passed in Test Class using TestNg parameter
 * There could be multiple json files but should adhere to the format to get
 * read by this class
 */
public class TestDataGson {

	Logger log = LoggerFactory.getLogger(TestDataGson.class);


    private static TestDataGson testData;


	String browser;


    String macChromeBinaryPath;


    String linuxChromeBinaryPath;


    String WindowsChromeBinaryPath;


    String environment;




    String browserDefaultLanguage;


    public List<PARAM> getListparam() {
		return listParam;
	}


	public void setListparam(List<PARAM> listparam) {
		this.listParam = listparam;
	}



	List<PARAM> listParam;
	 List<URL> listUrl;



    static class PARAM {


        String key;


        String value;
    }


    static class URL {

        String environment;


        String baseUrl;
    }





 public String getEnvironment() {
		return environment;
	}


	public void setEnvironment(String environment) {
		this.environment = environment;
	}


	public String getMacChromeBinaryPath() {
		return macChromeBinaryPath;
	}


	public void setMacChromeBinaryPath(String macChromeBinaryPath) {
		this.macChromeBinaryPath = macChromeBinaryPath;
	}


	public String getLinuxChromeBinaryPath() {
		return linuxChromeBinaryPath;
	}


	public void setLinuxChromeBinaryPath(String linuxChromeBinaryPath) {
		this.linuxChromeBinaryPath = linuxChromeBinaryPath;
	}


	public String getWindowsChromeBinaryPath() {
		return WindowsChromeBinaryPath;
	}


	public void setWindowsChromeBinaryPath(String windowsChromeBinaryPath) {
		WindowsChromeBinaryPath = windowsChromeBinaryPath;
	}


	public String getBrowser() {
		return browser;
	}


	public void setBrowser(String browser) {
		this.browser = browser;
	}


	public String getBrowserDefaultLanguage() {
		return browserDefaultLanguage;
	}


	public void setBrowserDefaultLanguage(String browserDefaultLanguage) {
		this.browserDefaultLanguage = browserDefaultLanguage;
	}


	public static TestDataGson get(String filename) {

        Gson gson = new Gson();

        try (Reader reader = new FileReader(filename)) {

			// Convert JSON to Java Object
        	testData = gson.fromJson(reader, TestDataGson.class);
            System.out.println(testData.getBrowser());

            return testData;



        }
        catch (IOException e) {
            e.printStackTrace();
        }
		return testData;


	}





   public String getUrlForEnvironment() {

	   final String environment = getEnvironment(testData);
	   testData.setEnvironment(environment);

        if (listUrl != null) {
            final URL url = (listUrl).stream()
                    .filter(p -> p.environment.equals(getEnvironment()) || p.environment.equals(""))
                    .sorted((p1, p2) -> p2.environment.compareTo(p1.environment))
                    .findFirst().orElse(null);
            if (url != null) {
            	log.info("url being returned is"+ url.baseUrl);
                return url.baseUrl;
            }
        }

        return null;
    }



   private static String getEnvironment(final TestDataGson td) {

       String environment = td.getEnvironment();

       if (System.getProperty("qa.environment") != null) {
    	   environment = System.getProperty("qa.environment");

       } else if (System.getProperty("user.dir") != null) {
           final String fileName = System.getProperty("user.home") + File.separator + ".qa-test-hf-new" + File.separator + "environment.properties";
           final File propFile = new File(fileName);
           if (propFile.isFile()) {
               final Properties prop = new Properties();

               try {
                   try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
                       prop.load(fileInputStream);
                       final String current = prop.getProperty("current");
                       if (current != null && !current.isEmpty()) {
                    	   environment = current;
                       }
                   }
               } catch (final IOException ex) {
                   //log.info(TestDataGson.class.getName()).log(Level.SEVERE, "could not read " + fileName, ex);
               }
           }

       }

       return environment;
   }




   public String getParam(final String key) {
       if (listParam != null) {
    	   log.info("getting Param"+ listParam.stream());
           final PARAM param = listParam.stream()
                   .filter(p -> p.key.equals(key))
                   .findFirst().orElse(null);
           if (param != null) {
               return param.value;
           }
       }

       return null;
   }


}


