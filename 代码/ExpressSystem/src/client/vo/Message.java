package client.vo;

import java.util.ArrayList;

/**
 * �����ڽ�������߼���֮�䴫����Ϣ�Ķ���
 * @author rabook
 *
 */

public  class Message {
	
     private ArrayList<String> informs=new ArrayList<String>();
     private int n= informs.size();
     
     public void addInform(String inform){
    	 informs.add(inform);
    	 n=informs.size();
     }
     
     public String getInform(int number){
    	 return informs.get(number);
     }
     
     public int getN(){
    	 return n;
     }
     
}
