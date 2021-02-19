package org.bitbucket.openisoj2.postilion.structdata;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class StructuredData extends LinkedHashMap<String, String>
{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= -4487506875951903381L;

	public void unpack(String msg) throws Exception
	{
		clear();
		int offset = 0;
		while (offset < msg.length())
		{
			int lengthOfLength = readOneByte(msg, offset);
			offset++;
			// We now read the length indicator
			int lengthIndicator = readLength(msg, offset, lengthOfLength);
			offset += lengthOfLength;
			// We now need to read in the data
			String key = readString(msg, offset, lengthIndicator);
			offset += key.length();

			// We now read in the value
			int lengthOfLengthValue = readOneByte(msg, offset);
			offset++;
			int lengthIndicatorValue = readLength(msg, offset,
					lengthOfLengthValue);
			offset += lengthOfLengthValue;

			String value = readString(msg, offset, lengthIndicatorValue);
			offset += value.length();

			put(key, value);
		}

	}

	private String readString(String msg, int offset, int lengthIndicator)
	{
		String data = msg.substring(offset, offset + lengthIndicator);
		if (data.getBytes().length > data.length()) {
			//utf8 characters
			return msg.substring(offset, offset + lengthIndicator - (data.getBytes().length - data.length()));
		}
		return data;
	}

	private int readLength(String msg, int offset, int lengthOfLength)
	{
		String data = msg.substring(offset, offset + lengthOfLength);
		return Integer.parseInt(data);
	}

	private int readOneByte(String msg, int offset) throws Exception
	{
		String data = msg.substring(offset, offset + 1);
		return Integer.parseInt(data);
	}

	public String toMsg() throws Exception
	{
		StringBuilder sb = new StringBuilder();
		if (size() > 0)
		{
			for (java.util.Map.Entry<String, String> entries : this.entrySet())
			{
				String key = entries.getKey();
				String value = entries.getValue();

				sb.append(getLengthOfLength(key));
				sb.append(getLength(key));
				sb.append(key);
				sb.append(getLengthOfLength(value));
				sb.append(getLength(value));
				sb.append(value);
			}
		}
		return sb.toString();
	}

	private int getLength(String key)
	{
		return key.length();
	}

	private int getLengthOfLength(String key)
	{
		int length = key.length();
		String lenStr = Integer.toString(length);
		return lenStr.length();
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		if (size() > 0)
		{
			for (java.util.Map.Entry<String, String> entries : this.entrySet())
			{
				String key = entries.getKey();
				String value = entries.getValue();
				sb.append("\t\t[").append(key).append("] - [").append(value)
						.append("]").append("\n");
			}
		}

		return sb.toString();
	}

}
