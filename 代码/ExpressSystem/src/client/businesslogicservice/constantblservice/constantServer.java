package client.businesslogicservice.constantblservice;

import client.vo.ConstantVO;
import client.vo.Message;

/**
 * �ýӿ��ṩ�����ƶ��ķ���
 * @author rabook
 *
 */
public interface constantServer {

	public ConstantVO setConstant(Message message);
	
	public ConstantVO getConstant(String name);
	
}
