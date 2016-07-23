package fw.controller;

import static fw.Constants.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jlib.util.ALHM;
import jlib.util.HM;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fw.controller.ControllerBase;
import fw.tool.ServiceProp;
import static fw.tool.ServiceTool.optionalParm;
import static fw.tool.ServiceTool.requiredParm;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static jlib.Constants.*;
import jlib.db.DBFunction;
import jlib.tool.AppProp;
import org.json.JSONArray;

/**
 *
 * @author leo
 */

@WebServlet(name = "api", urlPatterns = {"/api"})
public class Sample extends ControllerBase {
    
    public static final String dbconn = "jdbc:mysql://localhost/test?useUnicode=true&characterEncoding=utf-8";
    public static final String dbaccount = "test";
    public static final String dbpwd = "test";
    
    @Override
    protected Object action(HttpServletRequest request, HttpServletResponse response){
//        return testList();

        testServiceProp();

        return testDB(request);
    }
    
    private void testServiceProp(){
        ServiceProp sapp = new ServiceProp();
        de.println(sapp.getAppValue(envStr));
        
    }
    
    private List testList(){
        ALHM list = new ALHM();
            HM map = new HM();

            map.put("abc", "123456");
            map.put("def", "hmm123");
            
            List list1 = new ArrayList();
            Map<String, Object> map1 = new HashMap();
            map1.put("TheOne", "abc");
            map1.put("TheTwo", "abc");
            map1.put("TheThree", "abc");
            
            List list2 = new ArrayList();
            Map<String, Object> map2 = new HashMap();
            map2.put("qw", "1");
            map2.put("qq", 33);
            map2.put("rr", "gfee");
            
            List list3 = new ArrayList();
            Map<String, Object> map3 = new HashMap();
            map3.put("qw", "1");
            map3.put("qq", 33);
            map3.put("rr", "gfee");
            
            Map<String, Object> map4 = new HashMap();
            map4.put("qw", "1");
            
            map3.put("map4",map4);
            
            list3.add(map3);
            
            map2.put("list3", list3);
            
            list2.add(map2);
            
            map1.put("list2", list2);
            
            list1.add(map1);
            
            map.put("list1", list1);
            
            list.add((HashMap<String, Object>)map);
            
//            list.printAll();
            return list;
    }
    
    private Object testDB(HttpServletRequest request){
        DBFunction dbf = new DBFunction(dbDriverMySQL, dbconn, dbaccount, dbpwd);
        
        Object result = null;
        try {
            dbf.connect(true);
            // http://localhost:8080/fw/api?id=1
//            result = dbf.getALHM("select * from `account` where id = ?", requiredParm(request, "id"));
//            result = dbf.getJson("select * from `account` where id = ?", requiredParm(request, "id"));
            // http://localhost:8080/fw/api?account_id=1&location=SHA3&info=Hellow World!!
//            result = dbf.setALHM("INSERT INTO `location` (`account_id`, `location`, `info`) VALUES (?, ?, ?)", requiredParm(request, "account_id"), requiredParm(request, "location"), optionalParm(request, "info"));
//            result = dbf.setJson("INSERT INTO `location` (`account_id`, `location`, `info`) VALUES (?, ?, ?)", requiredParm(request, "account_id"), requiredParm(request, "location"), optionalParm(request, "info"));
            // http://localhost:8080/fw/api?id=8&location=SHA123
//            result = dbf.setALHM("UPDATE `location` SET `location`=? WHERE `id`=?", requiredParm(request, "location"), requiredParm(request, "id"));
//            result = dbf.setJson("UPDATE `location` SET `location`=? WHERE `id`=?", requiredParm(request, "location"), requiredParm(request, "id"));
            // http://localhost:8080/fw/api?id=5
//            result = dbf.setALHM("DELETE FROM `location` WHERE `id`=?", requiredParm(request, "id"));
//            result = dbf.setJson("DELETE FROM `location` WHERE `id`=?", requiredParm(request, "id"));
            dbf.disconnect();
        } catch (Exception ex) {
            Logger.getLogger(Sample.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(dbf.getConnection() != null) {
                try {
                    dbf.getConnection().close();
                } catch (SQLException e) {
                    // ignore
                }
            }
        }
        return result;
    }
    
    private JSONArray testJsonDB(HttpServletRequest request){
        DBFunction dbf = new DBFunction(dbDriverMySQL, dbconn, dbaccount, dbpwd);
        
        String id = requiredParm(request, "id");
        
        JSONArray result = null;
        try {
            dbf.connect(true);

            result = dbf.setJson("DELETE FROM `location` WHERE `id`=?", id);
            dbf.disconnect();
            
        } catch (Exception ex) {
            Logger.getLogger(Sample.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(dbf.getConnection() != null) {
                try {
                    dbf.getConnection().close();
                } catch (SQLException e) {
                    // ignore
                }
            }
        }
        return result;
    }
    
}
