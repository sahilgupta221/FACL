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
public class SensorMoteapplication extends Application{
//	protected List<DTNHost> guardian_list;
        /** List of sensor mote hosts in this simulation */
        public Map<String, DTNHost> guardian_list;
        
        public SensorMoteapplication(){	
            super();
            guardian_list = new HashMap<String,DTNHost>();
	}
        
    @Override
    public Message handle(Message msg, DTNHost host) {
        if(msg.content.equals("sensorfordatarequest")){//(14)(17)
                if(message_parameters_content_analysis(msg)){
            	Message m = new Message(msg.getTo(), msg.getFrom(), msg.id+"1", msg.size);
                m.content = "dataforusertoguardian";
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
    
}
