/**
 * ServiceUtilisateurLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package integration;

public class ServiceUtilisateurLocator extends org.apache.axis.client.Service implements integration.ServiceUtilisateur {

    public ServiceUtilisateurLocator() {
    }


    public ServiceUtilisateurLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ServiceUtilisateurLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for serviceUtilisateurPort
    private java.lang.String serviceUtilisateurPort_address = "http://localhost/TheNewscv2/domaine/soap.class.php";

    public java.lang.String getserviceUtilisateurPortAddress() {
        return serviceUtilisateurPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String serviceUtilisateurPortWSDDServiceName = "serviceUtilisateurPort";

    public java.lang.String getserviceUtilisateurPortWSDDServiceName() {
        return serviceUtilisateurPortWSDDServiceName;
    }

    public void setserviceUtilisateurPortWSDDServiceName(java.lang.String name) {
        serviceUtilisateurPortWSDDServiceName = name;
    }

    public integration.ServiceUtilisateurPortType getserviceUtilisateurPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(serviceUtilisateurPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getserviceUtilisateurPort(endpoint);
    }

    public integration.ServiceUtilisateurPortType getserviceUtilisateurPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            integration.ServiceUtilisateurBindingStub _stub = new integration.ServiceUtilisateurBindingStub(portAddress, this);
            _stub.setPortName(getserviceUtilisateurPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setserviceUtilisateurPortEndpointAddress(java.lang.String address) {
        serviceUtilisateurPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (integration.ServiceUtilisateurPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                integration.ServiceUtilisateurBindingStub _stub = new integration.ServiceUtilisateurBindingStub(new java.net.URL(serviceUtilisateurPort_address), this);
                _stub.setPortName(getserviceUtilisateurPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("serviceUtilisateurPort".equals(inputPortName)) {
            return getserviceUtilisateurPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("urn:serviceUtilisateurWsdl", "serviceUtilisateur");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("urn:serviceUtilisateurWsdl", "serviceUtilisateurPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("serviceUtilisateurPort".equals(portName)) {
            setserviceUtilisateurPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
