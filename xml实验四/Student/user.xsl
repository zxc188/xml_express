<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<body>
				<h3 align="center">管理员表</h3>
				<table border="1" bgcolor="#4EB7DE" align="center">
					<tr>
						<th>username</th>
						<th>password</th>
					</tr>
					<xsl:for-each select="login/username">
						<xsl:choose>
							<xsl:when test="@blo=1">
								<tr>
									<td>
										<xsl:value-of select="."/>
									</td>
									<td>
										<xsl:value-of select="@password"/>
									</td>
								</tr>
							</xsl:when>
						</xsl:choose>
					</xsl:for-each>
				</table>
				<h3 align="center">普通用户表</h3>
				<table border="1" bgcolor="#4EB7DE" align="center">
					<tr>
						<th>username</th>
						<th>password</th>
					</tr>
					<xsl:for-each select="login/username">
						<xsl:choose>
							<xsl:when test="@blo=2">
								<tr>
									<td>
										<xsl:value-of select="."/>
									</td>
									<td>
										<xsl:value-of select="@password"/>
									</td>
								</tr>
							</xsl:when>
						</xsl:choose>
					</xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>
