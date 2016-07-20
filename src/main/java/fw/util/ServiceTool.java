/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fw.util;

import java.util.Enumeration;
import jlib.tool.Debug;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author leo
 */
public class ServiceTool {
    protected static String TAG = ServiceTool.class.getName();
    protected static Debug de = new Debug(true);
    /** HttpServletRequest Print **/
    
    public static void printParms(HttpServletRequest request) {
        Enumeration<String> enu = request.getParameterNames();
        while (enu.hasMoreElements()) {
            String ele = enu.nextElement();
            de.println(ele + " : " + request.getParameter(ele));
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
