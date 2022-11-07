

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import model.ProductDAO;

/**
 * Application Lifecycle Listener implementation class DBProductListener
 *
 */
@WebListener
public class DBProductListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public DBProductListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    //一連線時監聽就執行
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	ServletContext context = sce.getServletContext(); //連線資料庫取得資料
		ArrayList list = prepareArrayList(); //將資料放入陣列
		context.setAttribute("catalog", list); //將陣列命名為"catalog"放在全域變數中
    }
    
    

	private ArrayList prepareArrayList() {
		ArrayList list;
		ProductDAO dao = new ProductDAO();
		list = dao.getProductList();
		return list;
	}
	
}
