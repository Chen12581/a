package com.wqt.user.pojo;

import com.wqt.es.order.pojo.EsOrderServices;
import com.wqt.es.order.pojo.EsOrderTrade;
import com.wqt.eshop.pojo.EShopOrder;
import com.wqt.ipr.order.pojo.IprBrandOrderProduct;
import com.wqt.ipr.order.pojo.IprBrandOrderShop;
import com.wqt.ipr.order.pojo.IprCopyrightOrderProduct;
import com.wqt.ipr.order.pojo.IprCopyrightOrderShop;
import com.wqt.ipr.order.pojo.IprPatentOrderProduct;
import com.wqt.ipr.order.pojo.IprPatentOrderShop;
import com.user.pojo.UserBasic;

/*支付页面对象*/
public class OrderPayment {
    private IprBrandOrderProduct brandOrderProduct;  //商标服务产品订单详情对象
	
	private IprCopyrightOrderProduct copyrightOrderProduct; //版权服务产品订单详情对象
	
	private IprPatentOrderProduct patentOrderProduct;  //专利服务产品订单详情对象
	
	private IprBrandOrderShop brandOrderShop;  //交易商标订单详情对象
	
	private IprCopyrightOrderShop copyrightOrderShop;  //交易版权订单详情对象
	
	private IprPatentOrderShop patentOrderShop;  //交易专利订单详情对象
	
	private EsOrderServices esOrderService;
	
	private EsOrderTrade esOrderTrade;
	
	private EShopOrder eShopOrder;
	
	private UserBasic wqtUserBasic;
	
	
	public EShopOrder geteShopOrder() {
		return eShopOrder;
	}

	public void seteShopOrder(EShopOrder eShopOrder) {
		this.eShopOrder = eShopOrder;
	}

	public UserBasic getWqtUserBasic() {
		return wqtUserBasic;
	}

	public void setWqtUserBasic(UserBasic wqtUserBasic) {
		this.wqtUserBasic = wqtUserBasic;
	}

	public EsOrderServices getEsOrderService() {
		return esOrderService;
	}

	public void setEsOrderService(EsOrderServices esOrderService) {
		this.esOrderService = esOrderService;
	}

	public EsOrderTrade getEsOrderTrade() {
		return esOrderTrade;
	}

	public void setEsOrderTrade(EsOrderTrade esOrderTrade) {
		this.esOrderTrade = esOrderTrade;
	}

	public IprPatentOrderProduct getPatentOrderProduct() {
		return patentOrderProduct;
	}

	public void setPatentOrderProduct(IprPatentOrderProduct patentOrderProduct) {
		this.patentOrderProduct = patentOrderProduct;
	}

	public IprBrandOrderProduct getBrandOrderProduct() {
		return brandOrderProduct;
	}

	public void setBrandOrderProduct(IprBrandOrderProduct brandOrderProduct) {
		this.brandOrderProduct = brandOrderProduct;
	}

	public IprCopyrightOrderProduct getCopyrightOrderProduct() {
		return copyrightOrderProduct;
	}

	public void setCopyrightOrderProduct(
			IprCopyrightOrderProduct copyrightOrderProduct) {
		this.copyrightOrderProduct = copyrightOrderProduct;
	}

	public IprBrandOrderShop getBrandOrderShop() {
		return brandOrderShop;
	}

	public void setBrandOrderShop(IprBrandOrderShop brandOrderShop) {
		this.brandOrderShop = brandOrderShop;
	}

	public IprCopyrightOrderShop getCopyrightOrderShop() {
		return copyrightOrderShop;
	}

	public void setCopyrightOrderShop(IprCopyrightOrderShop copyrightOrderShop) {
		this.copyrightOrderShop = copyrightOrderShop;
	}


	public IprPatentOrderShop getPatentOrderShop() {
		return patentOrderShop;
	}


	public void setPatentOrderShop(IprPatentOrderShop patentOrderShop) {
		this.patentOrderShop = patentOrderShop;
	}
	
	
}
