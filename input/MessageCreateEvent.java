/* 
 * Copyright 2010 Aalto University, ComNet
 * Released under GPLv3. See LICENSE.txt for details. 
 */
package input;

import core.DTNHost;
import core.Message;
import core.World;

/**
 * External event for creating a message.
 */
public class MessageCreateEvent extends MessageEvent {
	private int size;
	private int responseSize;
	
	/**
	 * Creates a message creation event with a optional response request
	 * @param from The creator of the message
	 * @param to Where the message is destined to
	 * @param id ID of the message
	 * @param size Size of the message
	 * @param responseSize Size of the requested response message or 0 if
	 * no response is requested
	 * @param time Time, when the message is created
	 */
	public MessageCreateEvent(int from, int to, String id, int size,
			int responseSize, double time) {
		super(from,to, id, time);
		this.size = size;
		this.responseSize = responseSize;
	}

	
	/**
	 * Creates the message this event represents. 
	 */
	@Override
	public void processEvent(World world) {
		DTNHost to = world.getNodeByAddress(this.toAddr);
		DTNHost from = world.getNodeByAddress(this.fromAddr);			
		to = world.getNodeByname("RA5");
                // create first message at application level
                if(from.groupId.equals("Normal_app")){                
		Message m = new Message(from, to, this.id, this.size);
                m.content = "NApptoRAauth";
		m.setResponseSize(this.responseSize);
		from.createNewMessage(m);
                //(19)delegateappevent : Todo: shift it to update of application
                if(delegateappevent()){//event when permission for delegate app is sent to RA
                DTNHost RA =null;
                Message msgdtra = new Message(from, RA, this.id, this.size);
                m.content = "delegatedpermissionfromRA";
		m.setResponseSize(this.responseSize);
		from.createNewMessage(m);
                }                

                }
	}
	
	@Override
	public String toString() {
		return super.toString() + " [" + fromAddr + "->" + toAddr + "] " +
		"size:" + size + " CREATE";
	}

    private boolean delegateappevent() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
