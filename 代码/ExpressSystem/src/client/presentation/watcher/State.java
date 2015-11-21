package client.presentation.watcher;

public enum State {
	COURIERSTART, COURIERINPUTINFOR,COURIERMAKEBILL,COURIERSEARCH,
	LOGMAINFRAME,COVER,LOGSEARCH,
	ZHONG_START,ZHONG_ARRIVAL,ZHONG_TRANSFER,ZHONG_ENTRUCKING,
	YING_START,YING_COLLECT,YING_ARRIVE,YING_RECEIVE,YING_PAYMENT,YING_LOADING,YING_MANAGEINFOR,
	ACCOUNTANTSTART,ACCOUNTANTMAKEBILL,ACCOUNTANTMAKESHEET,ACCOUNTANTPAYMENT,
	ACCOUNTANTCOST,ACCOUNTANTMANAGE,ACCOUNTANTBALACE,ACCOUNTANTBALACEAFTER,
	STOCKMANSTART,STOCKMANINSTOCK,STOCKMANINSTOCKAFTER,STOCKMANOUTSTOCK,
	STOCKMANOUTSTOCKAFTER,STOCKMANSEARCH,STOCKMANCHECK,STOCKMANCHANGE,
	MANAGERSTART,MANAGERMAKECONSTANT,MANAGERMAKEMONEY,MANAGERMANAGE,MANAGERCHECK,MANAGERFIND,
	LEFTCOURIER,LEFTZHONG,LEFTYING,LEFTACCOUNTANT,LEFTSTOCKMAN,LEFTMANAGER,
	LOGOUT,
	ADMINSTART,ADMINMANAGE;
}
