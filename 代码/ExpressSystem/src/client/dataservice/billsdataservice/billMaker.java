package client.dataservice.billsdataservice;

import client.po.BillPO;
import client.vo.Message;

/**
 * �ýӿ��ṩ���е��ݴ��������ݲ����
 * @author nick
 *
 */
public interface billMaker {

	public BillPO makeBill(Message message);
	
}

