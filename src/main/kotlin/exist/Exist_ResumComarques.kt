package exist

import net.xqj.exist.ExistXQDataSource

fun main(){
    val s = ExistXQDataSource();
    s.setProperty("serverName", "89.36.214.106")
    val conn = s.getConnection()

    val sent="for \$comarca in //comarca order by \$comarca/nom return  (concat(\$comarca/nom/text(),\": \", count(\$comarca//pobles/poble)), sum(\$comarca//poblacio), count(\$comarca//pobles/poble/instituts/institut))"

    val cons = conn.prepareExpression (sent)
    val rs = cons.executeQuery ()

    while (rs.next()) {
        println(rs.getItemAsString(null))
    }
}