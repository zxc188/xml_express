<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">	
<h3 align="center">课程信息列表</h3>
		<table border="1" bgcolor="#4EB7DE" align="center">
			<tr>
				<th>课程号</th>
				<th>课程名</th>
				<th>授课老师</th>
			</tr>
			<xsl:for-each select="School/Subjects/Subject">
				
						<tr bgcolor="#ff00ff">
							<td>
								<xsl:value-of select="@NumofSub"/>
							</td>
							<td>
								<xsl:value-of select="NameofSub"/>
							</td>
							<td>
								<xsl:value-of select="classroom"/>
							</td>
						</tr>
			</xsl:for-each>
		</table>		
	</xsl:template>
</xsl:stylesheet>
