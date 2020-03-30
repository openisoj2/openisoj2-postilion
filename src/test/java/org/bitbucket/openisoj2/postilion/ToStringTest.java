package org.bitbucket.openisoj2.postilion;

import org.bitbucket.openisoj2.postilion.structdata.StructuredData;
import org.junit.Test;

public class ToStringTest {

    @Test
    public void testToString() throws Exception{

        Iso8583Postilion msg = new Iso8583Postilion();
        msg.setMsgType(Iso8583Postilion.MsgType._0200_TRAN_REQ);
        msg.set(Iso8583Postilion.Bit._003_PROC_CODE,"010000");
        msg.setPrivate(Iso8583Postilion.PrivateBits._002_SWITCH_KEY,"123123123123");

        StructuredData structuredData = new StructuredData();
        structuredData.put("TEST","myname");
        structuredData.put("asdf","qwerty");
        msg.setStructuredData(structuredData);

        System.out.println(msg.toString());

    }

}
