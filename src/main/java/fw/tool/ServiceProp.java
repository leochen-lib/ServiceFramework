/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fw.tool;

import static fw.Constants.*;
import java.util.Properties;
import jlib.tool.AppProp;
import jlib.tool.AppProp;
import jlib.tool.Toolet;

/**
 *
 * @author leo
 */
public class ServiceProp extends AppProp {
    
    protected Properties appProp;
    protected Properties dbProp;
    
    public ServiceProp() {
        appProp = load( (new Toolet()).getHomePath()+propertyFolderStr + appStr);
        dbProp = load( (new Toolet()).getHomePath()+propertyFolderStr + dbStr );
    }
    
    public String getAppValue(String key){
        return appProp.getProperty(key);
    }
    
    public String getDBValue(String key){
        return dbProp.getProperty(key);
    }
    
}
