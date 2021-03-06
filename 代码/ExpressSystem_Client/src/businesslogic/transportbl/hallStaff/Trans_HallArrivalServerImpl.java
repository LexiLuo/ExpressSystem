 package businesslogic.transportbl.hallStaff;

/**
 * 营业厅到达单功能的实现
 * 尚未完成！！
 */
import client.RMIHelper;
import dataservice.informationdataservice.Inform_HallStaffDataServer;
import po.GoodPO;
import po.Institution.HallPO;
import po.Workers.HallStaffPO;
import po.bills.HallArrivalBill;
import businesslogic.LocationNumGetter;
import businesslogic.billsbl.HallArrivalBillServer.HallArrivalBillServer;
import businesslogic.systembl.SystemHelper;
import businesslogic.transportbl.GoodController;
import businesslogicservice.transportblservice.hallStaff.Trans_HallArrivalServer;

public class Trans_HallArrivalServerImpl implements Trans_HallArrivalServer {
	HallArrivalBillServer billServer; 
	GoodController goodController;
	Inform_HallStaffDataServer staffServer;
	HallStaffPO staffNow;
	
	public Trans_HallArrivalServerImpl(){
		billServer=new HallArrivalBillServer();
		goodController=new GoodController();
		//RMI
		
		staffServer=RMIHelper.getHallStaffData();
	}

	@Override
	public HallArrivalBill makeBill(String GoodID,String date, String transOrderNum, String departure, String state) {
		// TODO Auto-generated method stub
		if(goodController.getGood(GoodID)==null){
			return null;
		}
		if(transOrderNum.equals("")||departure.equals("")){
			return null;
		}
		
		HallArrivalBill bill = billServer.makeBill(GoodID, date, transOrderNum, departure, state);
		
		staffNow=staffServer.find(SystemHelper.getUserID());
		
		HallPO hall=staffNow.getHall();

		
		//增加新的货物轨迹
		goodController.addTrace(GoodID, "于"+date+"到达了"+hall.getName());
		
		if(isSenderHall(hall.getID(),departure)){//如果是寄件人营业厅
			goodController.setGoodTransState(GoodID, "ArriveSendHall");
		}else if(isReceiverHall(hall.getID(), GoodID)){//如果是收件人营业厅
			goodController.setGoodTransState(GoodID, "ArriveReceiveHall");
		}

		return bill;
	}

	/**
	 * 辅助方法，判断是否是寄件人营业厅
	 * @return
	 */
	public boolean isSenderHall(String hallID,String departure){
		String depatureNum=LocationNumGetter.getNum(departure);
		String locationOfHall=hallID.substring(0, 3);
		
		if(locationOfHall.equals(depatureNum))
			return true;
		else 
			return false;
		
	}
	
	/**
	 * 辅助方法，判断是否是收件人营业厅
	 * @param hallID
	 * @param transOrderNum
	 * @return
	 */
	public boolean isReceiverHall(String hallID,String GoodID){
		GoodPO good=goodController.getGood(GoodID);
		String destinationNum=LocationNumGetter.getNum(good.getDestination());
		String locationOfHall=hallID.substring(0, 3);
		
		
		if(locationOfHall.equals(destinationNum))
			return true;
		else
	        return false;
	}
}
