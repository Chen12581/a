package com.wqt.ipr.patent.service;

import java.util.List;
import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.ipr.patent.pojo.IprPatentProduct;



public interface PatentProductService {
	 /*查询专利服务的产品*/
     public List<IprPatentProduct> selectIprPatentProductList(IprPatentProduct iprPatentProduct);

     /*分页查询专利服务的产品*/
     public Pagination  selectIprPatentProductPage(IprPatentProduct iprPatentProduct,Pagination pagination);
     
     
     public IprPatentProduct selIprPatentProductOne(IprPatentProduct iprPatentProduct);
}
