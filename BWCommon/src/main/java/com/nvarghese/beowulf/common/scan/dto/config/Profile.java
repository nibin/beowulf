//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB)
// Reference Implementation, vJAXB 2.1.10 in JDK 6
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source
// schema.
// Generated on: 2012.10.01 at 01:12:11 AM IST
//

package com.nvarghese.beowulf.common.scan.dto.config;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}http_client"/>
 *         &lt;element ref="{}scan_settings"/>
 *         &lt;element ref="{}report_settings"/>
 *         &lt;element ref="{}session_settings"/>
 *         &lt;element ref="{}test_modules"/>
 *       &lt;/sequence>
 *       &lt;attribute name="version" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "httpClient", "scanSettings", "reportSettings", "sessionSettings", "testModules" })
@XmlRootElement(name = "profile")
public class Profile {

	@XmlElement(name = "http_client", required = true)
	protected HttpClient httpClient;
	@XmlElement(name = "scan_settings", required = true)
	protected ScanSettings scanSettings;
	@XmlElement(name = "report_settings", required = true)
	protected ReportSettings reportSettings;
	@XmlElement(name = "session_settings", required = true)
	protected SessionSettings sessionSettings;
	@XmlElement(name = "test_modules", required = true)
	protected TestModules testModules;
	@XmlAttribute(required = true)
	protected BigDecimal version;

	/**
	 * Gets the value of the httpClient property.
	 * 
	 * @return possible object is {@link HttpClient }
	 * 
	 */
	public HttpClient getHttpClient() {

		return httpClient;
	}

	/**
	 * Sets the value of the httpClient property.
	 * 
	 * @param value
	 *            allowed object is {@link HttpClient }
	 * 
	 */
	public void setHttpClient(HttpClient value) {

		this.httpClient = value;
	}

	/**
	 * Gets the value of the scanSettings property.
	 * 
	 * @return possible object is {@link ScanSettings }
	 * 
	 */
	public ScanSettings getScanSettings() {

		return scanSettings;
	}

	/**
	 * Sets the value of the scanSettings property.
	 * 
	 * @param value
	 *            allowed object is {@link ScanSettings }
	 * 
	 */
	public void setScanSettings(ScanSettings value) {

		this.scanSettings = value;
	}

	/**
	 * Gets the value of the reportSettings property.
	 * 
	 * @return possible object is {@link ReportSettings }
	 * 
	 */
	public ReportSettings getReportSettings() {

		return reportSettings;
	}

	/**
	 * Sets the value of the reportSettings property.
	 * 
	 * @param value
	 *            allowed object is {@link ReportSettings }
	 * 
	 */
	public void setReportSettings(ReportSettings value) {

		this.reportSettings = value;
	}

	/**
	 * Gets the value of the sessionSettings property.
	 * 
	 * @return possible object is {@link SessionSettings }
	 * 
	 */
	public SessionSettings getSessionSettings() {

		return sessionSettings;
	}

	/**
	 * Sets the value of the sessionSettings property.
	 * 
	 * @param value
	 *            allowed object is {@link SessionSettings }
	 * 
	 */
	public void setSessionSettings(SessionSettings value) {

		this.sessionSettings = value;
	}

	/**
	 * Gets the value of the testModules property.
	 * 
	 * @return possible object is {@link TestModules }
	 * 
	 */
	public TestModules getTestModules() {

		return testModules;
	}

	/**
	 * Sets the value of the testModules property.
	 * 
	 * @param value
	 *            allowed object is {@link TestModules }
	 * 
	 */
	public void setTestModules(TestModules value) {

		this.testModules = value;
	}

	/**
	 * Gets the value of the version property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getVersion() {

		return version;
	}

	/**
	 * Sets the value of the version property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setVersion(BigDecimal value) {

		this.version = value;
	}

}
