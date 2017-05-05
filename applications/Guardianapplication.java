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
public class Guardianapplication extends Application{
//	protected List<DTNHost> guardian_list;
        /** List of sensor mote hosts in this simulation */
        public Map<String, DTNHost> sensor_mote_list;
        
        public Guardianapplication(){	
            super();
            sensor_mote_list = new HashMap<String,DTNHost>();
	}
        
    @Override
    public Message handle(Message msg, DTNHost host) {
        if(msg.content.equals("guardforverification")){//(8)(9)
                if(message_parameters_content_analysis(msg)){
                DTNHost RA=null;     
            	Message m = new Message(msg.getTo(), RA, msg.id+"1", msg.size);
                m.content = "certificatetoRAforverify";
		m.setResponseSize(msg.responseSize);
		msg.getTo().createNewMessage(m);          
                }
        }
        else if(msg.content.equals("sendconformationforverificationcert")){//(10)(11)
                if(message_parameters_content_analysis(msg)){
                DTNHost RA=null;     
            	Message m = new Message(msg.getTo(), RA, msg.id+"1", msg.size);
                m.content = "confirmationtosenddatafromuser";
		m.setResponseSize(msg.responseSize);
		msg.getTo().createNewMessage(m);          
                }
        }else if(msg.content.equals("functionalitydataresquest")){//(12)(14)
                if(ACL_check_and_violations(msg,host)==1){// to sensor for data request
                DTNHost sensornode=null;     
            	Message m = new Message(msg.getTo(), sensornode, msg.id+"1", msg.size);
                m.content = "sensorfordatarequest";
		m.setResponseSize(msg.responseSize);
		msg.getTo().createNewMessage(m);          
                }
                else if(ACL_check_and_violations(msg,host)==2){//notification not in ACL to app
                DTNHost normalapp=null;     
            	Message m = new Message(msg.getTo(), normalapp, msg.id+"1", msg.size);
                m.content = "notinacllistofguardian";
		m.setResponseSize(msg.responseSize);
		msg.getTo().createNewMessage(m);          
                }
                else if(ACL_check_and_violations(msg,host)==1){//send to RA for violation
                DTNHost RA=null;     
            	Message m = new Message(msg.getTo(), RA, msg.id+"1", msg.size);
                m.content = "violationmessagetoRAforuser";
		m.setResponseSize(msg.responseSize);
		msg.getTo().createNewMessage(m);          
                }
        }
        else if(msg.content.equals("dataforusertoguardian")){//(17)(18)
                if(message_parameters_content_analysis(msg)){//do data aggregation here if required
                DTNHost normalapp=null;     
            	Message m = new Message(msg.getTo(), normalapp, msg.id+"1", msg.size);
                m.content = "datatouserfromsensorviaguardian";
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
       sensor_mote_list.put(host.name, host);
    }

    @Override
    public Message create_msg(DTNHost src, DTNHost dest, Message m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean message_parameters_content_analysis(Message msg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private int ACL_check_and_violations(Message msg, DTNHost host) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}


