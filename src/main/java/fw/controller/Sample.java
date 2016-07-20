package fw.controller;

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
import java.util.logging.Level;
import java.util.logging.Logger;
import static jlib.Constants.*;
import jlib.db.DBFunction;
import org.json.JSONArray;

/**
 *
 * @author leo
 */

@WebServlet(name = "api", urlPatterns = {"/api"})
public class Sample extends ControllerBase {
    
//    @Override
//    protected List listAction(HttpServletRequest request, HttpServletResponse response){
//        // request.getContextPath()
//        
////        return testList();
//        return testDB();
//    }
    
    @Override
    protected JSONArray jsonAction(HttpServletRequest request, HttpServletResponse response){
        // request.getContextPath()
        
        return testJsonDB();
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
    
    private List testListDB(){
        DBFunction dbf = new DBFunction(dbDriverMySQL, "jdbc:mysql://localhost/test?useUnicode=true&characterEncoding=utf-8", "test", "");
        ArrayList valueList = new ArrayList();
        valueList.add("leo");
        ALHM result = null;
        try {
            dbf.connect(true);
            result = dbf.selectList("select * from `account`, `location` where `location`.`account_id` = `account`.`id`", null);
            dbf.disconnect();
        } catch (Exception ex) {
            Logger.getLogger(Sample.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    private JSONArray testJsonDB(){
        DBFunction dbf = new DBFunction(dbDriverMySQL, "jdbc:mysql://localhost/test?useUnicode=true&characterEncoding=utf-8", "test", "");
        ArrayList valueList = new ArrayList();
        valueList.add("leo");
        JSONArray result = null;
        try {
            dbf.connect(true);
//            resultJArr = dbf.selectJson("SELECT * FROM account WHERE account = ?", valueList);
            result = dbf.selectJson("select * from `account`, `location` where `location`.`account_id` = `account`.`id`", null);
            dbf.disconnect();
            
        } catch (Exception ex) {
            Logger.getLogger(Sample.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
}
