package client.businesslogicservice.billsblservice;

import client.vo.BillVO;

/**
 * �ýӿ������ṩ�������ݵķ���
 * @author Ma
 *
 */

public interface billApprover {
	
	public void approveBill(BillVO bill,boolean judge);

}
