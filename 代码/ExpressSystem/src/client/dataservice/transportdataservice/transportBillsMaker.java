package client.dataservice.transportdataservice;

import client.po.BillPO;
import client.vo.Message;

/**
 * �ýӿ����ڹ����������������к��½������йص����ݲ����
 * ����ʵ�ֽ���������billdata�еĹ������ֹ���
 * �ӿڵ�ʵ�ֽ��½����ݺͽ��л���״̬�ĸ���
 * @author Nick
 *
 */

public interface transportBillsMaker {
	
	public BillPO makeTransBill(Message message);

}