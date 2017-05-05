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
public class Normalapplication extends Application{

    @Override
    public Message handle(Message msg, DTNHost host) {
            if(msg.content.equals("RAtoNAppauthresponseticket")){// ticket for asking any functionality latter
                if(message_parameters_content_analysis(msg)){
            	Message m = new Message(msg.getTo(), msg.getFrom(), msg.id+"1", msg.size);
                m.content = "functionalityrequest";
		m.setResponseSize(msg.responseSize);
		msg.getTo().createNewMessage(m);          
                }                
                } else if(msg.content.equals("funcresponseasDDCert")){//(6)(8)see working page picture in mail
                if(message_parameters_content_analysis(msg)){
                DTNHost guardian=null;    
            	Message m = new Message(msg.getTo(),guardian, msg.id+"1", msg.size);
                m.content = "guardforverification";
		m.setResponseSize(msg.responseSize);
		msg.getTo().createNewMessage(m);          
                } 
                }
                else if(msg.content.equals("confirmationtosenddatafromuser")){//(11)(12)
                if(message_parameters_content_analysis(msg)){
            	Message m = new Message(msg.getTo(),msg.getFrom(), msg.id+"1", msg.size);
                m.content = "functionalitydataresquest";
		m.setResponseSize(msg.responseSize);
		msg.getTo().createNewMessage(m);          
                }
                }
                else if(msg.content.equals("notinacllistofguardian")){//(14))
                if(message_parameters_content_analysis(msg)){
                    //nothing so far
                }
                }
                else if(msg.content.equals("datatouserfromsensorviaguardian")){//(18)
                if(message_parameters_content_analysis(msg)){// do processing of data here
                    
                }
                else if(msg.content.equals("decisionticketfordelegatedapp")){//(20)(21)
                if(message_parameters_content_analysis(msg)){
                DTNHost delegatedapp=null;
            	Message m = new Message(msg.getTo(),delegatedapp, msg.id+"1", msg.size);
                m.content = "permissiontickettodelegateduserfromRA";
		m.setResponseSize(msg.responseSize);
		msg.getTo().createNewMessage(m);          
                }
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Message create_msg(DTNHost src, DTNHost dest, Message m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean message_parameters_content_analysis(Message msg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}