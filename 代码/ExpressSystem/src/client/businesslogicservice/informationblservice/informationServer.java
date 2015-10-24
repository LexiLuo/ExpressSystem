package client.businesslogicservice.informationblservice;

import client.vo.InstitutionVO;
import client.vo.Message;
import client.vo.WorkerVO;


/**
 * �ýӿ��ṩ������Ա�������Ϣ����ķ���
 * ������Ա��Ϣ��������Ϣ��������Ϣ
 * ����ֻ��ҪWorker��Institution����VO��������Ϣ��Ϊ��Ա��Ϣ
 * ����Ϊ��ɾ�Ĳ�
 * @author rabook
 *
 */
public interface informationServer {
	
	public WorkerVO addWorker(Message message);
	
	public InstitutionVO addInstitution(Message message);
	
	public boolean removeWorker(String id);
	
	public boolean removeInstitution(String id);
	
	public boolean changeWorker(String id,Message message);
	
	public boolean changeInstitution(String id,Message message);
	
	public WorkerVO inquireWorker(String id);
	
	public InstitutionVO inquireInstitution(String id);
	
}
