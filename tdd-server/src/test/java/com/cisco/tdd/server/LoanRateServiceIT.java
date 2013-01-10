package com.cisco.tdd.server;

import javax.xml.namespace.QName;

import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;
import org.junit.Before;
import org.junit.Test;

import com.cisco.tdd.common.LoanRate;

public class LoanRateServiceIT {

	private RPCServiceClient target;

	@Before
	public void setUp() throws Exception {
		target = new RPCServiceClient();
		Options options = target.getOptions();
		EndpointReference targetEPR = new EndpointReference(
				"http://localhost:8080/axis2/services/LoanRateService");
		options.setTo(targetEPR);
	}

	@Test
	public void testListAllLoanRates() throws AxisFault {
		Object[] args = new Object[] {};
		QName opName = new QName("http://localhost:8080/axis2", "listAll");
		Class<?>[] returnTypes = new Class<?>[] { LoanRate[].class };
		LoanRate[] loanRates = (LoanRate[]) target.invokeBlocking(opName, args, returnTypes)[0];
		AssertUtils.assertLoanRate(loanRates);
	}
	
}
