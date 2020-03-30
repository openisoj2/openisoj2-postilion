package org.bitbucket.openisoj.postilion;

import static org.junit.Assert.*;

import org.bitbucket.openisoj.postilion.structdata.StructuredData;
import org.junit.Test;

public class StructuredDataTests
{
	@Test
	public void testPacking() throws Exception
	{
		StructuredData sData = new StructuredData();
		sData.put("TestTag", "TestValue");

		assertEquals("17TestTag19TestValue", sData.toMsg());
	}

	@Test
	public void testMultiplePacking() throws Exception
	{
		StructuredData sData = new StructuredData();
		sData.put("Tag1", "Value1");
		sData.put("Tag2", "Value2");

		assertEquals("14Tag116Value114Tag216Value2", sData.toMsg());
	}
}
