package org.bitbucket.openisoj.postilion;

import org.bitbucket.openisoj.Iso8583;

public class Test
{

	public static void main(String[] args) throws Exception
	{

		Iso8583Postilion msg = new Iso8583Postilion();
		msg.setMsgType(Iso8583Postilion.MsgType._0100_AUTH_REQ);

		msg.set(Iso8583Postilion.Bit._002_PAN, "5888920009081097");
		msg.set(Iso8583Postilion.Bit._003_PROC_CODE, "500000");
		msg.set(Iso8583Postilion.Bit._004_TRAN_AMOUNT, "000000000001");
		msg.set(Iso8583Postilion.Bit._007_TRAN_DATE_TIME, "0131082422");
		msg.set(Iso8583Postilion.Bit._011_SYS_TRACE_AUDIT_NUM, "000042");
		msg.set(Iso8583Postilion.Bit._012_LOCAL_TRAN_TIME, "102422");
		msg.set(Iso8583Postilion.Bit._013_LOCAL_TRAN_DATE, "0131");
		msg.set(Iso8583Postilion.Bit._014_EXPIRATION_DATE, "9912");
		msg.set(Iso8583Postilion.Bit._015_SELLTLEMENT_DATE, "0123");
		msg.set(Iso8583Postilion.Bit._018_MERCHANT_TYPE, "5411");
		msg.set(Iso8583Postilion.Bit._022_POS_ENTRY_MODE, "901");
		msg.set(Iso8583Postilion.Bit._025_POS_CONDITION_CODE, "00");
		msg.set(Iso8583Postilion.Bit._026_POS_PIN_CAPTURE_CODE, "00");
		msg.set(Iso8583Postilion.Bit._028_TRAN_FEE_AMOUNT, "D00000020");
		msg.set(Iso8583Postilion.Bit._030_TRAN_PROC_FEE_AMOUNT, "C00000000");
		msg.set(Iso8583Postilion.Bit._035_TRACK_2_DATA,
				"5888920009081097D9912501");
		msg.set(Iso8583Postilion.Bit._037_RETRIEVAL_REF_NUM, "013147061097");
		msg.set(Iso8583Postilion.Bit._040_SERVICE_RESTRICTION_CODE, "501");
		msg.set(Iso8583Postilion.Bit._041_CARD_ACCEPTOR_TERMINAL_ID, "08260302");
		msg.set(Iso8583Postilion.Bit._042_CARD_ACCEPTOR_ID_CODE,
				"000000008260302");
		msg.set(Iso8583Postilion.Bit._043_CARD_ACCEPTOR_NAME_LOCATION,
				"EFT CORP TEST SITE     HARARE       00ZW");
		msg.set(Iso8583Postilion.Bit._049_TRAN_CURRENCY_CODE, "840");
		msg.set(Iso8583Postilion.Bit._052_PIN_DATA, "D0F12DD404A1140E");
		msg.set(Iso8583Postilion.Bit._056_MESSAGE_REASON_CODE, "1510");
		msg.set(Iso8583Postilion.Bit._098_PAYEE, "DSTV                     ");
		msg.set(Iso8583Postilion.Bit._100_RECEIVING_INST_ID_CODE, "999");
		msg.set(Iso8583Postilion.Bit._123_POS_DATA_CODE, "200101214001101");
		msg.setPrivate(Iso8583Postilion.PrivateBits._002_SWITCH_KEY,
				"AT60744060");
		msg.setPrivate(Iso8583Postilion.PrivateBits._003_ROUTING_INF0,
				"SchemeSrce  PostIntSnk  000120000042TextACashGrp");
		msg.setPrivate(Iso8583Postilion.PrivateBits._004_POS_DATA,
				"0826030219470600001097");
		msg.setPrivate(Iso8583Postilion.PrivateBits._009_ADDITIONAL_NODE_DATA,
				"15||||1097|POS ops|||||||||||||||||");
		msg.setPrivate(Iso8583Postilion.PrivateBits._011_ORIGINAL_KEY,
				"0060744060");
		msg.setPrivate(Iso8583Postilion.PrivateBits._013_POS_GEO_DATA,
				"04263263      716");
		msg.setPrivate(Iso8583Postilion.PrivateBits._014_SPONSER_BANK,
				"CABS    ");
		msg.setPrivate(
				Iso8583Postilion.PrivateBits._020_OTIGINATOR_AUTH_DATE_SETTLE,
				"20130129");

		byte[] packedMsg = msg.toMsg();

		Iso8583Postilion unpacked = new Iso8583Postilion();
		unpacked.unpack(packedMsg, 0);
		System.out.println(unpacked);
		
		
	
		
	}

	public static String asHex(byte buf[])
	{
		StringBuffer strbuf = new StringBuffer(buf.length * 2);

		for (int i = 0; i < buf.length; i++)
		{
			if (((int) buf[i] & 0xff) < 0x10)
				strbuf.append("0");
			strbuf.append(Long.toString((int) buf[i] & 0xff, 16));
			strbuf.append(" ");
		}
		return strbuf.toString();
	}
}
