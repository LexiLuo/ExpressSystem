package client.dataservice.accountSetdataservice;

import java.rmi.RemoteException;

import client.po.PaymentPO;
import client.vo.Message;

/**
 * accountSet���ݲ���½��Ͳ鿴
 * @author nick
 *
 */
public interface accountSetdataserver {
	public void insert(Message msg) throws RemoteException;
	
	public PaymentPO find(String id) throws RemoteException;
	

}
