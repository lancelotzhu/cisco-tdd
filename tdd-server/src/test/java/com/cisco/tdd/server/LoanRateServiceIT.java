package com.cisco.tdd.server;

import java.util.List;

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
	@SuppressWarnings("unchecked")
	public void testListAllLoanRates() throws AxisFault {
		Object[] args = new Object[] {};
		QName opName = new QName("http://localhost:8080/axis2", "listAll");
		Object[] returnTypes = new Object[] { List.class };
		List<LoanRate> loanRateList = (List<LoanRate>) target.invokeBlocking(
				opName, args, returnTypes)[0];
		LoanRate[] loanRates = loanRateList.toArray(new LoanRate[0]);
		AssertUtils.assertLoanRate(loanRates);
	}

}
