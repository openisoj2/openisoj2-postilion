package org.bitbucket.openisoj2.postilion;

public class Utils
{
	public static final byte[] fromHexDataToBinData(byte hex_data[])
	{
		int len = hex_data.length / 2;
		byte data[] = new byte[len];
		int offset = 0;
		for (int i = 0; i < len; i++)
			data[i] = (byte) (getHexNibble(hex_data[offset++]) << 4 | getHexNibble(hex_data[offset++]));

		return data;
	}

	private static final byte getHexNibble(byte data)
	{
		if (data >= 48 && data <= 57)
			return (byte) (data & 0xf);
		if (data >= 65 && data <= 70)
			return (byte) (data - 55);
		if (data >= 97 && data <= 102)
			return (byte) (data - 87);
		else
			return 0;
	}

	public static byte[] fromHexStringToHexData(String hex_string)
	{
		if (hex_string.length() % 2 == 1)
			hex_string = '0' + hex_string;
		byte result[] = new byte[hex_string.length() / 2];
		for (int i = 0; i < result.length; i++)
		{
			String ss = hex_string.substring(i * 2, i * 2 + 2);
			result[i] = (byte) Integer.parseInt(ss, 16);
		}

		return result;
	}
}
