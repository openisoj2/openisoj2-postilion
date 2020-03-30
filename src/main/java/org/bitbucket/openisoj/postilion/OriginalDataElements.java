package org.bitbucket.openisoj.postilion;

import org.bitbucket.openisoj.Iso8583;
import org.bitbucket.openisoj.Utils;

public class OriginalDataElements
{
	private int		originalMsgType;
	private String	originalSysTrace;
	private String	originalTransmissionDateTime;
	private String	originalAcquirerInstIdCode;
	private String	originalForwardingInstIdCode;

	private String	originalData;

	public OriginalDataElements()
	{

	}

	public OriginalDataElements(String data)
	{
		this.originalData = data;
		fromMsg(this.originalData);
	}

	public void fromMsg(String originalData)
	{
		String msgType = originalData.substring(0, 4);
		this.originalMsgType = Iso8583.MsgType.toInt(msgType);

		this.originalSysTrace = originalData.substring(4, 10);
		this.originalTransmissionDateTime = originalData.substring(10, 20);
		this.originalAcquirerInstIdCode = originalData.substring(20, 31);
		while (this.originalAcquirerInstIdCode.startsWith("0"))
			this.originalAcquirerInstIdCode = this.originalAcquirerInstIdCode
					.substring(1);
		this.originalForwardingInstIdCode = originalData.substring(31, 42);
		while (this.originalForwardingInstIdCode.startsWith("0"))
			this.originalForwardingInstIdCode = this.originalForwardingInstIdCode
					.substring(1);

	}

	public String toMsg()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(Iso8583.MsgType.toString(this.originalMsgType));
		sb.append(this.originalSysTrace);
		sb.append(this.originalTransmissionDateTime);
		sb.append(Utils.padLeft(this.originalAcquirerInstIdCode, 11, '0'));
		sb.append(Utils.padLeft(this.originalForwardingInstIdCode, 11, '0'));
		return sb.toString();
	}

	public int getOriginalMsgType()
	{
		return originalMsgType;
	}

	public void setOriginalMsgType(int originalMsgType)
	{
		this.originalMsgType = originalMsgType;
	}

	public String getOriginalSysTrace()
	{
		return originalSysTrace;
	}

	public void setOriginalSysTrace(String originalSysTrace)
	{
		this.originalSysTrace = originalSysTrace;
	}

	public String getOriginalTransmissionDateTime()
	{
		return originalTransmissionDateTime;
	}

	public void setOriginalTransmissionDateTime(
			String originalTransmissionDateTime)
	{
		this.originalTransmissionDateTime = originalTransmissionDateTime;
	}

	public String getOriginalAcquirerInstIdCode()
	{
		return originalAcquirerInstIdCode;
	}

	public void setOriginalAcquirerInstIdCode(String originalAcquirerInstIdCode)
	{
		this.originalAcquirerInstIdCode = originalAcquirerInstIdCode;
	}

	public String getOriginalForwardingInstIdCode()
	{
		return originalForwardingInstIdCode;
	}

	public void setOriginalForwardingInstIdCode(
			String originalForwardingInstIdCode)
	{
		this.originalForwardingInstIdCode = originalForwardingInstIdCode;
	}
}
