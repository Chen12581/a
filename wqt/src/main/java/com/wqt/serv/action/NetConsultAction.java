package com.wqt.serv.action;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.consult.pojo.ClientConsult;
import com.hessian.HessionFactory;
import com.talkweb.twdpe.core.log.Logger;
import com.talkweb.twdpe.core.log.LoggerFactory;
import com.talkweb.twdpe.web.session.main.Session;
import com.talkweb.twdpe.web.session.util.SessionFactory;
import com.talkweb.twdpe.webcomponent.common.action.BusinessAction;


/*网络咨询*/
public class NetConsultAction extends BusinessAction{
    private static final Logger logger = LoggerFactory.getLogger(NetConsultAction.class);
	
	
	private ClientConsult  wqtnetconsult;
	
	public ClientConsult getWqtnetconsult() {
		return wqtnetconsult;
	}

	public void setWqtnetconsult(ClientConsult wqtnetconsult) {
		this.wqtnetconsult = wqtnetconsult;
	}

	/*用户网站咨询*/
	public String saveWqtNetConsult()
	{  
		   HttpServletRequest request = ServletActionContext.getRequest();
		   HttpServletResponse response = ServletActionContext.getResponse();
		   Session session = SessionFactory.getInstance(request, response);
		   Map resultData = new HashMap();
		   try {
			      if(wqtnetconsult!=null)
			      {
			         HessionFactory.netConsultHession().saveClientConsult(wqtnetconsult);
			         resultData.put("result",1);
			      }
			      else
			      {
			    	  resultData.put("result",0);
			      }
		   } catch (Exception e) {
				resultData.put("result",0);
			}
		   this.formatData(resultData);
           return SUCCESS;
	}
}
