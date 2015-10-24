package client.businesslogicservice.storageblservice;

import client.vo.BillVO;
import client.vo.Message;
import client.vo.StorageVO;


/**
 * �ýӿ��ṩ�ֿ��������е�������ط���
 * ����
 * ��Ʒ���
 * ��Ʒ����
 * ����̵�
 * ���鿴
 * @author Ma
 *
 */
public interface storageServer {
	
	/*
	 * �÷����ṩ���ⵥ����ⵥ������
	 */
	public BillVO storageBillsMake(Message message);
	
	/*
	 * �÷����ṩ����̵���񣬷��ص�ǰ�Ŀ���嵥
	 */
	public StorageVO getStorageList();
	
	/*
	 * �÷����ṩ������ʼ����ʱ��鿴����������ķ���
	 */
	public Message getStorageHistory(String startTim,String endTime);
	
	/*
	 * �÷����ṩ������������
	 */
	public Message changeStorage(String id,String newLocation);

}
