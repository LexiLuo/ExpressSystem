package client.businesslogicservice.systemblservice;

import client.vo.Message;
import client.vo.SystemUserVO;

/**
 * �ýӿ��ṩ����ϵͳ��صķ���
 * ����
 * ϵͳ��¼��ϵͳ�˺Ź���
 * ����Ϊ��¼����ɾ�Ĳ�
 * @author rabook
 *
 */
public interface systemServer {
	
	public boolean login(String id,String key);
	
	public SystemUserVO addUser(Message message);
	
	public boolean removeUser(String id);
	
	public void changeUser(String name,Message message);
	
	public SystemUserVO inquire(String id);
	
	

}
