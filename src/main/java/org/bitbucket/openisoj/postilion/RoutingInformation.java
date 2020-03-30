package org.bitbucket.openisoj.postilion;

public class RoutingInformation
{
	private String	sourceNode;
	private String	sinkNode;
	private String	sourceSysTrace;
	private String	sinkSysTrace;
	private String	totalsGroup;

	private String	data;

	public RoutingInformation()
	{

	}

	public RoutingInformation(String data)
	{
		this.data = data;
		fromMsg(this.data);
	}

	public void fromMsg(String data)
	{
		// We now split up the fields
		this.sourceNode = data.substring(0, 12);
		while (this.sourceNode.endsWith(" "))
			this.sourceNode.substring(0, this.sourceNode.length() - 1);
		this.sinkNode = this.sourceNode.substring(12, 24);
		while (this.sinkNode.endsWith(" "))
			this.sinkNode = this.sinkNode.substring(0,
					this.sourceNode.length() - 1);

		this.sourceSysTrace = data.substring(24, 30);
		this.sinkSysTrace = data.substring(30, 36);

		this.totalsGroup = data.substring(36, 48);
		while (this.totalsGroup.endsWith(" "))
			this.totalsGroup = this.totalsGroup.substring(0,
					this.totalsGroup.length());
	}

	public String toMsg()
	{
		StringBuilder sb = new StringBuilder();
		return sb.toString();
	}

	public String getSourceNode()
	{
		return sourceNode;
	}

	public void setSourceNode(String sourceNode)
	{
		this.sourceNode = sourceNode;
	}

	public String getSinkNode()
	{
		return sinkNode;
	}

	public void setSinkNode(String sinkNode)
	{
		this.sinkNode = sinkNode;
	}

	public String getSourceSysTrace()
	{
		return sourceSysTrace;
	}

	public void setSourceSysTrace(String sourceSysTrace)
	{
		this.sourceSysTrace = sourceSysTrace;
	}

	public String getSinkSysTrace()
	{
		return sinkSysTrace;
	}

	public void setSinkSysTrace(String sinkSysTrace)
	{
		this.sinkSysTrace = sinkSysTrace;
	}

	public String getTotalsGroup()
	{
		return totalsGroup;
	}

	public void setTotalsGroup(String totalsGroup)
	{
		this.totalsGroup = totalsGroup;
	}
}
