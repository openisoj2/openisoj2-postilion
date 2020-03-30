package org.bitbucket.openisoj2.postilion;

import org.bitbucket.openisoj2.core.AMessage;
import org.bitbucket.openisoj2.core.Field;
import org.bitbucket.openisoj2.core.FieldDescriptor;
import org.bitbucket.openisoj2.core.IField;
import org.bitbucket.openisoj2.core.IFieldDescriptor;
import org.bitbucket.openisoj2.core.Template;
import org.bitbucket.openisoj2.core.exceptions.UnknownFieldException;
import org.bitbucket.openisoj2.core.fieldvalidator.FieldValidators;
import org.bitbucket.openisoj2.core.formatter.BinaryFormatter;
import org.bitbucket.openisoj2.postilion.Iso8583Postilion.PrivateBits;
import org.bitbucket.openisoj2.postilion.structdata.StructuredData;

public class PostilionPrivateFields extends AMessage
{

	private static Template	_postilionPrivTemplate;

	public PostilionPrivateFields()
	{
		super(_postilionPrivTemplate);
	}

	@Override
	protected IField createField(int field) throws UnknownFieldException
	{
		if (template.containsKey(field))
			return new Field(field, template.get(field));

		throw new UnknownFieldException(Integer.toString(field));
	}

	@Override
	protected String toString(int field, String prefix) throws Exception
	{
		if (field == Iso8583Postilion.PrivateBits._022_STRUCTURED_DATA)
		{
			String value = get(field);
			String filedDesc = _postilionPrivTemplate.get(field).display(
					prefix + "   ", field, "");
			StructuredData data = new StructuredData();
			data.unpack(value);

			String str = filedDesc + "\n" + data.toString();
			return str;
		}
		String value = get(field);
		return _postilionPrivTemplate.get(field).display(prefix + "   ",
				"127.", field, value);
	}

	static
	{
		try
		{
			_postilionPrivTemplate = new Template();

			_postilionPrivTemplate.put(
					PrivateBits._002_SWITCH_KEY,
					PostilionFieldDescriptor.getAsciiVar(2, 32,
							FieldValidators.getAns()));
			_postilionPrivTemplate
					.put(PrivateBits._003_ROUTING_INF0,
							FieldDescriptor.getAsciiFixed(48,
									FieldValidators.getAns()));
			_postilionPrivTemplate
					.put(PrivateBits._004_POS_DATA,
							FieldDescriptor.getAsciiFixed(22,
									FieldValidators.getAns()));
			_postilionPrivTemplate
					.put(PrivateBits._005_SERVICE_STATION_DATA,
							FieldDescriptor.getAsciiFixed(73,
									FieldValidators.getAns()));
			_postilionPrivTemplate.put(PrivateBits._006_AUTH_PROFILE,
					FieldDescriptor.getAsciiFixed(2, FieldValidators.getAn()));
			_postilionPrivTemplate
					.put(PrivateBits._007_CHECK_DATA,
							FieldDescriptor.getAsciiVar(2, 70,
									FieldValidators.getAns()));
			_postilionPrivTemplate.put(
					PrivateBits._008_RETENTION_DATA,
					FieldDescriptor.getAsciiVar(3, 999,
							FieldValidators.getAns()));
			_postilionPrivTemplate.put(
					PrivateBits._009_ADDITIONAL_NODE_DATA,
					FieldDescriptor.getAsciiVar(3, 999,
							FieldValidators.getAns()));
			_postilionPrivTemplate.put(PrivateBits._010_CVV2,
					FieldDescriptor.getAsciiAlphaNumeric(3));
			_postilionPrivTemplate
					.put(PrivateBits._011_ORIGINAL_KEY,
							FieldDescriptor.getAsciiVar(2, 32,
									FieldValidators.getAns()));
			_postilionPrivTemplate
					.put(PrivateBits._012_TERMINAL_OWNER,
							FieldDescriptor.getAsciiVar(2, 25,
									FieldValidators.getAns()));
			_postilionPrivTemplate.put(PrivateBits._013_POS_GEO_DATA,
					FieldDescriptor.getAsciiAns(17));
			_postilionPrivTemplate.put(PrivateBits._014_SPONSER_BANK,
					FieldDescriptor.getAsciiAns(8));
			_postilionPrivTemplate.put(
					PrivateBits._015_ADDRESS_VERIFICATION_DATA, FieldDescriptor
							.getAsciiVar(2, 29, FieldValidators.getAns()));
			_postilionPrivTemplate.put(
					PrivateBits._016_ADDRESS_VERIFICATION_RESULT,
					FieldDescriptor.getAsciiFixed(1, FieldValidators.getA()));
			_postilionPrivTemplate
					.put(PrivateBits._017_CARDHOLDER_INFO,
							FieldDescriptor.getAsciiVar(2, 50,
									FieldValidators.getAns()));
			_postilionPrivTemplate
					.put(PrivateBits._018_VALIDATION_DATA,
							FieldDescriptor.getAsciiVar(2, 50,
									FieldValidators.getAns()));
			_postilionPrivTemplate.put(PrivateBits._019_BANK_DETAILS,
					FieldDescriptor.getAsciiAns(31));
			_postilionPrivTemplate.put(
					PrivateBits._020_OTIGINATOR_AUTH_DATE_SETTLE,
					FieldDescriptor.getAsciiNumeric(8));
			_postilionPrivTemplate.put(PrivateBits._021_RECORD_IDENTIFICATION,
					FieldDescriptor.getAsciiAns(12));
			_postilionPrivTemplate.put(
					PrivateBits._022_STRUCTURED_DATA,
					FieldDescriptor.getAsciiVar(5, 99999,
							FieldValidators.getAns()));
			_postilionPrivTemplate.put(PrivateBits._023_PAYEE_NAME_ADDRESS,
					FieldDescriptor.getAsciiAns(253));
			_postilionPrivTemplate
					.put(PrivateBits._024_PAYEE_REFERENCE,
							FieldDescriptor.getAsciiVar(2, 28,
									FieldValidators.getAns()));
			_postilionPrivTemplate.put(
					PrivateBits._025_ICC_DATA,
					FieldDescriptor.getAsciiVar(4, 9999,
							FieldValidators.getAns()));
			_postilionPrivTemplate
					.put(PrivateBits._026_ORIGINAL_NODE,
							FieldDescriptor.getAsciiVar(2, 20,
									FieldValidators.getAns()));
			_postilionPrivTemplate.put(
					PrivateBits._027_CARD_VERIFICATION_RESULT,
					FieldDescriptor.getAsciiAns(1));
			_postilionPrivTemplate.put(PrivateBits._028_AMERICAN_EXP_CARD_ID,
					FieldDescriptor.getAsciiNumeric(4));
			_postilionPrivTemplate.put(PrivateBits._029_3D_SECURE_DATA,
					FieldDescriptor.getBinaryFixed(40));
			_postilionPrivTemplate.put(PrivateBits._030_3D_SECURE_RESULT,
					FieldDescriptor.getAsciiAns(1));
			_postilionPrivTemplate
					.put(PrivateBits._031_ISSUER_NETWORK_ID,
							FieldDescriptor.getAsciiVar(2, 11,
									FieldValidators.getAns()));
			_postilionPrivTemplate.put(PrivateBits._032_UCAF_DATA,
					FieldDescriptor.getBinaryVar(2, 33, new BinaryFormatter()));
			_postilionPrivTemplate.put(PrivateBits._033_EXTENDED_TRAN_TYPE,
					FieldDescriptor.getAsciiN(4));
			_postilionPrivTemplate.put(PrivateBits._034_ACC_TYPE_QUALIFIERS,
					FieldDescriptor.getAsciiN(2));
			_postilionPrivTemplate
					.put(PrivateBits._035_ACQUIRER_NETWORK_ID,
							FieldDescriptor.getAsciiVar(2, 11,
									FieldValidators.getAns()));
			_postilionPrivTemplate
					.put(PrivateBits._036_CUSTOMER_ID,
							FieldDescriptor.getAsciiVar(2, 25,
									FieldValidators.getAns()));
			_postilionPrivTemplate.put(PrivateBits._037_EXTENDED_RSP_CODE,
					FieldDescriptor.getAsciiAlphaNumeric(4));
			_postilionPrivTemplate
					.put(PrivateBits._038_ADDITIONAL_POS_DATA_CODE,
							FieldDescriptor.getAsciiVar(2, 99,
									FieldValidators.getAn()));
			_postilionPrivTemplate.put(PrivateBits._039_ORIGINAL_RSP_CODE,
					FieldDescriptor.getAsciiAlphaNumeric(2));
			_postilionPrivTemplate.put(
					PrivateBits._040_TRANSACTION_REFERENCE,
					FieldDescriptor.getAsciiVar(3, 512,
							FieldValidators.getAns()));
			_postilionPrivTemplate
					.put(PrivateBits._042_TRANSACTION_NUMBER,
							FieldDescriptor.getAsciiVar(2, 10,
									FieldValidators.getN()));
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			System.exit(1);
		}

	}

	@Override
	protected int unpack(byte[] msg, int startingOffset) throws Exception
	{

		return super.unpack(msg, startingOffset);
	}

	@Override
	protected byte[] toMsg() throws Exception
	{

		return super.toMsg();
	}

}
