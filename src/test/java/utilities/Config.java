package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

        public Properties p = new Properties();

        public Config(String path) {
            try {
                FileInputStream file = new FileInputStream(path);
                p.load(file);
                file.close();
            } catch (IOException e) {
                System.out.println("Properties file not found");
            }
        }

        public String getProperty(String keyword){
            return p.getProperty(keyword);
        }
    }
