package org.bitbucket.openisoj.postilion;

import java.nio.charset.Charset;
import java.nio.charset.spi.CharsetProvider;

import javax.rmi.CORBA.Util;

import org.bitbucket.openisoj.FieldDescriptor;
import org.bitbucket.openisoj.IField;
import org.bitbucket.openisoj.Iso8583;
import org.bitbucket.openisoj.Template;
import org.bitbucket.openisoj.exceptions.UnknownFieldException;
import org.bitbucket.openisoj.fieldvalidator.FieldValidators;
import org.bitbucket.openisoj.formatter.BinaryFormatter;
import org.bitbucket.openisoj.lengthformatters.VariableLengthFormatter;
import org.bitbucket.openisoj.postilion.structdata.StructuredData;

public class Iso8583Postilion extends Iso8583
{

	protected PostilionPrivateFields	_postilionPrivateFields;
	private static Template				_template;

	static
	{
		_template = getDefaultTemplate();
		try
		{
			_template.put(Bit._037_RETRIEVAL_REF_NUM, FieldDescriptor
					.getAsciiFixed(12, FieldValidators.getAnsp()));
			_template.put(Bit._038_AUTH_ID_RESPONSE, FieldDescriptor
					.getAsciiFixed(6, FieldValidators.getAnp()));
			_template
					.put(Bit._123_POS_DATA_CODE,
							FieldDescriptor.getAsciiVar(3, 15,
									FieldValidators.getAn()));

			_template.put(Bit._127_POSTILION_PRIVATE_BITS,
					new FieldDescriptor(new VariableLengthFormatter(6, 999999),
							FieldValidators.getNone(), new AsciiFormatter(
									"windows-1256"), null, null));

			// _template.put(
			// Bit._127_POSTILION_PRIVATE_BITS,
			// FieldDescriptor.getAsciiVar(6, 999999,
			// FieldValidators.getNone()));
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			System.exit(1);
		}
	}

	public Iso8583Postilion()
	{
		this(_template);

	}

	public Iso8583Postilion(Template template)
	{
		super(template);
		_postilionPrivateFields = new PostilionPrivateFields();
	}

	public Iso8583Postilion(byte[] data) throws Exception
	{
		this();
		unpack(data, 0);
	}

	public class Bit extends Iso8583.Bit
	{
		public static final int	_123_POS_DATA_CODE			= 123;
		public static final int	_127_POSTILION_PRIVATE_BITS	= 127;
	}

	public class MsgType extends Iso8583.MsgType
	{
		public static final int	_9120_AUTH_NOTIF				= 0x9120;
		public static final int	_9121_AUTH_NOTIF_REP			= 0x9121;
		public static final int	_9130_AUTH_NOTIF_RSP			= 0x9130;
		public static final int	_9220_TRAN_NOTIF				= 0x9220;
		public static final int	_9221_TRAN_NOTIF_REP			= 0x9221;
		public static final int	_9230_TRAN_NOTIF_RSP			= 0x9230;
		public static final int	_9320_ACQ_FILE_UPDATE_NOTIF		= 0x9320;
		public static final int	_9321_ACQ_FILE_UPDATE_NOTIF_REP	= 0x9321;
		public static final int	_9330_ACQ_FILE_UPDATE_NOTIF_RSP	= 0x9330;
		public static final int	_9420_REVERSAL_NOTIF			= 0x9420;
		public static final int	_9421_REVERSAL_NOTIF_REP		= 0x9421;
		public static final int	_9430_REVERSAL_NOTIF_RSP		= 0x9430;
		public static final int	_9620_ADMIN_NOTIF				= 0x9620;
		public static final int	_9621_ADMIN_NOTIF_REP			= 0x9621;
		public static final int	_9630_ADMIN_NOTIF_RSP			= 0x9630;

	}

	public class PrivateBits
	{
		public static final int	_002_SWITCH_KEY						= 2;
		public static final int	_003_ROUTING_INF0					= 3;
		public static final int	_004_POS_DATA						= 4;
		public static final int	_005_SERVICE_STATION_DATA			= 5;
		public static final int	_006_AUTH_PROFILE					= 6;
		public static final int	_007_CHECK_DATA						= 7;
		public static final int	_008_RETENTION_DATA					= 8;
		public static final int	_009_ADDITIONAL_NODE_DATA			= 9;
		public static final int	_010_CVV2							= 10;
		public static final int	_011_ORIGINAL_KEY					= 11;
		public static final int	_012_TERMINAL_OWNER					= 12;
		public static final int	_013_POS_GEO_DATA					= 13;
		public static final int	_014_SPONSER_BANK					= 14;
		public static final int	_015_ADDRESS_VERIFICATION_DATA		= 15;
		public static final int	_016_ADDRESS_VERIFICATION_RESULT	= 16;
		public static final int	_017_CARDHOLDER_INFO				= 17;
		public static final int	_018_VALIDATION_DATA				= 18;
		public static final int	_019_BANK_DETAILS					= 19;
		public static final int	_020_OTIGINATOR_AUTH_DATE_SETTLE	= 20;
		public static final int	_021_RECORD_IDENTIFICATION			= 21;
		public static final int	_022_STRUCTURED_DATA				= 22;
		public static final int	_023_PAYEE_NAME_ADDRESS				= 23;
		public static final int	_024_PAYEE_REFERENCE				= 24;
		public static final int	_025_ICC_DATA						= 25;
		public static final int	_026_ORIGINAL_NODE					= 26;
		public static final int	_027_CARD_VERIFICATION_RESULT		= 27;
		public static final int	_028_AMERICAN_EXP_CARD_ID			= 28;
		public static final int	_029_3D_SECURE_DATA					= 29;
		public static final int	_030_3D_SECURE_RESULT				= 30;
		public static final int	_031_ISSUER_NETWORK_ID				= 31;
		public static final int	_032_UCAF_DATA						= 32;
		public static final int	_033_EXTENDED_TRAN_TYPE				= 33;
		public static final int	_034_ACC_TYPE_QUALIFIERS			= 34;
		public static final int	_035_ACQUIRER_NETWORK_ID			= 35;
		public static final int	_036_CUSTOMER_ID					= 36;
		public static final int	_037_EXTENDED_RSP_CODE				= 37;
		public static final int	_038_ADDITIONAL_POS_DATA_CODE		= 38;
		public static final int	_039_ORIGINAL_RSP_CODE				= 39;
		public static final int	_040_TRANSACTION_REFERENCE			= 40;
		public static final int	_042_TRANSACTION_NUMBER				= 42;

	}

	@Override
	public int unpack(byte[] msg, int startingOffset) throws Exception
	{
		int offset = super.unpack(msg, startingOffset);
		if (this.isFieldSet(Iso8583Postilion.Bit._127_POSTILION_PRIVATE_BITS))
		{
			String data = this
					.get(Iso8583Postilion.Bit._127_POSTILION_PRIVATE_BITS);
			byte[] privateData = data.getBytes("windows-1256");
			_postilionPrivateFields.unpack(privateData, 0);
		}
		return offset;
	}

	@Override
	public byte[] toMsg() throws Exception
	{

		return toMsg2();

		// System.out.println(Charset.defaultCharset());
		// byte[] privateFields = _postilionPrivateFields.toMsg();
		// System.out.println(asHex(privateFields));
		// BinaryFormatter formatter = new BinaryFormatter();
		// String data = formatter.getString(privateFields);
		//
		// byte[] binString = Utils.fromHexStringToHexData(data);
		// System.out.println(asHex(binString));
		//
		// // byte[] hexData = Utils.fromHexDataToBinData(data.getBytes());
		// // System.out.println(asHex(hexData));
		// IField privField = this.getField(127);
		// String newBinString = new String(binString, "windows-1256");
		// System.out.println(asHex(newBinString.getBytes("windows-1256")));
		// System.out.println(newBinString);
		// privField.setValue(new String(binString, "windows-1256"));
		//
		// return super.toMsg();

		// byte[] privateFields = _postilionPrivateFields.toMsg();
		// this.set(Iso8583Postilion.Bit._127_POSTILION_PRIVATE_BITS, new
		// String(
		// privateFields));
		// String fieldData = super.get(127);
		// System.out.println(asHex(fieldData.getBytes()));
		// byte[] packed = super.toMsg();
		// return packed;
	}

	public byte[] toMsg2() throws Exception
	{
		byte[] privateFields = _postilionPrivateFields.toMsg();

		BinaryFormatter binFormatter = new BinaryFormatter();
		String data = binFormatter.getString(privateFields);
		byte[] binData = Utils.fromHexStringToHexData(data);
		IField privField = this.getField(127);
		privField.setValue(new String(binData, "windows-1256"));

		return super.toMsg();

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

	public boolean isPrivateFieldSet(int privateField)
	{
		return _postilionPrivateFields.isFieldSet(privateField);
	}

	public void clearPrivateField(int privateField)
	{
		_postilionPrivateFields.clearField(privateField);
	}

	public void setPrivate(int privateField, String value) throws Exception
	{

		_postilionPrivateFields.set(privateField, value);
		// byte[] privateData = _postilionPrivateFields.toMsg();
		// IField privField = this.getField(127);
		// privField.setValue(new String(privateData));
		// set(Iso8583Postilion.Bit._127_POSTILION_PRIVATE_BITS, new String(
		// privateData));
	}

	public String getPrivate(int privateField)
	{
		return _postilionPrivateFields.get(privateField);
	}

	public StructuredData getStructuredData() throws Exception
	{
		if (isPrivateFieldSet(Iso8583Postilion.PrivateBits._022_STRUCTURED_DATA))
		{
			StructuredData data = new StructuredData();
			data.unpack(getPrivate(Iso8583Postilion.PrivateBits._022_STRUCTURED_DATA));
			return data;
		}

		return null;
	}

	public void setStructuredData(StructuredData structuredData)
			throws Exception
	{
		clearPrivateField(Iso8583Postilion.PrivateBits._022_STRUCTURED_DATA);
		String unpacked = structuredData.toMsg();
		setPrivate(Iso8583Postilion.PrivateBits._022_STRUCTURED_DATA, unpacked);
	}

	public OriginalDataElements getOriginalDataElements() throws Exception
	{
		if (isFieldSet(Iso8583.Bit._090_ORIGINAL_DATA_ELEMENTS))
		{
			OriginalDataElements elements = new OriginalDataElements();
			elements.fromMsg(get(Iso8583.Bit._090_ORIGINAL_DATA_ELEMENTS));
			return elements;
		}

		return null;
	}

	public void setOriginalDataElements(
			OriginalDataElements originalDataElements) throws Exception
	{
		clearField(Iso8583.Bit._090_ORIGINAL_DATA_ELEMENTS);
		String unpacked = originalDataElements.toMsg();
		set(Iso8583.Bit._090_ORIGINAL_DATA_ELEMENTS, unpacked);
	}

	@Override
	protected String toString(int field, String prefix) throws Exception
	{
		if (field == Bit._127_POSTILION_PRIVATE_BITS)
		{

			return _postilionPrivateFields.toString();
		}

		return super.toString(field, prefix);
	}

}