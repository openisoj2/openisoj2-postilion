package org.bitbucket.openisoj.postilion;

import org.bitbucket.openisoj.FieldDescriptor;
import org.bitbucket.openisoj.Utils;
import org.bitbucket.openisoj.fieldvalidator.IFieldValidator;
import org.bitbucket.openisoj.lengthformatters.ILengthFormatter;

public class PostilionFieldDescriptor extends FieldDescriptor
{

	public PostilionFieldDescriptor(ILengthFormatter lengthFormatter,
			IFieldValidator validator) throws Exception
	{
		super(lengthFormatter, validator);
	}

	@Override
	public String display(String prefix, int fieldFieldNr, String value)
			throws Exception
	{
		String fieldValue = value == null ? "" : value;

		StringBuilder sb = new StringBuilder();
		sb.append(prefix);
		sb.append("[");
		sb.append(Utils.padRight(lengthFormatter.getDescription(), 7, ' '));
		sb.append(Utils.padRight(validator.getDescription(), 4, ' '));
		sb.append(Utils.padLeft(lengthFormatter.getMaxLength(), 5, ' '));
		sb.append(" ");
		sb.append(Utils.padLeft("" + fieldValue.length(), 3, '0'));
		sb.append("] ");
		String postilionFieldNr = getPostFieldNr(fieldFieldNr);
		sb.append(postilionFieldNr);
		sb.append(" ");
		sb.append("[");
		sb.append(fieldValue);
		sb.append("]");

		return sb.toString();
	}

	private String getPostFieldNr(int fieldFieldNr)
	{
		String nr = "127.";
		String field = Utils.padLeft("" + fieldFieldNr, 3, '0');
		return nr + field;
	}
}
