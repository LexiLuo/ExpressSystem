package client.businesslogicservice.transportblservice;

import client.vo.BillVO;
import client.vo.Message;

/**
 * �ýӿ����ڹ����������������к��½������йصķ���
 * ����ʵ�ֽ���������billbl�еĹ������ֹ���
 * �ӿڵ�ʵ�ֽ��½����ݺͽ��л���״̬�ĸ���
 * @author Ma
 *
 */

public interface transportBillsMaker {
	
	public BillVO makeTransBill(Message message);

}
