package org.bitbucket.openisoj2.postilion;

import java.nio.charset.Charset;

import org.bitbucket.openisoj2.core.formatter.IFormatter;

public class AsciiFormatter implements IFormatter
{

	private String	stringEncoding;

	public AsciiFormatter()
	{
		// By default we need to use the default charset
		this.stringEncoding = Charset.defaultCharset().name();
	}

	public AsciiFormatter(String encoding)
	{
		this.stringEncoding = encoding;
	}

	public byte[] getBytes(String value) throws Exception
	{
		return value.getBytes(stringEncoding);
	}

	public int getPackedLength(int unpackedLength) throws Exception
	{
		return unpackedLength;
	}

	public String getString(byte[] data) throws Exception
	{
		return new String(data, stringEncoding);
	}

}
