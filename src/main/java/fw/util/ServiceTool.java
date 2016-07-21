/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fw.util;

import java.util.Enumeration;
import jlib.tool.Debug;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author leo
 */
public class ServiceTool {
    protected static String TAG = ServiceTool.class.getName();
    protected static Debug de = new Debug(true);
    
    public static String getParm(HttpServletRequest request, String key){
        String result = request.getParameter(key);
        
        if ( StringUtils.isBlank(result) ) {
            
        }
        
        return result;
    }
    
    /** HttpServletRequest Print **/
    
    public static void printParms(HttpServletRequest request) {
        Enumeration<String> enu = request.getParameterNames();
        while (enu.hasMoreElements()) {
            String ele = enu.nextElement();
            de.println(ele + " : " + request.getParameter(ele) + " : " + request.getParameter(ele).getClass().getName() );
        }
    }
    
    public static void printAttributes(HttpServletRequest request) {
        Enumeration<String> enu = request.getAttributeNames();
        while (enu.hasMoreElements()) {
            String ele = enu.nextElement();
            de.println(ele + " : " + request.getAttribute(ele));
        }
    }
    
    public static void printHeaders(HttpServletRequest request) {
        Enumeration<String> enu = request.getHeaderNames();
        while (enu.hasMoreElements()) {
            String ele = enu.nextElement();
            de.println(ele + " : " + request.getHeader(ele));
        }
    }
}
