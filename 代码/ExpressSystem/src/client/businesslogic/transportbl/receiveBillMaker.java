package client.businesslogic.transportbl;

import client.businesslogic.billsbl.receiveBillFactory;
import client.businesslogic.billsbl.receiveBillVO;
import client.businesslogicservice.transportblservice.transportBillsMaker;
import client.vo.BillVO;
import client.vo.Message;

public class receiveBillMaker implements transportBillsMaker{

	public BillVO makeTransBill(Message message) {
		// TODO Auto-generated method stub
		System.out.println("�����߼����еĴ����ռ���¼��ķ����������õ����еķ����½���һ���ռ����������˻���״̬��");
		receiveBillFactory factory=new receiveBillFactory();
		receiveBillVO Bill=(receiveBillVO) factory.makeBill(message);
		

		return Bill;
	}

}
