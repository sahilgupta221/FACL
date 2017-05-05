/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applications;
import java.util.Random;

import report.PingAppReporter;
import core.Application;
import core.DTNHost;
import core.Message;
import core.Settings;
import core.SimClock;
import core.SimScenario;
import core.World;

/**
 *
 * @author sahilgupta221
 */
public class delegatedapplictions extends Application{

    @Override
    public Message handle(Message msg, DTNHost host) {
                if(msg.content.equals("permissiontickettodelegateduserfromRA")){//(21)
                if(message_parameters_content_analysis(msg)){
                DTNHost RA =null;    
            	Message m = new Message(msg.getTo(),RA, msg.id+"1", msg.size);
                m.content = "sendingdelegatedpermissiontickettoRA";
		m.setResponseSize(msg.responseSize);
		msg.getTo().createNewMessage(m);          
                }                
                }
                else if(msg.content.equals("decisionticketfordelegatedapp")){//(21)
                if(message_parameters_content_analysis(msg)){

                }                
                }
     return msg;
    }

    @Override
    public Message create_msg(DTNHost src, DTNHost dest, Message m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(DTNHost host) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void lowerapplicationDTNHostlistupdate(DTNHost host) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Application replicate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean message_parameters_content_analysis(Message msg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
