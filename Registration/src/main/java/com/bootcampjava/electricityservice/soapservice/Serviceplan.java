
package com.bootcampjava.electricityservice.soapservice;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "serviceplan", targetNamespace = "http://serviceplan.soapservice.webservices.services.electricityservice.cmsenergy.com/", wsdlLocation = "http://localhost:8181/electricityservice/soap/getserviceplans?wsdl")
public class Serviceplan
    extends Service
{

    private final static URL SERVICEPLAN_WSDL_LOCATION;
    private final static WebServiceException SERVICEPLAN_EXCEPTION;
    private final static QName SERVICEPLAN_QNAME = new QName("http://serviceplan.soapservice.webservices.services.electricityservice.cmsenergy.com/", "serviceplan");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8181/electricityservice/soap/getserviceplans?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SERVICEPLAN_WSDL_LOCATION = url;
        SERVICEPLAN_EXCEPTION = e;
    }

    public Serviceplan() {
        super(__getWsdlLocation(), SERVICEPLAN_QNAME);
    }

    public Serviceplan(WebServiceFeature... features) {
        super(__getWsdlLocation(), SERVICEPLAN_QNAME, features);
    }

    public Serviceplan(URL wsdlLocation) {
        super(wsdlLocation, SERVICEPLAN_QNAME);
    }

    public Serviceplan(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SERVICEPLAN_QNAME, features);
    }

    public Serviceplan(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Serviceplan(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns PowerPlanService
     */
    @WebEndpoint(name = "PowerPlanServiceImplPort")
    public PowerPlanService getPowerPlanServiceImplPort() {
        return super.getPort(new QName("http://serviceplan.soapservice.webservices.services.electricityservice.cmsenergy.com/", "PowerPlanServiceImplPort"), PowerPlanService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns PowerPlanService
     */
    @WebEndpoint(name = "PowerPlanServiceImplPort")
    public PowerPlanService getPowerPlanServiceImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://serviceplan.soapservice.webservices.services.electricityservice.cmsenergy.com/", "PowerPlanServiceImplPort"), PowerPlanService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SERVICEPLAN_EXCEPTION!= null) {
            throw SERVICEPLAN_EXCEPTION;
        }
        return SERVICEPLAN_WSDL_LOCATION;
    }

}
