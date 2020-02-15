package net.cristcost.lambda;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LeggiDaClasspath {

	public static void main(String[] args) {
		
		
			InputStream input = null;
			try {
				input =  new FileInputStream(ClassLoader.getSystemClassLoader().getResource(".").getPath()+"config.properties");
			} catch (IOException ex) {
	            ex.printStackTrace();
	            System.out.println("non l'ho trovato con il JAR quindi vado su resources");
	            input = LeggiDaClasspath.class.getClassLoader().getResourceAsStream("resources/config.properties");
	        }
	        try{

	        	System.out.println(LeggiDaClasspath.class.getProtectionDomain().getCodeSource().getLocation().getPath());
	        	System.out.println(ClassLoader.getSystemClassLoader().getResource(".").getPath());
	        	
	            Properties prop = new Properties();

	            //load a properties file from class path, inside static method
	            prop.load(input);

	            //get the property value and print it out
	            System.out.println(prop.getProperty("db.url"));
	            System.out.println(prop.getProperty("db.user"));
	            System.out.println(prop.getProperty("db.password"));

	        } catch (IOException ex) {
	            ex.printStackTrace();
	        } finally {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}


	}

}
