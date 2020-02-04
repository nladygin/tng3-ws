package ru.hrs.lassd.club.ws.helper;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.SoapFaultClientException;
import org.springframework.xml.transform.StringResult;
import org.springframework.xml.transform.StringSource;
import ru.hrs.lassd.club.ws.config.AppConfig;
import ru.hrs.lassd.club.ws.entity.Fault;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.io.StringWriter;

@Component
public class SOAPHelper {

    public Object go(Object request) {

        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("ru.hrs.lassd.club.ws.schema");

        StringResult req = new StringResult();
        marshaller.marshal(request, req);

            LogManager.getLogger().info("REQUEST:\n" + prettyPrint(req.toString()));

            WebServiceTemplate ws = new WebServiceTemplate(marshaller, marshaller);
            ws.setDefaultUri(appConfig.serverURL);

            /* + CURLS FOR LOGS */
                StreamSource source = new StreamSource(new StringReader(req.toString()));
                StringWriter stringWriter = new StringWriter();
                StreamResult result = new StreamResult(stringWriter);

                    try {

                        ws.sendSourceAndReceiveToResult(source, result);
                            LogManager.getLogger().info("RESPONSE:\n" + prettyPrint(stringWriter.toString()));
                        return marshaller.unmarshal(new StringSource(stringWriter.toString()));

                    } catch (SoapFaultClientException e) {
                        try {

                            Source faultSource = e.getSoapFault().getSource();
                                TransformerFactory.newInstance().newTransformer().transform(faultSource, result);
                                    LogManager.getLogger().info("RESPONSE:\n" + prettyPrint(stringWriter.toString()));
                            return new Fault(e.getFaultStringOrReason());

                        } catch (TransformerException ex) {
                            LogManager.getLogger().error("Cannot to transform response");
                            ex.printStackTrace();
                            return null;
                        }
                    }


            /* - CURLS FOR LOGS */

//            return ws.marshalSendAndReceive(request); //EASIEST WAY BUT NO LOGS
    }




    public String prettyPrint(String xmlString) {
            try {
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                    transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
                        StringWriter stringWriter = new StringWriter();
                        StreamResult xmlOutput = new StreamResult(stringWriter);
                            Source xmlInput = new StreamSource(new StringReader(xmlString));
                            transformer.transform(xmlInput, xmlOutput);
                return xmlOutput.getWriter().toString();
            } catch (TransformerException e) {
                LogManager.getLogger().error("String transform exception \n" + xmlString);
                return "";
            }
        }


    @Autowired private AppConfig appConfig;
}
