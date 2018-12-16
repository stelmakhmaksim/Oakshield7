<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
</form>
</div>
<div class="inner">
<section>
<%
    Map<String, List<List<String>>> tables = (Map<String, List<List<String>>>) request.getAttribute("tables");
    for (String tableName : tables.keySet()) {
%>
<table style="table-wrapper" id="<%= tableName %>" border=1></table>
<%
    }
    for (Map.Entry<String, List<List<String>>> table : tables.entrySet()) {
        String tableName = table.getKey();
        List<List<String>> tableData = table.getValue();
        String tableHeader = tableData.stream().limit(1).map(
                row -> row.stream().collect(Collectors.joining("\",\"", "[\"", "\"]"))
        ).findFirst().get();
        String tableArray = tableData.stream().skip(1).map(
                row -> row.stream().collect(Collectors.joining("\",\"", "[\"", "\"]"))
        ).collect(Collectors.joining(",", "[", "]"));
%>
<script>
    generateTable("<%= tableName %>", <%= tableHeader %>, <%= tableArray %>);
</script>
<%
    }
%>
</section>
</div>
</body>
</html>