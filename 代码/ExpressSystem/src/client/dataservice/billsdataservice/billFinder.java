package client.dataservice.billsdataservice;

import client.po.BillPO;

/**
 * �ýӿ��ṩ���õ��ݱ�Ų�ѯ���ݵ����ݲ����
 * @author nick
 *
 */
public interface billFinder {

	public BillPO findBill(String id);
}
