package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import util.Context;


public class StartProject implements ServletContextListener {

    public StartProject() {
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			Context.getSingleton();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
   }
	
    public void contextDestroyed(ServletContextEvent sce)  { 
        	Context.getSingleton().close();
    }

	
   
}
