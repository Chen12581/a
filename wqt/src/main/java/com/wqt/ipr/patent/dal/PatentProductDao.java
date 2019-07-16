package com.wqt.ipr.patent.dal;

import java.util.List;

import com.talkweb.twdpe.dal.batis.spring.SessionDaoSupport;
import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.ipr.patent.pojo.IprPatentProduct;

public class PatentProductDao  extends SessionDaoSupport{

	 /*查询专利服务的产品*/
   public List<IprPatentProduct> selectIprPatentProductList(IprPatentProduct iprPatentProduct)
   {
	     List<IprPatentProduct> list = this.getSession().selectList("iprpatent.selectIprPatentProductList",iprPatentProduct);
		 return list;
   }
 
   /*分页查询专利服务的产品*/
   public Pagination  selectIprPatentProductPage(IprPatentProduct iprPatentProduct,Pagination pagination){
		@SuppressWarnings("unchecked")
		List<IprPatentProduct> list =this.getSession().selectList("iprpatent.selectIprPatentProductList", iprPatentProduct, pagination);
		pagination.setList(list);
		return pagination;
   }

   
   public IprPatentProduct selIprPatentProductOne(IprPatentProduct iprPatentProduct) {
	   return (IprPatentProduct) this.getSession().selectOne("iprpatent.selIprPatentProductOne",iprPatentProduct);   
   }
}
