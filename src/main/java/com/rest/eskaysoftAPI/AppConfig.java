package com.rest.eskaysoftAPI;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.rest.eskaysoftAPI.resource.AccountInformationResource;
import com.rest.eskaysoftAPI.resource.AccountOpeningsResource;
import com.rest.eskaysoftAPI.resource.AreaResource;
import com.rest.eskaysoftAPI.resource.BankInformationResource;
import com.rest.eskaysoftAPI.resource.BusinessExecutiveResource;
import com.rest.eskaysoftAPI.resource.CompanyResource;
import com.rest.eskaysoftAPI.resource.CompnayGroupResource;
import com.rest.eskaysoftAPI.resource.CustomerWiseDiscountsResource;
import com.rest.eskaysoftAPI.resource.DistrictResource;
import com.rest.eskaysoftAPI.resource.ManfacturerResource;
import com.rest.eskaysoftAPI.resource.ProductCategoryResource;
import com.rest.eskaysoftAPI.resource.ProductGroupResource;
import com.rest.eskaysoftAPI.resource.ProductResource;
import com.rest.eskaysoftAPI.resource.ScheduleResource;
import com.rest.eskaysoftAPI.resource.StateResource;
import com.rest.eskaysoftAPI.resource.SubScheduleResource;

@Component
public class AppConfig extends ResourceConfig {

	public AppConfig() {
		register(ScheduleResource.class);
		register(SubScheduleResource.class);
		register(AreaResource.class);
		register(BankInformationResource.class);
		register(ManfacturerResource.class);
		register(ProductGroupResource.class);
		register(ProductCategoryResource.class);
		register(ProductResource.class);
		register(CustomerWiseDiscountsResource.class);
		register(StateResource.class);
		register(DistrictResource.class);
		register(CompanyResource.class);
		register(CompnayGroupResource.class);
		register(BusinessExecutiveResource.class);
		register(AccountOpeningsResource.class);
		register(BusinessExecutiveResource.class);
		register(AccountInformationResource.class);
	}
}
