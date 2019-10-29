package com.example.soapclient;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import hello.wsdl.GetUniversityRequest;
import hello.wsdl.GetUniversityResponse;

public class UniversityClient extends WebServiceGatewaySupport{


    //private static final Logger log = LoggerFactory.getLogger(SchoolClient.class);

    public GetUniversityResponse getUniversity(String university) {

        GetUniversityRequest request = new GetUniversityRequest();
        request.setName(university);

        //log.info("Requesting location for " + country);

        GetUniversityResponse response = (GetUniversityResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/universities", request);

        return response;
    }

}
