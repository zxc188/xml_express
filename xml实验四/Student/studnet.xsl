<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<body>
				<h3 align="center">学生信息表</h3>
				<table border="1" bgcolor="#4EB7DE" align="center">
					<tr>
						<th>姓名</th>
						<th>学号</th>
						<th>性别</th>
						<th>年龄</th>
						<th>电话</th>
					</tr>
					<xsl:for-each select="Students/Student">
						<tr>
							<td>
								<xsl:value-of select="name"/>
							</td>
							<td>
								<xsl:value-of select="number"/>
							</td>
							<td>
								<xsl:value-of select="@sex"/>
							</td>
							<td>
								<xsl:value-of select="@age"/>
							</td>
							<td>
								<xsl:value-of select="phone"/>
							</td>
						</tr>
					</xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>
