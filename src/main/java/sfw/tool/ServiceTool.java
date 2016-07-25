/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sfw.tool;

import static sfw.Constants.*;
import java.util.Enumeration;
import jlib.tool.Debug;
import javax.servlet.http.HttpServletRequest;
import jlib.tool.AppProp;
import jlib.tool.Toolet;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author leo
 */
public class ServiceTool {
    protected static String TAG = ServiceTool.class.getName();
    protected static Debug de = new Debug(true);
    
    public static String requiredParm(HttpServletRequest request, String key){
        String result = request.getParameter(key);
        
        if ( StringUtils.isBlank(result) ) {
            de.println("key : " + key + " is required, but no value.");
        }
        
        return result;
    }
    
    public static String optionalParm(HttpServletRequest request, String key){
        String result = request.getParameter(key);
        
        if ( StringUtils.isBlank(result) ) {
            de.println("key : " + key + " is optional, but no value.");
            return "";
        }
        
        return result;
    }
    
    /** HttpServletRequest Print **/
    
    public static void printParms(HttpServletRequest request) {
        Enumeration<String> enu = request.getParameterNames();
        while (enu.hasMoreElements()) {
            String key = enu.nextElement();
            de.println(key + " : " + request.getParameter(key) + " : " + request.getParameter(key).getClass().getName() );
        }
    }
    
    public static void printAttributes(HttpServletRequest request) {
        Enumeration<String> enu = request.getAttributeNames();
        while (enu.hasMoreElements()) {
            String key = enu.nextElement();
            de.println(key + " : " + request.getAttribute(key) + " : " + request.getAttribute(key).getClass().getName() );
        }
    }
    
    public static void printHeaders(HttpServletRequest request) {
        Enumeration<String> enu = request.getHeaderNames();
        while (enu.hasMoreElements()) {
            String key = enu.nextElement();
            de.println(key + " : " + request.getHeader(key) + " : " + request.getHeader(key).getClass().getName() );
        }
    }
}
