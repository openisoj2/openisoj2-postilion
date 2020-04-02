package org.bitbucket.openisoj2.postilion;

import org.bitbucket.openisoj2.postilion.structdata.StructuredData;
import org.junit.Test;

public class ToStringTest {

    @Test
    public void testToString() throws Exception{

        Iso8583Postilion msg = new Iso8583Postilion();
        msg.setMsgType(Iso8583Postilion.MsgType._0200_TRAN_REQ);
        msg.set(Iso8583Postilion.Bit._003_PROC_CODE,"010000");
//        msg.setPrivate(Iso8583Postilion.PrivateBits._002_SWITCH_KEY,"123123123123");

        StructuredData structuredData = new StructuredData();
        structuredData.put("TEST","myname");
        structuredData.put("asdf","qwerty");
//        msg.setStructuredData(structuredData);

//        System.out.println(msg);

        Iso8583Postilion rsp = new Iso8583Postilion();
        rsp.setMsgType(Iso8583Postilion.MsgType._0810_NWRK_MNG_REQ_RSP);
        rsp.set(Iso8583Postilion.Bit._039_RESPONSE_CODE, "00");
        rsp.set(Iso8583Postilion.Bit._070_NETWORK_MANAGEMENT_INFORMATION_CODE,
                "123");
        rsp.setPrivate(Iso8583Postilion.PrivateBits._002_SWITCH_KEY,
                "121123123213213");
//        rsp.clearPrivateField(Iso8583Postilion.PrivateBits._002_SWITCH_KEY);

        System.out.println(rsp);

    }

}
