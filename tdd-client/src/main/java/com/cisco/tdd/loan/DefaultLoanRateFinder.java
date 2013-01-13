package com.cisco.tdd.loan;

import java.util.Arrays;
import java.util.List;

import javax.xml.namespace.QName;

import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;

import com.cisco.tdd.common.LoanRate;
import com.cisco.tdd.common.LoanRateFinder;

public class DefaultLoanRateFinder implements LoanRateFinder {

	@Override
	public List<LoanRate> listAll() {
		try {
			RPCServiceClient target = new RPCServiceClient();
			Options options = target.getOptions();
			EndpointReference targetEPR = new EndpointReference(
					"http://localhost:8080/axis2/services/LoanRateService");
			options.setTo(targetEPR);
			Object[] args = new Object[] {};
			QName opName = new QName("http://localhost:8080/axis2", "listAll");
			Class<?>[] returnTypes = new Class<?>[] { LoanRate[].class };
			return Arrays.asList((LoanRate[]) target.invokeBlocking(opName, args, returnTypes)[0]);
		} catch (AxisFault e) {
			throw new RuntimeException(e);
		}
	}

}
