package client.businesslogicservice.salaryblservice;

import client.vo.Message;
import client.vo.SalaryVO;

/**
 * �ýӿ��ṩнˮ�����ƶ��ķ���
 * @author rabook
 *
 */
public interface salaryServer {

	public SalaryVO setSalary(Message message);
	
	public SalaryVO getSalary(Message message);
	
}
