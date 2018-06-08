<%-- we should not forget to import taglib --%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="listTitle">
    <h1>Recent Spittles</h1>
    <ul class="spittleList">
    <c:forEach items="${spittleList}" var="spittle" >
      <li id="spittle_<c:out value="spittle.id"/>">
        <div class="spittleMessage"><c:out value="${spittle.message}"/></div>
        <div>
          <span class="spittleTime"><c:out value="${spittle.time}" /></span>
          <span class="spittleLocation">(<c:out value="${spittle.latitude}" />, <c:out value="${spittle.longitude}" />)</span>
        </div>
      </li>
    </c:forEach>
    </ul>
</div>