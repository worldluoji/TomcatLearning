import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyContextListener implements ServletContextListener {
     @Override
     public void contextInitialized(ServletContextEvent sce) {
            System.out.println("MyContextListener init...");
     }

     @Override
     public void contextDestroyed(ServletContextEvent sce) {
            System.out.println("MyContextListener destory...");
     }
}