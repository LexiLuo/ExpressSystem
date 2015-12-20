package businesslogic.billsbl.ChargeBillServer;

import po.bills.ChargeBill;
import client.RMIHelper;
import dataservice.billsdataservice.ChargeBillDataServer;

public class ChargeBillIDMaker {
	ChargeBillDataServer dataServer;
	
	public ChargeBillIDMaker(){
		this.dataServer=RMIHelper.getChargeBillData();
	}

	public String giveId(ChargeBill bill){
		String result="";
		result+=bill.getDate();
		String FlowNum="000";
		
		result=bill.getDate()+FlowNum;
		while(dataServer.findBill(result)!=null){
			
			int flow=Integer.valueOf(FlowNum);
			flow++;
			if(flow<=9){
				FlowNum="00"+String.valueOf(flow);
			}else if(flow<=99){
				FlowNum="0"+String.valueOf(flow);
			}else if(flow<=999){
				FlowNum=String.valueOf(flow);
			}else{
				return null;
			}
				
			result=bill.getDate()+FlowNum;
		}
		return result;		
	}
}
