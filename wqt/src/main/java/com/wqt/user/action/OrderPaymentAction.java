package com.wqt.user.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.talkweb.twdpe.core.log.Logger;
import com.talkweb.twdpe.core.log.LoggerFactory;
import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.talkweb.twdpe.web.session.main.Session;
import com.talkweb.twdpe.web.session.util.SessionFactory;
import com.talkweb.twdpe.webcomponent.common.action.BusinessAction;
import com.user.pojo.UserBasic;
import com.wqt.common.util.PropertiesUtil;
import com.wqt.es.order.pojo.EsOrderServices;
import com.wqt.es.order.pojo.EsOrderTrade;
import com.wqt.es.order.service.EsOrderServiceService;
import com.wqt.es.order.service.EsOrderTradeService;
import com.wqt.eshop.pojo.EShopOrder;
import com.wqt.eshop.service.EShopOrderService;
import com.wqt.ipr.order.pojo.IprBrandOrderProduct;
import com.wqt.ipr.order.pojo.IprBrandOrderShop;
import com.wqt.ipr.order.pojo.IprCopyrightOrderProduct;
import com.wqt.ipr.order.pojo.IprCopyrightOrderShop;
import com.wqt.ipr.order.pojo.IprOrderProduct;
import com.wqt.ipr.order.pojo.IprOrderShop;
import com.wqt.ipr.order.pojo.IprPatentOrderProduct;
import com.wqt.ipr.order.pojo.IprPatentOrderShop;
import com.wqt.ipr.order.service.IprOrderProductService;
import com.wqt.ipr.order.service.IprOrderShopService;
import com.wqt.user.pojo.OrderPayment;
import com.wqt.user.pojo.OrderPaymentList;
import com.wqt.user.pojo.WqtUserPost;
import com.wqt.user.service.UserBasicService;

/*订单支付相关*/
public class OrderPaymentAction  extends BusinessAction{
	private static final Logger logger = LoggerFactory.getLogger(OrderPaymentAction.class);
	@Autowired
	private IprOrderShopService iprOrderShopService;
	
	@Autowired
	private IprOrderProductService iprOrderProductService;
	
	@Autowired
	private EsOrderServiceService esOrderServiceService;
	
	@Autowired
	private EsOrderTradeService esOrderTradeService;
	
	@Autowired
	private EShopOrderService eShopOrderService;
	
	@Autowired
	private UserBasicService userBasicService;
	
	private Pagination  pagination;	
	
	
	private OrderPaymentList orderPaymentList;
	
	
	public OrderPaymentList getOrderPaymentList() {
		return orderPaymentList;
	}


	public void setOrderPaymentList(OrderPaymentList orderPaymentList) {
		this.orderPaymentList = orderPaymentList;
	}

	private OrderPayment payment;  //商标服务产品订单详情对象
	
	public OrderPayment getPayment() {
		return payment;
	}


	public void setPayment(OrderPayment payment) {
		this.payment = payment;
	}



	public Pagination getPagination() {
		return pagination;
	}


	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
	
	/*订单支付页面*/
	public String orderPayment()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
	    Session session = SessionFactory.getInstance(request, response);
	    Object user = (Object) session.getAttribute("LOGINSESSIOIN");
	    String ordercode=request.getParameter("ordercode"); //获取订单号
	    String ordertype=request.getParameter("ordertype"); //获取订单类别
	    
	    // 获取此请求的地址          
	    StringBuffer url=request.getRequestURL();
		String serverurl=url.toString();
		
	    try
		{
			  if(user!=null)
			  {
				  serverurl=serverurl.substring(0, serverurl.indexOf("/order/pay"));
				  UserBasic wqtuser = (UserBasic) user;
				  //UserBasic wqtuser =new UserBasic();
				  //wqtuser.setId("1");
				  if(orderPaymentList==null)
				  {
					  orderPaymentList=new OrderPaymentList();
				  }
				  
				  UserBasic wqtUserBasic=userBasicService.selectUserById(wqtuser.getId());
				  orderPaymentList.setWqtUserBasic(wqtUserBasic);
				  
				  if("1".equals(ordertype))   //知识产权服务
				  {
					  IprOrderProduct iprOrderProduct=new IprOrderProduct();  
					  iprOrderProduct.setOrdercode(ordercode);
					  iprOrderProduct.setUserid(wqtuser.getId());
					  iprOrderProduct=iprOrderProductService.selectOneIprOrderProduct(iprOrderProduct);
					  if(iprOrderProduct!=null)
					  {
						  List<OrderPayment> l_OrderPayment=new ArrayList<OrderPayment>();
						  OrderPayment payment=new OrderPayment();
						  if("1".equals(iprOrderProduct.getOrderkind()))   //商标
						  {
							  IprBrandOrderProduct brandOrderProduct=iprOrderProductService.selectIprBrandOrderProduct(iprOrderProduct);
							  payment.setBrandOrderProduct(brandOrderProduct);
						  }
						  else if("2".equals(iprOrderProduct.getOrderkind()))//版权
						  {
							  IprCopyrightOrderProduct copyrightOrderProduct=iprOrderProductService.selectIprCopyrightOrderProduct(iprOrderProduct);
							  payment.setCopyrightOrderProduct(copyrightOrderProduct);
						  }
						  else if("3".equals(iprOrderProduct.getOrderkind()))//专利
						  {
							  IprPatentOrderProduct patentOrderProduct=iprOrderProductService.selectIprPatentOrderProduct(iprOrderProduct);
							  payment.setPatentOrderProduct(patentOrderProduct);
						  }
						  l_OrderPayment.add(payment);
						  orderPaymentList.setL_OrderPayment(l_OrderPayment);
						  return SUCCESS;
					  }
					  else
					  {
						  return "404";
					  }
				  }
				  else if("2".equals(ordertype))  //知识产权交易
				  {
					  IprOrderShop iprOrderShop=new IprOrderShop();  
					  iprOrderShop.setOrdercode(ordercode);
					  iprOrderShop.setBuyerid(wqtuser.getId());
					  iprOrderShop=iprOrderShopService.selectOneIprOrderShop(iprOrderShop);
					  if(iprOrderShop!=null)
					  {
						  List<OrderPayment> l_OrderPayment=new ArrayList<OrderPayment>();
						  OrderPayment payment=new OrderPayment();
						  if("1".equals(iprOrderShop.getOrderkind()))   //商标
						  {
							  IprBrandOrderShop brandOrderShop=iprOrderShopService.selectIprBrandOrderShop(iprOrderShop);
							  if("2".equals(brandOrderShop.getBrandstate()))
							  {
							     payment.setBrandOrderShop(brandOrderShop);
							  }
							  else
							  {
								  payment.setBrandOrderShop(brandOrderShop);
								  orderPaymentList.setSailflag("2");
							  }
						  }
						  else if("2".equals(iprOrderShop.getOrderkind()))//版权
						  {
							  IprCopyrightOrderShop copyrightOrderShop=iprOrderShopService.selectIprCopyrightOrderShop(iprOrderShop);
							  if("2".equals(copyrightOrderShop.getCopyrightstate()))
							  {
							      payment.setCopyrightOrderShop(copyrightOrderShop);
							  }
							  else
							  {
								  payment.setCopyrightOrderShop(copyrightOrderShop);
								  orderPaymentList.setSailflag("2");
							  }
						  }
						  else if("3".equals(iprOrderShop.getOrderkind()))//专利
						  {
							  IprPatentOrderShop patentOrderShop=iprOrderShopService.selectIprPatentOrderShop(iprOrderShop);
							  if("2".equals(patentOrderShop.getPatentstatus()))
							  {
								  payment.setPatentOrderShop(patentOrderShop);
							  }
							  else
							  {
								  payment.setPatentOrderShop(patentOrderShop);
								  orderPaymentList.setSailflag("2");
							  }
						  }
						  l_OrderPayment.add(payment);
						  orderPaymentList.setL_OrderPayment(l_OrderPayment);
						  return SUCCESS;
					  }
					  else
					  {
						  return "404";
					  }
				  }
				  else if("3".equals(ordertype)) //企业服务
				  {
					  EsOrderServices esOrderService=new EsOrderServices();
					  esOrderService.setOrdercode(ordercode);
					  esOrderService.setUserid(wqtuser.getId());
					  esOrderService=esOrderServiceService.selectOneEsOrderService(esOrderService);
					  if(esOrderService!=null)
					  {
						  List<OrderPayment> l_OrderPayment=new ArrayList<OrderPayment>();
						  OrderPayment payment=new OrderPayment();
						  payment.setEsOrderService(esOrderService); 
						  l_OrderPayment.add(payment);
						  orderPaymentList.setL_OrderPayment(l_OrderPayment);
						  return SUCCESS;
					  }
					  else
					  {
						  return "404"; 
					  }
				  }
				  else if("4".equals(ordertype)) //企业交易
				  {
					  EsOrderTrade esOrderTrade=new EsOrderTrade();
					  esOrderTrade.setOrdercode(ordercode);
					  esOrderTrade.setBuyerid(wqtuser.getId());
					  esOrderTrade=esOrderTradeService.selectOneEsOrderTrade(esOrderTrade);
					  if(esOrderTrade!=null)
					  {
						  List<OrderPayment> l_OrderPayment=new ArrayList<OrderPayment>();
						  OrderPayment payment=new OrderPayment();
						  payment.setEsOrderTrade(esOrderTrade); 
						  l_OrderPayment.add(payment);
						  orderPaymentList.setL_OrderPayment(l_OrderPayment);
						  return SUCCESS;
					  }
					  else
					  {
						  return "404"; 
					  }
				  }
				  else if("6".equals(ordertype)) //网店转让订单
				  {
					  EShopOrder  eShopOrder=new EShopOrder();
					  eShopOrder.setOrdercode(ordercode);
					  eShopOrder.setBuyerid(Integer.parseInt(wqtuser.getId()));
					  eShopOrder=eShopOrderService.selectOneEShopOrder(eShopOrder);
					  if(eShopOrder!=null)
					  {
						  List<OrderPayment> l_OrderPayment=new ArrayList<OrderPayment>();
						  OrderPayment payment=new OrderPayment();
						  payment.seteShopOrder(eShopOrder);
						  l_OrderPayment.add(payment);
						  orderPaymentList.setL_OrderPayment(l_OrderPayment);
						  return SUCCESS;
					  }
					  else
					  {
						  return "404";  
					  }
					 
				  }
				  else if("5".equals(ordertype)) //多个订单付款列表
				  {
					  String[] codearry=ordercode.split(",");
					  if(codearry.length>0)
					  {
						  List<OrderPayment> l_OrderPayment=new ArrayList<OrderPayment>();
						  for(int i=0;i<codearry.length;i++)
						  {
							  if(codearry[i]!=null && (!"".equals(codearry[i])))
							  {
								  if("6001".equals(codearry[i].substring(0,4)) || "6002".equals(codearry[i].substring(0,4)) 
										  || "6003".equals(codearry[i].substring(0,4)))  //知识产权服务
								  {
									  IprOrderProduct iprOrderProduct=new IprOrderProduct();  
									  iprOrderProduct.setOrdercode(codearry[i]);
									  iprOrderProduct.setUserid(wqtuser.getId());
									  iprOrderProduct=iprOrderProductService.selectOneIprOrderProduct(iprOrderProduct);
									  if(iprOrderProduct!=null)
									  {
										  OrderPayment payment=new OrderPayment();
										  if("1".equals(iprOrderProduct.getOrderkind()))   //商标
										  {
											  IprBrandOrderProduct brandOrderProduct=iprOrderProductService.selectIprBrandOrderProduct(iprOrderProduct);
											  payment.setBrandOrderProduct(brandOrderProduct);
										  }
										  else if("2".equals(iprOrderProduct.getOrderkind()))//版权
										  {
											  IprCopyrightOrderProduct copyrightOrderProduct=iprOrderProductService.selectIprCopyrightOrderProduct(iprOrderProduct);
											  payment.setCopyrightOrderProduct(copyrightOrderProduct);
										  }
										  else if("3".equals(iprOrderProduct.getOrderkind()))//专利
										  {
											  IprPatentOrderProduct patentOrderProduct=iprOrderProductService.selectIprPatentOrderProduct(iprOrderProduct);
											  payment.setPatentOrderProduct(patentOrderProduct);
										  }
										  l_OrderPayment.add(payment);
										  orderPaymentList.setL_OrderPayment(l_OrderPayment);
									  }
									  
								  }
								  else if("8001".equals(codearry[i].substring(0,4)) || "8002".equals(codearry[i].substring(0,4))
										  || "8003".equals(codearry[i].substring(0,4)) )
                                  {
									  IprOrderShop iprOrderShop=new IprOrderShop();  
									  iprOrderShop.setOrdercode(codearry[i]);
									  iprOrderShop.setBuyerid(wqtuser.getId());
									  iprOrderShop=iprOrderShopService.selectOneIprOrderShop(iprOrderShop);
									  if(iprOrderShop!=null)
									  {
										  OrderPayment payment=new OrderPayment();
										  if("1".equals(iprOrderShop.getOrderkind()))   //商标
										  {
											  IprBrandOrderShop brandOrderShop=iprOrderShopService.selectIprBrandOrderShop(iprOrderShop);
											  payment.setBrandOrderShop(brandOrderShop);
										  }
										  else if("2".equals(iprOrderShop.getOrderkind()))//版权
										  {
											  IprCopyrightOrderShop copyrightOrderShop=iprOrderShopService.selectIprCopyrightOrderShop(iprOrderShop);
											  payment.setCopyrightOrderShop(copyrightOrderShop);
										  }
										  else if("3".equals(iprOrderShop.getOrderkind()))//专利
										  {
											  IprPatentOrderShop patentOrderShop=iprOrderShopService.selectIprPatentOrderShop(iprOrderShop);
											  payment.setPatentOrderShop(patentOrderShop);
										  }
										  l_OrderPayment.add(payment);
										  orderPaymentList.setL_OrderPayment(l_OrderPayment);
									  }
								  }
								  else if("6004".equals(codearry[i].substring(0,4)))
                                  {
									  EsOrderServices esOrderService=new EsOrderServices();
									  esOrderService.setOrdercode(ordercode);
									  esOrderService.setUserid(wqtuser.getId());
									  esOrderService=esOrderServiceService.selectOneEsOrderService(esOrderService);
									  if(esOrderService!=null)
									  {
										  OrderPayment payment=new OrderPayment();
										  payment.setEsOrderService(esOrderService); 
										  l_OrderPayment.add(payment);
										  orderPaymentList.setL_OrderPayment(l_OrderPayment);
									  }
								  }
								  else if("8004".equals(codearry[i].substring(0,4)))
                                  {
									  EsOrderTrade esOrderTrade=new EsOrderTrade();
									  esOrderTrade.setOrdercode(ordercode);
									  esOrderTrade.setBuyerid(wqtuser.getId());
									  esOrderTrade=esOrderTradeService.selectOneEsOrderTrade(esOrderTrade);
									  if(esOrderTrade!=null)
									  {
										  OrderPayment payment=new OrderPayment();
										  payment.setEsOrderTrade(esOrderTrade); 
										  l_OrderPayment.add(payment);
										  orderPaymentList.setL_OrderPayment(l_OrderPayment);
										 
									  }
								  }
								  else if("8005".equals(codearry[i].substring(0,4)))
                                  {
									  EShopOrder  eShopOrder=new EShopOrder();
									  eShopOrder.setOrdercode(ordercode);
									  eShopOrder.setBuyerid(Integer.parseInt(wqtuser.getId()));
									  eShopOrder=eShopOrderService.selectOneEShopOrder(eShopOrder);
									  if(eShopOrder!=null)
									  {
										  OrderPayment payment=new OrderPayment();
										  payment.seteShopOrder(eShopOrder);
										  l_OrderPayment.add(payment);
										  orderPaymentList.setL_OrderPayment(l_OrderPayment);
									  }
								  }
							  }
						  }
						  return SUCCESS;
					  }
					  else
					  {
						  return "404"; 
					  }
				  }
				  else
				  {
					  return "404";
				  }
				  
			  }
			  else   //用户没有登录
			  {
				  response.sendRedirect(PropertiesUtil.rs.get("casserver")+"?service="+serverurl+"/order/pay/"+ordercode+"/type/"+ordertype);
				  return null;
				  //return "login";
			  }
		}
	    catch(Exception e)
		{
	    	return "404";
		}
	  
	}
	
	/*知识产权产品订单-买家*/
	public String iprProductOrder()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
	    Session session = SessionFactory.getInstance(request, response);
	    Object user = (Object) session.getAttribute("LOGINSESSIOIN");
				
	    // 获取此请求的地址          
	    StringBuffer url=request.getRequestURL();
		String srcurl=url.toString();
	    Map resultData = new HashMap();
	    try {
	    	   srcurl=srcurl.substring(0, srcurl.indexOf("iprProductOrder"));
			   if(user!=null)
			   {
				   UserBasic wqtUserBasic = (UserBasic) user;
				   IprOrderProduct iprProductOrder=new IprOrderProduct();
				   iprProductOrder.setUserid(wqtUserBasic.getId());

				   if (pagination == null) 
				   {
					    pagination = new Pagination(1, 10);
				   }
				   Pagination page = null;
				   page=iprOrderProductService.selectIprOrderProductPage(iprProductOrder, pagination);
				   List<WqtUserPost> l=page.getList();
				   Map<String, Object> jsonMap = new HashMap<String, Object>();
				   jsonMap.put("total", page.getCount());//total键 存放总记录数，必须的  
				   jsonMap.put("pages", page.getAllPage());//total键 存放总记录数，必须的  pa
				   jsonMap.put("rows", l);//rows键 存放每页记录 list  
				   resultData.put("result", "1");
				   resultData.put("msg", jsonMap);
	           }
			   else
			   {
				   resultData.put("result", "2");
				   resultData.put("msg", "srcurl="+srcurl+"postaddr");
			   }
		   } catch (Exception e) {
				e.printStackTrace();
			}
		this.formatData(resultData); 
		return SUCCESS;
	}
	

    /*知识产权交易订单--买家*/
	public String iprOrderShopBuy()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
	    Session session = SessionFactory.getInstance(request, response);
	    Object user = (Object) session.getAttribute("LOGINSESSIOIN");
				
	    // 获取此请求的地址          
	    StringBuffer url=request.getRequestURL();
		String srcurl=url.toString();
	    Map resultData = new HashMap();
	    try {
	    	   srcurl=srcurl.substring(0, srcurl.indexOf("iprOrderShopBuy"));
			   if(user!=null)
			   {
				   UserBasic wqtUserBasic = (UserBasic) user;
				   IprOrderShop iprOrderShopBuy=new IprOrderShop();
				   iprOrderShopBuy.setBuyerid(wqtUserBasic.getId());

				   if (pagination == null) 
				   {
					    pagination = new Pagination(1, 10);
				   }
				   Pagination page = null;
				   page=iprOrderShopService.selectIprOrderShopPage(iprOrderShopBuy, pagination);
				   List<WqtUserPost> l=page.getList();
				   Map<String, Object> jsonMap = new HashMap<String, Object>();
				   jsonMap.put("total", page.getCount());//total键 存放总记录数，必须的  
				   jsonMap.put("pages", page.getAllPage());//total键 存放总记录数，必须的  pa
				   jsonMap.put("rows", l);//rows键 存放每页记录 list  
				   resultData.put("result", "1");
				   resultData.put("msg", jsonMap);
	           }
			   else
			   {
				   resultData.put("result", "2");
				   resultData.put("msg", "srcurl="+srcurl+"postaddr");
			   }
		   } catch (Exception e) {
				e.printStackTrace();
			}
		this.formatData(resultData); 
		return SUCCESS;
	}
	
	/*知识产权交易订单--卖家*/
	public String iprOrderShopSell()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
	    Session session = SessionFactory.getInstance(request, response);
	    Object user = (Object) session.getAttribute("LOGINSESSIOIN");
				
	    // 获取此请求的地址          
	    StringBuffer url=request.getRequestURL();
		String srcurl=url.toString();
	    Map resultData = new HashMap();
	    try {
	    	   srcurl=srcurl.substring(0, srcurl.indexOf("iprOrderShopSell")); 
			   if(user!=null)
			   {
				   UserBasic wqtUserBasic = (UserBasic) user;
				   IprOrderShop iprOrderShopSell=new IprOrderShop();
				   iprOrderShopSell.setSellerid(wqtUserBasic.getId());

				   if (pagination == null) 
				   {
					    pagination = new Pagination(1, 10);
				   }
				   Pagination page = null;
				   page=iprOrderShopService.selectIprOrderShopPage(iprOrderShopSell, pagination);
				   List<WqtUserPost> l=page.getList();
				   Map<String, Object> jsonMap = new HashMap<String, Object>();
				   jsonMap.put("total", page.getCount());//total键 存放总记录数，必须的  
				   jsonMap.put("pages", page.getAllPage());//total键 存放总记录数，必须的  pa
				   jsonMap.put("rows", l);//rows键 存放每页记录 list  
				   resultData.put("result", "1");
				   resultData.put("msg", jsonMap);
	           }
			   else
			   {
				   resultData.put("result", "2");
				   resultData.put("msg", "srcurl="+srcurl+"postaddr");
			   }
		   } catch (Exception e) {
				e.printStackTrace();
			}
		this.formatData(resultData); 
		return SUCCESS;
	}
	
}
