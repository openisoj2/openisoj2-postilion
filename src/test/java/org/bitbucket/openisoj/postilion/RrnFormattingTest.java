package org.bitbucket.openisoj.postilion;

import static org.junit.Assert.*;

import org.bitbucket.openisoj.exceptions.UnknownFieldException;
import org.junit.Test;

public class RrnFormattingTest
{

	@Test
	public void testAlphaNumericRrn() throws Exception{
		
		String expectedRrn = "AB0000000001";
		Iso8583Postilion msg = new Iso8583Postilion();
		msg.set(Iso8583Postilion.Bit._037_RETRIEVAL_REF_NUM, expectedRrn);
		
		byte[] msgData = msg.toMsg();
		
		Iso8583Postilion parsedMsg = new Iso8583Postilion();
		parsedMsg.unpack(msgData, 0);
		
		String rrn = parsedMsg.get(Iso8583Postilion.Bit._037_RETRIEVAL_REF_NUM);
		assertEquals(expectedRrn, rrn);
		
	}
	
}
