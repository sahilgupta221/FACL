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
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author sahilgupta221
 */
public class RAapplication extends Application{
        /** List of guardian hosts in this simulation */
        public Map<String, DTNHost> guardian_list;
    
        public RAapplication(){	
            super();
            guardian_list = new HashMap<String,DTNHost>();
	}
        
    @Override
    public Message handle(Message msg, DTNHost host) {
        if(msg.content.equals("NApptoRAauth")){//authentication request from Normal app
                if(message_parameters_content_analysis(msg)){
            	Message m = new Message(msg.getTo(), msg.getFrom(), msg.id+"1", msg.size);
                m.content = "RAtoNAppauthresponseticket";
		m.setResponseSize(msg.responseSize);
		msg.getTo().createNewMessage(m);          
                }
        }
        else if(msg.content.equals("functionalityrequest")){//(4)(6)
                if(message_parameters_content_analysis(msg)){//functionality request from normal app
            	Message m = new Message(msg.getTo(), msg.getFrom(), msg.id+"1", msg.size);
                m.content = "funcresponseasDDCert";
		m.setResponseSize(msg.responseSize);
		msg.getTo().createNewMessage(m);          
         
                //(7)Send message to RS for sending list of all guardians app can access
                DTNHost RS=null; 
                Message mrs = new Message(msg.getTo(), RS, msg.id+"1", msg.size);
                m.content = "listofguardtoRS";
		m.setResponseSize(msg.responseSize);
		msg.getTo().createNewMessage(m);
                }
        }
        else if(msg.content.equals("certificatetoRAforverify")){//(9)(10)
                if(message_parameters_content_analysis(msg)){
            	Message m = new Message(msg.getTo(), msg.getFrom(), msg.id+"1", msg.size);
                m.content = "sendconformationforverificationcert";
		m.setResponseSize(msg.responseSize);
		msg.getTo().createNewMessage(m);          
                }
        }else if(msg.content.equals("violationmessagetoRAforuser")){//(14)(15)(16)
                if(is_in_black_list(msg,host)){
                put_in_black_list(host);
                }
                if(message_parameters_content_analysis(msg)){
            	Message m = new Message(msg.getTo(), msg.getFrom(), msg.id+"1", msg.size);
                m.content = "notificationforviolation";
		m.setResponseSize(msg.responseSize);
		msg.getTo().createNewMessage(m);          
                }
        }
        else if(msg.content.equals("delegatedpermissionfromRA")){//(19)(20)                
                if(message_parameters_content_analysis(msg)){//do analysis here
            	Message m = new Message(msg.getTo(), msg.getFrom(), msg.id+"1", msg.size);
                m.content = "decisionticketfordelegatedapp";
		m.setResponseSize(msg.responseSize);
		msg.getTo().createNewMessage(m);          
                }
        }        
        else if(msg.content.equals("delegatedpermissionfromRA")){//(21)(1)                
                if(message_parameters_content_analysis(msg)){//do analysis here
            	Message m = new Message(msg.getTo(), msg.getFrom(), msg.id+"1", msg.size);
                m.content = "decisionticketfordelegatedapp";
		m.setResponseSize(msg.responseSize);
		msg.getTo().createNewMessage(m);          
                }
        }

        return msg;
    }

    @Override
    public void update(DTNHost host) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Application replicate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void lowerapplicationDTNHostlistupdate(DTNHost host) {
    guardian_list.put(host.name, host);
    }

    @Override
    public Message create_msg(DTNHost src, DTNHost dest, Message m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean message_parameters_content_analysis(Message msg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void put_in_black_list(DTNHost host) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean is_in_black_list(Message msg, DTNHost host) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
