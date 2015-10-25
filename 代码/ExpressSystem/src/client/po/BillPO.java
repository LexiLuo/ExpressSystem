package client.po;

import client.vo.Message;

/**
 * ���ݵĸ���PO����
 * @author nick
 *
 */
public class BillPO {
	private Message billInfor;
	
	private enum State{Draft,Ready,Finish};
	
	private State billState;
	
	private final String time;
	
	public BillPO(Message billInfor){
		this.billInfor=billInfor;
		this.billState=State.Draft;
		time="";
	}
	
	public State getState(){
		return this.billState;
	}
	
	public void setState(State newState){
		this.billState=newState;
	}
	
	public Message getInformation(){
		return this.billInfor;
	}
}
