package Mock_and_Driver.transportbl;

import po.Message;
import businesslogicservice.transportblservice.transportBillsMaker;
import businesslogicservice.transportblservice.transportInquiry;

public class transportDriver {
   //改模块所有的单据新建操作全部依赖billMaker，不再重复测试了
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       transportInquiry in=new MockTransportInquiry();
       in.Inquire("1");
       
       Message message=new Message();
       
       transportBillsMaker billMaker=new MockTransBillsMakerImpl();
       billMaker.makeDeliveryBill(message);
	}

}
