package client.dataservice.transportdataservice;

import client.po.BillPO;
import client.po.GoodPO;

/**
 * �ýӿ��ṩ������������еĲ�ѯ����
 * ����
 * ��������״̬��ѯ
 * ������ѯ
 * @author Nick
 *
 */

public interface transportInquiry {

	/*
	 * ͨ�������Ż�û�����Ϣ
	 */
	public GoodPO GoodInquire(String id);
	
	
	/*
	 * ͨ��������Ż�ö�����Ϣ
	 */
	public BillPO Inquire(String id);
}
