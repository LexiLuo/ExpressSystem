package client.dataservice.billsdataservice;

import client.po.BillPO;


/**
 * �ýӿ������ṩ�������ݵ����ݲ����
 * @author nick
 *
 */
public interface billApprover {

	public void approveBill(BillPO bill,boolean judge);
}
