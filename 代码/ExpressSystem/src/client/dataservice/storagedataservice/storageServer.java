package client.dataservice.storagedataservice;

import client.po.BillPO;
import client.po.StoragePO;
import client.vo.Message;

/**
 * �ýӿ��ṩ�ֿ��������е�������ط���
 * ����
 * ��Ʒ���
 * ��Ʒ����
 * ����̵�
 * ���鿴
 * @author Nick
 *
 */
public interface storageServer {
	
	/*
	 * �÷����ṩ���ⵥ����ⵥ������
	 */
	public BillPO storageBillsMake(Message message);
	
	/*
	 * �÷����ṩ����̵���񣬷��ص�ǰ�Ŀ���嵥
	 */
	public StoragePO getStorageList();
	
	/*
	 * �÷����ṩ������ʼ����ʱ��鿴����������ķ���
	 */
	public Message getStorageHistory(String startTim,String endTime);
	
	/*
	 * �÷����ṩ������������
	 */
	public Message changeStorage(String id,String newLocation);

}
