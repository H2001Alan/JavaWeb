<%--
  Created by IntelliJ IDEA.
  User: 华仁伟
  Date: 2021/11/5
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="page_nav">
    <a href="${requestScope.page.url}&pageNo=1">首页</a>
    <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo-1>0?requestScope.page.pageNo-1:1}">
        ${requestScope.page.pageNo>1?"上一页":""}</a>
    <%--			<a>${requestScope.page.pageNo-1>0?"上一页":"已是第一页"}</a>--%>
    <c:choose>
        <c:when test="${requestScope.page.pageTotal<=5}">
            <c:forEach begin="1" end="${requestScope.page.pageTotal}" var="i">
                <c:if test="${i==requestScope.page.pageNo}">
                    【${requestScope.page.pageNo}】
                </c:if>
                <c:if test="${i!=requestScope.page.pageNo}">
                    <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
                </c:if>
            </c:forEach>
        </c:when>
        <c:when test="${requestScope.page.pageTotal>5}">
            <c:choose>
                <c:when test="${requestScope.page.pageNo<=3}">
                    <c:forEach begin="1" end="5" var="i">
                        <c:if test="${i==requestScope.page.pageNo}">
                            【${requestScope.page.pageNo}】
                        </c:if>
                        <c:if test="${i!=requestScope.page.pageNo}">
                            <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
                        </c:if>
                    </c:forEach>
                </c:when>
                <c:when test="${requestScope.page.pageNo>requestScope.page.pageTotal-3}">
                    <c:forEach begin="${requestScope.page.pageTotal-5}" end="${requestScope.page.pageTotal}" var="i">
                        <c:if test="${i==requestScope.page.pageNo}">
                            【${requestScope.page.pageNo}】
                        </c:if>
                        <c:if test="${i!=requestScope.page.pageNo}">
                            <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
                        </c:if>
                    </c:forEach>
                </c:when>
                <c:when test="${requestScope.page.pageNo>3||requestScope.page.pageNo<=requestScope.page.pageTotal-3}">
                    <c:forEach begin="${requestScope.page.pageNo-2}" end="${requestScope.page.pageNo+2}" var="i">
                        <c:if test="${i==requestScope.page.pageNo}">
                            【${requestScope.page.pageNo}】
                        </c:if>
                        <c:if test="${i!=requestScope.page.pageNo}">
                            <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
                        </c:if>
                    </c:forEach>
                </c:when>
            </c:choose>
        </c:when>
    </c:choose>
    <%--			【${requestScope.page.pageNo}】--%>
    <%--			<a>${requestScope.page.pageNo+1<requestScope.page.pageTotal?"下一页":"已是最后一页"}</a>--%>
    <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo<requestScope.page.pageTotal?requestScope.page.pageNo+1:requestScope.page.pageNo}">
        ${requestScope.page.pageNo<requestScope.page.pageTotal?"下一页":""}</a>
    <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}">末页</a>
    共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录
    到第<input value="${""}" name="pn" id="pn_input"/>页
    <input type="button" value="确定" id="searchPageBtn">
</div>
