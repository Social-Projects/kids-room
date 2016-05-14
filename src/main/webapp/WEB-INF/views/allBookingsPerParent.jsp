<%@ page isELIgnored="false" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<c:url value="/j_spring_security_check" var="allBookingsPerParentURL" />
<script src="resources/js/exportIntoExcel.js"></script>

    <div id="tableToExport">
        <table>
            <caption>
                <h2>
                    <spring:message code="report.parentBookings" /> ${parent}</br>
                    <span class="smallText">(${dateThen} - ${dateNow})</span>
                </h2>
            </caption>

            <tr>
                <th><spring:message code="report.date" /></th>
                <th><spring:message code="report.kid" /></th>
                <th><spring:message code="report.place" /></th>
                <th><spring:message code="report.startTime" /></th>
                <th><spring:message code="report.endTime" /></th>
                <th><spring:message code="report.duration" /></th>
                <th><spring:message code="report.sum" /></th>
            </tr>

            <c:forEach var="booking" items="${bookings}">
            <tr>
                <td>${booking.extractMonthAndDay()}</td>
                <td>${booking.getIdChild()}</td>
                <td>${booking.getIdRoom()}</td>
                <td>${booking.extractHourAndMinuteFromStartTime()}</td>
                <td>${booking.extractHourAndMinuteFromEndTime()}</td>
                <td>${booking.getDuration()}</td>
                <td>${booking.getSum(booking.getDuration())}</td>
            </tr>
            </c:forEach>

            <caption class="captionBottom">
                <p>
                    <spring:message code="report.sumTotal" /> ${sumTotal}
                </p>
            </caption>

        </table>
    </div>

    <input type="button" id="exportButton" value="Export into Excel" class="myButton">