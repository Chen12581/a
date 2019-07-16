package com.wqt.ipr.copyright.service;

import java.util.List;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.ipr.copyright.pojo.IprCopyrightProduct;

public interface CopyrightProductService {
	
	public Pagination selectCopyrightProduct(IprCopyrightProduct iprCopyrightProduct,Pagination pagination);
	
	
	public Pagination selectCopyrightProductPage(IprCopyrightProduct iprCopyrightProduct,Pagination pagination);
	
	public IprCopyrightProduct selectCopyrightProductOne(IprCopyrightProduct iprCopyrightProduct);
	
}
