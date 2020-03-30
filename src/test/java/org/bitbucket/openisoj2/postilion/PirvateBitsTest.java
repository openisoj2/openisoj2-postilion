package org.bitbucket.openisoj2.postilion;

import static org.junit.Assert.*;

import org.bitbucket.openisoj2.postilion.structdata.StructuredData;
import org.junit.Test;

public class PirvateBitsTest
{
	@Test
	public void testPackAndUnpack() throws Exception
	{
		Iso8583Postilion msg = new Iso8583Postilion();
		msg.setMsgType(Iso8583Postilion.MsgType._0200_TRAN_REQ);
		msg.setPrivate(Iso8583Postilion.PrivateBits._002_SWITCH_KEY,
				"TEST SWITCH KEY");

		assertTrue(msg
				.isPrivateFieldSet(Iso8583Postilion.PrivateBits._002_SWITCH_KEY));

		String value = msg
				.getPrivate(Iso8583Postilion.PrivateBits._002_SWITCH_KEY);
		assertEquals("TEST SWITCH KEY", value);

		byte[] packedData = msg.toMsg();
		Iso8583Postilion newMsg = new Iso8583Postilion();
		newMsg.unpack(packedData, 0);

		assertTrue(newMsg
				.isPrivateFieldSet(Iso8583Postilion.PrivateBits._002_SWITCH_KEY));

		String newValue = newMsg
				.getPrivate(Iso8583Postilion.PrivateBits._002_SWITCH_KEY);
		assertEquals("TEST SWITCH KEY", newValue);

	}

	@Test
	public void testPackingStructuredData() throws Exception
	{
		StructuredData sData = new StructuredData();
		sData.put("Tag1", "Value1");

		Iso8583Postilion msg = new Iso8583Postilion();
		msg.setStructuredData(sData);

		assertTrue(msg
				.isPrivateFieldSet(Iso8583Postilion.PrivateBits._022_STRUCTURED_DATA));

		String structValue = msg
				.getPrivate(Iso8583Postilion.PrivateBits._022_STRUCTURED_DATA);

		assertEquals("14Tag116Value1", structValue);

	}
}
