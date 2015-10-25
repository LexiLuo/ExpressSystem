package client.businesslogic.billsbl;

import client.businesslogicservice.billsblservice.billMaker;
import client.vo.BillVO;
import client.vo.Message;

public class receiveBillFactory implements billMaker{

	public BillVO makeBill(Message message) {
		// TODO Auto-generated method stub
		receiveBillVO bill=new receiveBillVO(message);
		System.out.println("�����߼������½������Ĺ��������½���һ���������������浽�����ݲ��У�");
		this.update(bill);
		return bill;
	}
	
	public void update(receiveBillVO bill){
		
		System.out.println("���ݲ���������һ���ռ���");
		System.out.println("�ռ�������Ϊ"+bill.getName());
		System.out.println("�ռ�ʱ��Ϊ"+bill.getTime());
		System.out.println("�ռ�����Ϊ"+bill.getNum());
	}

}
