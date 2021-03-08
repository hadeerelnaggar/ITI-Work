<?xml version="1.0" encoding="UTF-8" ?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h2>cd catalog</h2>
                <xsl:apply-templates/>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="catalog">
        <table>
            <tr>
                <th>Title</th>
                <th>Artist</th>
                <th>Price</th>
            </tr>
            <xsl:for-each select="cd[year &gt; 1990]">
                <xsl:sort select="country"/>
                <tr>
                    <xsl:apply-templates select="title"/>
                    <xsl:apply-templates select="artist"/>
                    <xsl:apply-templates select="price"/>
                </tr>
            </xsl:for-each>
        </table>
    </xsl:template>
    <xsl:template match="title">
        <td>
            <xsl:value-of select="."/>
        </td>
    </xsl:template>
    <xsl:template match="artist">
        <td>
            <xsl:value-of select="."/>
        </td>
    </xsl:template>
    <xsl:template match="price">
        <xsl:choose>
            <xsl:when test=". &gt; 10">
                <td bgcolor="#D32F2F" style="color:#FFFFFF">
                    <xsl:value-of select="price"/>
                </td>
            </xsl:when>
            <xsl:when test=". &gt; 8">
                <td bgcolor="#1976D2" style="color:#FFFFFF">
                    <xsl:value-of select="price"/>
                </td>
            </xsl:when>
            <xsl:when test=". &lt; 8">
                <td bgcolor="#388E3C" style="color:#FFFFFF">
                    <xsl:value-of select="price"/>
                </td>
            </xsl:when>
        </xsl:choose>
    </xsl:template>
</xsl:stylesheet>