<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" omit-xml-declaration="yes"/>
    <xsl:template match="/">
        <html>
            <head>
                <styles>
                </styles>
            </head>
            <body>
                <h1><b><i>Режиссеры</i></b></h1>
                <table>
                    <tr>
                        <th>id</th>
                        <th>Имя</th>
                    </tr>
                    <xsl:apply-templates/>
                </table>
            </body>
        </html>
    </xsl:template>
    <xsl:template match="director">
        <tr>
            <td>
                <xsl:value-of select="@id"/>
            </td>
            <td>
                <xsl:value-of select="@name"/>
            </td>
        </tr>
    </xsl:template>
</xsl:stylesheet>