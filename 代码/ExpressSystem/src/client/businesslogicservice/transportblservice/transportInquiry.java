package client.businesslogicservice.transportblservice;

import client.vo.BillVO;
import client.vo.GoodVO;

/**
 * �ýӿ��ṩ������������еĲ�ѯ����
 * ����
 * ��������״̬��ѯ
 * ������ѯ
 * @author Ma
 *
 */

public interface transportInquiry {

	/*
	 * ͨ�������Ż�û�����Ϣ
	 */
	public GoodVO GoodInquire(String id);
	
	
	/*
	 * ͨ��������Ż�ö�����Ϣ
	 */
	public BillVO Inquire(String id);
}
