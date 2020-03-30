package org.bitbucket.openisoj.postilion;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AuthIdFormattingTest
{
	@Test
	public void testAlphaNumericPadAuthId() throws Exception{
		
		String expectedAuthId = "A1234 ";
		Iso8583Postilion msg = new Iso8583Postilion();
		msg.set(Iso8583Postilion.Bit._038_AUTH_ID_RESPONSE, expectedAuthId);
		
		byte[] msgData = msg.toMsg();
		
		Iso8583Postilion parsedMsg = new Iso8583Postilion();
		parsedMsg.unpack(msgData, 0);
		
		String authId = parsedMsg.get(Iso8583Postilion.Bit._038_AUTH_ID_RESPONSE);
		assertEquals(expectedAuthId, authId);	
	}
}
