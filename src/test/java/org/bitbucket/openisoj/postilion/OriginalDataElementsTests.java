package org.bitbucket.openisoj.postilion;

import static org.junit.Assert.*;

import org.bitbucket.openisoj.Iso8583;
import org.junit.Test;

public class OriginalDataElementsTests
{
	@Test
	public void testPacking()
	{
		OriginalDataElements ogElements = new OriginalDataElements();
		ogElements.setOriginalMsgType(Iso8583Postilion.MsgType._0200_TRAN_REQ);
		ogElements.setOriginalSysTrace("123456");
		ogElements.setOriginalTransmissionDateTime("1234567890");
		ogElements.setOriginalAcquirerInstIdCode("678901");
		ogElements.setOriginalForwardingInstIdCode("109876");

		String ogElementsString = ogElements.toMsg();
		assertEquals(42, ogElementsString.length());
		assertEquals("020012345612345678900000067890100000109876",
				ogElementsString);
	}

	@Test
	public void testUnpacking()
	{
		String ogElementsString = "020012345612345678900000067890100000109876";
		OriginalDataElements elements = new OriginalDataElements(
				ogElementsString);
		assertEquals(Iso8583.MsgType._0200_TRAN_REQ,
				elements.getOriginalMsgType());
		assertEquals("123456", elements.getOriginalSysTrace());
		assertEquals("1234567890", elements.getOriginalTransmissionDateTime());
		assertEquals("678901", elements.getOriginalAcquirerInstIdCode());
		assertEquals("109876", elements.getOriginalForwardingInstIdCode());
	}
}
