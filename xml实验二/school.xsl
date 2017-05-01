<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<h3 align="center">老师信息列表</h3>
		<table border="1" bgcolor="#4EB7DE" align="center">
			<tr>
				<th>工号</th>
				<th>姓名</th>
				<th>课程</th>
				<th>年龄</th>
			</tr>
			<xsl:for-each select="School/Teachers/Teacher">
				<xsl:sort select="@age" order="ascending"/>
				<xsl:choose>
					<xsl:when test="@sex='女'">
					<a href="http://jsjxy.bistu.edu.cn/pubs/getTeacher?id=1513904736">
						<tr bgcolor="#ff00ff">
							<td>
								<xsl:value-of select="@number"/>
							</td>
							<td>
								<xsl:value-of select="name"/>
							</td>
							<td>
								<xsl:value-of select="whichsubject"/>
							</td>
							<td>
								<xsl:value-of select="@age"/>
							</td>
						</tr>
						</a>
					</xsl:when>
					<xsl:when test="@sex='男'">
						<tr>
							<td>
								<xsl:value-of select="@number"/>
							</td>
							<td>
								<xsl:value-of select="name"/>
							</td>
							<td>
								<xsl:value-of select="whichsubject"/>
							</td>
							<td>
								<xsl:value-of select="@age"/>
							</td>
						</tr>
					</xsl:when>
				</xsl:choose>
			</xsl:for-each>
		</table>
	</xsl:template>
</xsl:stylesheet>
