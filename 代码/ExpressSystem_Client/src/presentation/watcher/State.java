package presentation.watcher;

public enum State {
	COURIERSTART, COURIERINPUTINFOR,COURIERMAKEBILL,COURIERSEARCH,COURIERSEARCHAFTER,
	LOGMAINFRAME,COVER,LOGSEARCH,
	ZHONG_START,ZHONG_ARRIVAL,ZHONG_TRANSFER,ZHONG_ENTRUCKING,
	YING_START,YING_COLLECT,YING_ARRIVE,YING_PAYMENT,YING_LOADING,YING_MANAGEINFOR,
	ACCOUNTANTSTART,ACCOUNTANTMAKEBILL_ONE,ACCOUNTANTMAKEBILL_TWO,
	ACCOUNTANTMAKEBILL_THREE,ACCOUNTANTMAKESHEET,ACCOUNTANTPAYMENT,
	ACCOUNTANTCOST,ACCOUNTANTMANAGE,ACCOUNTANTBALACE,STOCKMANSTART,STOCKMANINSTOCK,STOCKMANOUTSTOCK,
	STOCKMANOUTSTOCKAFTER,STOCKMANSEARCH,STOCKMANCHECK,STOCKMANCHANGE,
	MANAGERSTART,MANAGERMAKECONSTANT,MANAGERMAKEMONEY,MANAGERMANAGE,MANAGERCHECK,
	ADMINSTART,ADMINMANAGE,
	LOGOUT,
	LEFTCOURIER,LEFTZHONG,LEFTYING,LEFTACCOUNTANT,LEFTSTOCKMAN,LEFTMANAGER,LEFTADMIN
	 
}
