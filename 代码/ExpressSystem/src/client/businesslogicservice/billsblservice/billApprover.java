package client.businesslogicservice.billsblservice;

import client.po.BillPO;
import client.vo.BillVO;

/**
 * �ýӿ������ṩ�������ݵķ���
 * @author Ma
 *
 */

public interface billApprover {
	
	public void approveBill(BillPO bill,boolean judge);

	public void inform(BillPO bill);
}
