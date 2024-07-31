package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    Properties prop ;
    public ConfigReader(){

    }
    public Properties ConfigurationManager() {
        this.prop = new Properties();
        File proFile = new File("src/test/resources/Congif/ConfigFile.properties");

        try {
            FileInputStream fis = new FileInputStream(proFile);
            this.prop.load(fis);
        } catch (Throwable var3) {
            var3.printStackTrace();
        }

        return this.prop;
    }
    public  String Getusername(){
        String username= this.prop.getProperty("username");
        return username;
    }

    public  String Getpassword(){
        String password= this. prop.getProperty("password");
        return password;
    }

    public String GetUrl(){
        String Url=this.prop.getProperty("Url");

        return Url;
    }
}
